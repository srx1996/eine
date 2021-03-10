package live.eine.fans;

import com.alibaba.fastjson.JSONObject;
import live.eine.fans.pojo.EineLive;
import live.eine.fans.pojo.EineUrl;
import live.eine.fans.service.LinkService;
import live.eine.fans.utils.PostUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

@SpringBootTest
class FansApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    LinkService linkService;


    @Test
    void contextLoads() throws Exception {
        String json = PostUtil.post("https://api.live.bilibili.com/room/v1/Room/get_info?id=21403601");
        JSONObject jsonObject = JSONObject.parseObject(json);
        String data = jsonObject.get("data").toString();
        EineLive eineLive = JSONObject.parseObject(data, EineLive.class);
        System.out.println(eineLive);
    }


}
