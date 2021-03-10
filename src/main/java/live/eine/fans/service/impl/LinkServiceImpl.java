package live.eine.fans.service.impl;

import live.eine.fans.mapper.LinkMapper;
import live.eine.fans.pojo.EineUrl;
import live.eine.fans.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    LinkMapper linkMapper;

    @Override
    public List<EineUrl> getUrlByAll() {
        return linkMapper.getUrlByAll();
    }

    @Override
    public EineUrl getUrlByOne(String uri) {
        return linkMapper.getUrlByOne(uri);
    }

    @Override
    public EineUrl getUrlByShortUri(String uri) {
        return linkMapper.getUrlByShortUri(uri);
    }
}
