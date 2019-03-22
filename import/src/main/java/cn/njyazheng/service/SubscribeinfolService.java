package cn.njyazheng.service;

import cn.njyazheng.dao.SubscribeInfoDao;
import cn.njyazheng.domain.Renew;
import cn.njyazheng.domain.SubscribeInfo;
import cn.njyazheng.util.SubscribeIDGen;
import cn.njyazheng.util.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class SubscribeinfolService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscribeinfolService.class);
    @Autowired
    private SubscribeInfoDao subscribeInfoDao;
    @Value("${subscrinfo.perview.file}")
    private String perview;
    @Value("${subscrinfo.monthpack.file}")
    private String monthpack;
    @Autowired
    private SubscribeIDGen subidGen;


    private SubscribeInfo getSubscribeMonthPackInfo(List objects) {

        //订购关关系
        SubscribeInfo subscribeInfo = new SubscribeInfo();
        subscribeInfo.setSubscriptionid(subidGen.getSubscriptionID("0", "1"));//订购编号
        subscribeInfo.setSpid(null);//
        subscribeInfo.setOrderid(objects.get(2) == null ? null : objects.get(2).toString().trim());// 订购编码 index=2
        subscribeInfo.setOrderflag(1);//1代表产品
        subscribeInfo.setDa(objects.get(1) == null ? null : objects.get(1).toString().trim());//使用方账号index=1
        subscribeInfo.setFa(objects.get(1) == null ? null : objects.get(1).toString().trim());//付费账号index=1
        subscribeInfo.setOa(objects.get(1) == null ? null : objects.get(1).toString().trim());//订购方账号index=1
        subscribeInfo.setItemid(null);//节目编码
        subscribeInfo.setOauserflag(null);
        subscribeInfo.setDauserflag(null);
        subscribeInfo.setFatype(null);
        subscribeInfo.setOriginid("tjgd");//设置请求源
        subscribeInfo.setStatus(0);//0代表正常
        if (objects.get(3) != null && !"".equals(objects.get(3).toString().trim())) {
            Date date = Tools.getDateByFORMAT(objects.get(3).toString().trim(), Tools.yyyyMMddHHmms);
            subscribeInfo.setSubscribetime(date);//订购时间SERORDERTIME index=3
        }
        if (objects.get(4) != null && !"".equals(objects.get(4).toString().trim())) {
            Date date = Tools.getDateByFORMAT(objects.get(4).toString().trim(), Tools.yyyyMMddHHmms);
            subscribeInfo.setEffectivetime(date);//生效时间SERSTARTTIME index=4
        }
        subscribeInfo.setResumetime(null);//暂停恢复时间
        subscribeInfo.setWithdrawreason(null);//退订原因
        if (objects.get(8) != null && !"".equals(objects.get(8).toString().trim())) {
            Date date = Tools.getDateByFORMAT(objects.get(8).toString().trim(), Tools.yyyyMMddHHmms);
            subscribeInfo.setWithdrawtime(date);//退订时间CANCELCONTINUETIME index=8
        }
        subscribeInfo.setIssubscription(objects.get(6) == null ? null : Integer.parseInt(objects.get(6).toString().trim()));//是否续订CONTINUEFLAG index=6
        if (objects.get(5) != null && !"".equals(objects.get(5).toString().trim())) {
            Date date = Tools.getDateByFORMAT(objects.get(5).toString().trim(), Tools.yyyyMMddHHmms);
            subscribeInfo.setExpiretime(date);//失效时间 SERSTOPTIME index=5
            if ("30000101000000".equals(objects.get(5).toString().trim())) {
                subscribeInfo.setIssubscription(1);
            }
        }
        subscribeInfo.setFee(objects.get(21) == null ? null : Integer.parseInt(objects.get(21).toString().trim()));//FEE index=20
        subscribeInfo.setRealfee(null);
        subscribeInfo.setPaytype(1);//支付方式
        subscribeInfo.setTable(Tools.getUserHashTable(Tools.I_SUBSCRIBEINFO, objects.get(1) == null ? null : objects.get(1).toString().trim()));
        return subscribeInfo;
    }
    public void addbatch(List<List> list, int flag) {
        String file=1==flag?monthpack:perview;
        try {
            List<SubscribeInfo> subscribeinfoList = list.parallelStream().map(1 == flag ? this::getSubscribeMonthPackInfo : this::getSubscribePerviewInfo).collect(Collectors.toList());
            list.clear();
            Map<String, List<SubscribeInfo>> map = subscribeinfoList.parallelStream().collect(Collectors.groupingBy(SubscribeInfo::getTable));
            map.forEach(subscribeInfoDao::addsubbath);
            if (flag == 1) {
                List<Renew> renews = subscribeinfoList.parallelStream().map(this::getRenew).collect(Collectors.toList());
               String table =Tools.getMonthDayTable(Tools.I_RENEW,Tools.getNextMontnFirstDay(new Date()));
                //String table =Tools.getMonthDayTable(Tools.I_RENEW, new Date());
                subscribeInfoDao.addrenewBatch(table,renews);
                renews.clear();
            }
            subscribeinfoList.clear();
        } catch (Exception e) {
            LOGGER.error("-------------------------file:" + file + "------------------------------");
            LOGGER.error(list.toString());
            LOGGER.error("excel date convert to entity failed!", e);
        }
}

    private Renew getRenew(SubscribeInfo subscribeInfo) {
        Renew renew = new Renew();
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

        return renew;
    }

    private SubscribeInfo getSubscribePerviewInfo(List objects) {
        //临时订购关系
        SubscribeInfo subscribeInfo = new SubscribeInfo();
        subscribeInfo.setSubscriptionid(subidGen.getSubscriptionID("1", "1"));//订购编号
        subscribeInfo.setSpid(null);//spid是不是对应CPSP_ID index=11
        subscribeInfo.setOrderid(objects.get(2) == null ? null : objects.get(2).toString().trim());// 订购编码 index=2
        subscribeInfo.setOrderflag(1);//1代表产品
        subscribeInfo.setDa(objects.get(1) == null ? null : objects.get(1).toString().trim());//使用方账号index=1
        subscribeInfo.setFa(objects.get(1) == null ? null : objects.get(1).toString().trim());//付费账号index=1
        subscribeInfo.setOa(objects.get(1) == null ? null : objects.get(1).toString().trim());//订购方账号index=1
        subscribeInfo.setTable(Tools.getUserHashTable(Tools.I_SUBSCRIBEINFO, objects.get(1) == null ? null : objects.get(1).toString()));
        subscribeInfo.setItemid(null);//节目编码
        subscribeInfo.setOauserflag(null);
        subscribeInfo.setDauserflag(null);
        subscribeInfo.setFatype(null);
        subscribeInfo.setOriginid("tjgd");//设置请求源
        subscribeInfo.setStatus(0);//0代表正常
        if (objects.get(7) != null && !"".equals(objects.get(7).toString().trim())) {
            Date date = Tools.getDateByFORMAT(objects.get(7).toString().trim(), Tools.yyyyMMddHHmms);
            subscribeInfo.setEffectivetime(date);//生效时间STARTTIME index=7
        }
        if (objects.get(24) != null && !"".equals(objects.get(24).toString().trim())) {
            Date date = Tools.getDateByFORMAT(objects.get(24).toString().trim(), Tools.yyyyMMddHHmms);
            subscribeInfo.setSubscribetime(date);//订购时间ORDERTIME index=24
            subscribeInfo.setEffectivetime(date);//生效时间STARTTIME index=7
        }
        if (objects.get(8) != null && !"".equals(objects.get(8).toString().trim())) {
            Date date = Tools.getDateByFORMAT(objects.get(8).toString().trim(), Tools.yyyyMMddHHmms);
            subscribeInfo.setExpiretime(date);//失效时间 ENDTIME index=8
        }
        subscribeInfo.setResumetime(null);//暂停恢复时间
        subscribeInfo.setWithdrawreason(null);//退订时间
        subscribeInfo.setWithdrawtime(null);//退订时间
        subscribeInfo.setIssubscription(null);//是否续订
        subscribeInfo.setFee(objects.get(16) == null ? null : Integer.parseInt(objects.get(16).toString().trim()));//FEE index=16
        subscribeInfo.setRealfee(null);
        subscribeInfo.setPaytype(1);//支付方式
        return subscribeInfo;
    }
}
