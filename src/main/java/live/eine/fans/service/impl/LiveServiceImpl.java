package live.eine.fans.service.impl;

import com.alibaba.fastjson.JSONObject;
import live.eine.fans.pojo.EineLive;
import live.eine.fans.service.LiveService;
import live.eine.fans.utils.PostUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LiveServiceImpl implements LiveService {
    private static EineLive eineLive = new EineLive();

    public EineLive postLiveInfoBySchedule(Integer roomId) throws Exception {
        String json = PostUtil.post("https://api.live.bilibili.com/room/v1/Room/get_info?id=" + roomId);
        JSONObject jsonObject = JSONObject.parseObject(json);
        String data = jsonObject.get("data").toString();
        eineLive = JSONObject.parseObject(data, EineLive.class);
        return eineLive;
    }

    @Scheduled(fixedRate = 60000)
    public void scheduleTask() throws Exception {
        postLiveInfoBySchedule(eineLive.getRoom_id() == null ? 21403601 : eineLive.getRoom_id());
    }

    @Override
    public EineLive getLiveInfo(Integer roomId) throws Exception {
        if (eineLive == null || roomId != eineLive.getRoom_id()) {
            return postLiveInfoBySchedule(roomId);
        }
        return eineLive;
    }
}
