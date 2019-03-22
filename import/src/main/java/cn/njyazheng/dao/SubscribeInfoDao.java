package cn.njyazheng.dao;

import cn.njyazheng.domain.Renew;
import cn.njyazheng.domain.SubscribeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubscribeInfoDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscribeInfoDao.class);
    public final static  String SUB_INSERT="INSERT INTO %s (subscriptionID, spid, orderID,orderFlag, itemID, oa,oaUserFlag, da, daUserFlag,fa, faType, originid,status, subscribeTime, effectiveTime,\n" +
            "expireTime, suspendReason, suspendTime, resumeTime, withdrawReason, withdrawTime,isSubscription, fee, realfee, paytype) " +
            "VALUES(:subscriptionid,:spid,:orderid,:orderflag,:itemid,:oa,:oauserflag,:da,:dauserflag,:fa,:fatype,:originid,:status,:subscribetime,:effectivetime, \n" +
            ":expiretime,:suspendreason,:suspendtime,:resumetime,:withdrawreason,:withdrawtime,:issubscription,:fee,:realfee,:paytype)";

    public final static String REN_INSERT="insert into %s (serno, subscriptionID, loginaccount,productid, campaignid, strategyid,ruleid, param, firstsubscribetime, \n" +
            "lastsubscribetime, renewtimes, renewtype,  period, fee, realfee,  paytype, processstatus, moddate)\n" +
            "values (:serno,:subscriptionid,:loginaccount,:productid,:campaignid,:strategyid,:ruleid,:param,:firstsubscribetime, \n" +
            ":lastsubscribetime,:renewtimes,:renewtype,:period,:fee,:realfee,:paytype,:processstatus,:moddate )";

    public void addsubbath(String table, List<SubscribeInfo> subscribeInfos){
        try {
            SqlParameterSource[] beanSources  = SqlParameterSourceUtils.createBatch(subscribeInfos.toArray());
            String sql=String.format(SUB_INSERT,table);
            namedParameterJdbcTemplate.batchUpdate(sql,beanSources);
        }catch (Exception e){
            LOGGER.error("subscribeInfo import failed!",e);
        }

    }

    public void addrenewBatch(String table, List<Renew>renews){
        try {
            SqlParameterSource[] beanSources  = SqlParameterSourceUtils.createBatch(renews.toArray());
            String sql=String.format(REN_INSERT,table);
            namedParameterJdbcTemplate.batchUpdate(sql,beanSources);
        }catch (Exception e){
            LOGGER.error("renew import failed!",e);
        }
    }
}
