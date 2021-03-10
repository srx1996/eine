package live.eine.fans.service;

import live.eine.fans.pojo.EineUrl;

import java.util.List;

public interface LinkService {
    List<EineUrl> getUrlByAll();

    EineUrl getUrlByOne(String uri);

    EineUrl getUrlByShortUri(String uri);
}
