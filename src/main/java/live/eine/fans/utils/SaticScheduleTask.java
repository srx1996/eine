package live.eine.fans.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * 定时任务
 */
//@Configuration      //1.主要用于标记配置类，兼备Component的效果。
//@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {
    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
//    @Scheduled(fixedRate = 60000)
    private void configureTasks() {

        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
