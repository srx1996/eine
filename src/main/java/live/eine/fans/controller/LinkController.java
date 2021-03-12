package live.eine.fans.controller;

import live.eine.fans.pojo.EineUrl;
import live.eine.fans.service.LinkService;
import live.eine.fans.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 社交平台访问
 */
@Controller
public class LinkController {
    @Autowired
    LinkService linkService;

    private static final Map<String, EineUrl> urlMap = new HashMap<>();

    @GetMapping("/all/url")
    @ResponseBody
    public R getAllUrl() {
        List<EineUrl> urlList = linkService.getUrlByAll();
        if (urlList.size() == 0 || urlList == null) {
            R.error("url为空");
        }
        return R.ok().put("urlList", urlList);
    }

    @GetMapping("/{uri}")
    public String goToPage(@PathVariable String uri) {
        if ("".equals(uri) || uri == null) {
            return "index";
        }
        EineUrl eineUrl = linkService.getUrlByShortUri(uri);
        if (eineUrl == null) {
            return "index";
        }
        return "redirect:" + eineUrl.getLinkUrl();
    }

    @ResponseBody
    @GetMapping("/go/{uri}")
    public R getUrl(@PathVariable String uri) {
        EineUrl eineUrl;
        if (urlMap.get(uri) != null) {
            eineUrl = urlMap.get(uri);
        } else {
            eineUrl = linkService.getUrlByOne(uri);
            urlMap.put(uri, eineUrl);
        }
        if (eineUrl == null) {
            return R.error("链接不存在");
        }
        return R.ok().put("eineUrl", eineUrl);
    }
}

