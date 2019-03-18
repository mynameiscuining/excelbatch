package cn.njyazheng.service;

import cn.njyazheng.domain.SubscribeInfo;
import cn.njyazheng.mapper.SubscribeInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class AsyncSubscribeinfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscribeinfolService.class);
    @Autowired
    private SubscribeInfoMapper subscribeInfoMapper;
    @Async
    public void addAsync(SubscribeInfo subscribeInfo, String file, CountDownLatch countDownLatch){
        try {
             subscribeInfoMapper.insertSelective(subscribeInfo);
        }catch (Exception e){
            LOGGER.error("-------------------------file:"+file+"------------------------------");
            LOGGER.error(subscribeInfo.toString());
            LOGGER.error("import failed!",e);
        }finally {
            countDownLatch.countDown();
        }

    }
}
