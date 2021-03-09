package live.eine.fans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LinkController {
    @GetMapping("/19")
    public String goLive() {
        return "redirect:https://live.bilibili.com/21403601";
    }
    @GetMapping("/qa")
    public String goPome() {
        return "redirect:https://www.pomeet.com/Eine0202";
    }
    @GetMapping("/wb")
    public String goWeibo() {
        return "redirect:https://weibo.com/n/%E8%89%BE%E5%9B%A0Eine";
    }
    @GetMapping("/tw")
    public String goTwitter() {
        return "redirect:https://twitter.com/VirtuaRealEine";
    }
}

