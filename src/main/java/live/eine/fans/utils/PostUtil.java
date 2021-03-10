package live.eine.fans.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 发送请求
 */
public class PostUtil {
    public static String post(String api) throws Exception {
        // 我们需要进行请求的地址：
        // 1.URL类封装了大量复杂的实现细节，这里将一个字符串构造成一个URL对象
        URL url = new URL(api);
        // 2.获取HttpURRLConnection对象
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // 3.调用connect方法连接远程资源
        connection.connect();
        // 4.访问资源数据，使用getInputStream方法获取一个输入流用以读取信息
        BufferedReader bReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "UTF-8"));
        // 对数据进行访问
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        // 关闭流
        bReader.close();
        // 关闭链接
        connection.disconnect();
        // 打印获取的结果
//        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

}
