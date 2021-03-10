package live.eine.fans.service;

import live.eine.fans.pojo.EineLive;

public interface LiveService {

    EineLive getLiveInfo(Integer roomId) throws Exception;
}
