package live.eine.fans.service.impl;

import com.alibaba.fastjson.JSONObject;
import live.eine.fans.pojo.EineLive;
import live.eine.fans.service.LiveService;
import live.eine.fans.utils.PostUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableScheduling
public class LiveServiceImpl implements LiveService {
    private static EineLive eineLive;
    private static Integer globalRoomId = 21403601;

    public EineLive postLiveInfoBySchedule(Integer roomId) throws Exception {
        String json = PostUtil.post("https://api.live.bilibili.com/room/v1/Room/get_info?id=" + roomId);
        JSONObject jsonObject = JSONObject.parseObject(json);
        String data = jsonObject.get("data").toString();
        eineLive = JSONObject.parseObject(data, EineLive.class);
        log.info("发送一次请求获取直播信息:{}", data);
        return eineLive;
    }

    @Scheduled(fixedRate = 30000)
    public void scheduleTask() throws Exception {
        postLiveInfoBySchedule(globalRoomId);
    }

    @Override
    public EineLive getLiveInfo(Integer roomId) throws Exception {
        if (eineLive == null || !globalRoomId.equals(roomId)) {
            globalRoomId = roomId;
            return postLiveInfoBySchedule(roomId);
        }
        return eineLive;
    }
}
