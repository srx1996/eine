package live.eine.fans.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class GoToPageController {
    @GetMapping("/go/{uri}")
    public String getUrl(@PathVariable String uri) {
        String str = "";
        switch (uri) {
            case "live":
                str = "https://live.bilibili.com/21403601";
                break;
            case "pome":
                str = "https://www.pomeet.com/Eine0202";
                break;
            case "weibo":
                str = "https://weibo.com/n/%E8%89%BE%E5%9B%A0Eine";
                break;
            case "twitter":
                str = "https://twitter.com/VirtuaRealEine";
                break;
        }
        return str;
    }
}
