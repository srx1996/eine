package live.eine.fans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EineLive {
    private Integer uid; //用户id
    private Integer room_id; //房间id
    private Integer short_id; //短id
    private Integer attention; //关注数
    private Integer online; //房间热度
    private Integer live_status; //直播状态 0.未开播 1.直播 2.轮播
    private String parent_area_name; //直播分区
    private String title; //直播标题
    private String live_time; //开播时间
}
