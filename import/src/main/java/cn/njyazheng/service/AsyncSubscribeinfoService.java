package cn.njyazheng.service;

import cn.njyazheng.domain.Renew;
import cn.njyazheng.domain.SubscribeInfo;
import cn.njyazheng.mapper.RenewMapper;
import cn.njyazheng.mapper.SubscribeInfoMapper;
import cn.njyazheng.util.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

@Service
public class AsyncSubscribeinfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscribeinfolService.class);
    @Autowired
    private RenewService renewService;

    @Autowired
    private SubscribeInfoMapper subscribeInfoMapper;
    @Async
    public void addAsync(SubscribeInfo subscribeInfo, String file, CountDownLatch countDownLatch,int flag){
        try {
             subscribeInfoMapper.insertSelective(subscribeInfo);
             if(flag==1){
                 Renew renew= new Renew();
                 renew.setCampaignid(null);
                 renew.setFirstsubscribetime(subscribeInfo.getSubscribetime());
                 renew.setLastsubscribetime(subscribeInfo.getSubscribetime());
                 renew.setModdate(new Date());
                 renew.setParam(null);
                 renew.setPaytype(1);
                 renew.setPeriod(30);
                 renew.setProcessstatus(0);
                 renew.setProductid(subscribeInfo.getOrderid());
                 renew.setRenewtimes(1);
                 renew.setRenewtype(1);
                 renew.setRuleid(null);
                 renew.setStrategyid(null);
                 renew.setSubscriptionid(subscribeInfo.getSubscriptionid());
                 renew.setLoginaccount(subscribeInfo.getDa());
                 renew.setFee(subscribeInfo.getFee());
                 renew.setRealfee(subscribeInfo.getRealfee());
                 renew.setTable(Tools.getMonthDayTable(Tools.I_RENEW,new Date()));
                 renewService.addRenew(renew,file);
             }
        }catch (Exception e){
            LOGGER.error("-------------------------file:"+file+"------------------------------");
            LOGGER.error(subscribeInfo.toString());
            LOGGER.error("subscribeInfo import failed!",e);
        }finally {
            countDownLatch.countDown();
        }

    }
}
