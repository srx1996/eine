package live.eine.fans.controller;

import com.alibaba.fastjson.JSONObject;
import live.eine.fans.pojo.EineLive;
import live.eine.fans.service.LiveService;
import live.eine.fans.utils.PostUtil;
import live.eine.fans.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直播间信息处理器
 */
@RestController
@EnableScheduling   // 2.开启定时任务
public class LiveController {
    @Autowired
    LiveService liveService;

    @GetMapping("/live-info/{roomId}")
    public R getLiveInfo(@PathVariable Integer roomId) throws Exception {
        EineLive eineLive = liveService.getLiveInfo(roomId);
        if (eineLive == null) {
            R.error("api错误");
        }
        return R.ok().put("eineLive", eineLive);
    }


}
