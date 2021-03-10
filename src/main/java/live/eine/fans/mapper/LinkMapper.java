package live.eine.fans.mapper;

import live.eine.fans.pojo.EineUrl;

import java.util.List;

public interface LinkMapper {
    List<EineUrl> getUrlByAll();

    EineUrl getUrlByOne(String uri);

    EineUrl getUrlByShortUri(String uri);
}
