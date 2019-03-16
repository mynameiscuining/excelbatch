package cn.njyazheng.service;

import cn.njyazheng.domain.SubscribeInfo;
import cn.njyazheng.mapper.SubscribeInfoMapper;
import cn.njyazheng.util.SubscribeIDGen;
import cn.njyazheng.util.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class SubscribeinfolService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscribeinfolService.class);
    @Autowired
    private SubscribeInfoMapper subscribeInfoMapper;
    @Value("${subscrinfo.perview.file}")
    private String perview;
    @Value("${subscrinfo.monthpack.file}")
    private String monthpack;
    @Autowired
    private SubscribeIDGen subidGen;

    public void addPerViewBatch(List<List> list) {
        list.parallelStream().forEach(objects->{
            try {
                //临时订购关系
                SubscribeInfo subscribeInfo=new SubscribeInfo();
                subscribeInfo.setSubscriptionid(subidGen.getSubscriptionID("1","1"));//订购编号
                subscribeInfo.setSpid(null);//spid是不是对应CPSP_ID index=11
                subscribeInfo.setOrderid(objects.get(2)==null?null:objects.get(2).toString().trim());// 订购编码 index=2
                subscribeInfo.setOrderflag(1);//1代表产品
                subscribeInfo.setDa(objects.get(1)==null?null:objects.get(1).toString().trim());//使用方账号index=1
                subscribeInfo.setFa(objects.get(1)==null?null:objects.get(1).toString().trim());//付费账号index=1
                subscribeInfo.setOa(objects.get(1)==null?null:objects.get(1).toString().trim());//订购方账号index=1
                subscribeInfo.setTable(Tools.getUserHashTable(Tools.I_SUBSCRIBEINFO,objects.get(1)==null?null:objects.get(1).toString()));
                subscribeInfo.setItemid(null);//节目编码
                subscribeInfo.setOauserflag(null);
                subscribeInfo.setDauserflag(null);
                subscribeInfo.setFatype(null);
                subscribeInfo.setOriginid("tjgd");//设置请求源
                subscribeInfo.setStatus(0);//0代表正常
                if(objects.get(7)!=null&&!"".equals(objects.get(7).toString().trim())){
                    Date date= Tools.getDateByFORMAT(objects.get(7).toString().trim(),Tools.yyyyMMddHHmms);
                    subscribeInfo.setSubscribetime(date);//订购时间STARTTIME index=7
                    subscribeInfo.setEffectivetime(date);//生效时间STARTTIME index=7
                }
                if(objects.get(8)!=null&&!"".equals(objects.get(8).toString().trim())){
                    Date date= Tools.getDateByFORMAT(objects.get(8).toString().trim(),Tools.yyyyMMddHHmms);
                    subscribeInfo.setExpiretime(date);//失效时间 ENDTIME index=8
                }
                subscribeInfo.setExpiretime(null);//失效时间 ENDTIME index=8
                subscribeInfo.setResumetime(null);//暂停恢复时间
                subscribeInfo.setWithdrawreason(null);//退订时间
                subscribeInfo.setWithdrawtime(null);//退订时间
                subscribeInfo.setIssubscription(null);//是否续订
                subscribeInfo.setFee(objects.get(16)==null?null: Integer.parseInt(objects.get(16).toString().trim()));//FEE index=16
                subscribeInfo.setRealfee(objects.get(16)==null?null:Integer.parseInt(objects.get(16).toString().trim()));//FEE index=16
                subscribeInfo.setPaytype(1);//支付方式
                subscribeInfoMapper.insertSelective(subscribeInfo);
            }catch (Exception e){
                LOGGER.error("-------------------------file:"+perview+"------------------------------");
                LOGGER.error(list.toString());
                LOGGER.error("failed!",e);
            }
        });
        list.clear();
    }

    public void addMonthPackBatch(List<List> list) {
        list.parallelStream().forEach(objects->{
            try {
                //订购关系
                SubscribeInfo subscribeInfo=new SubscribeInfo();
                subscribeInfo.setSubscriptionid(subidGen.getSubscriptionID("0","1"));//订购编号
                subscribeInfo.setSpid(null);//
                subscribeInfo.setOrderid(objects.get(2)==null?null:objects.get(2).toString().trim());// 订购编码 index=2
                subscribeInfo.setOrderflag(1);//1代表产品
                subscribeInfo.setDa(objects.get(1)==null?null:objects.get(1).toString().trim());//使用方账号index=1
                subscribeInfo.setFa(objects.get(1)==null?null:objects.get(1).toString().trim());//付费账号index=1
                subscribeInfo.setOa(objects.get(1)==null?null:objects.get(1).toString().trim());//订购方账号index=1
                subscribeInfo.setItemid(null);//节目编码
                subscribeInfo.setOauserflag(null);
                subscribeInfo.setDauserflag(null);
                subscribeInfo.setFatype(null);
                subscribeInfo.setOriginid("tjgd");//设置请求源
                subscribeInfo.setStatus(0);//0代表正常
                if(objects.get(3)!=null&&!"".equals(objects.get(3).toString().trim())){
                    Date date= Tools.getDateByFORMAT(objects.get(3).toString().trim(),Tools.yyyyMMddHHmms);
                    subscribeInfo.setSubscribetime(date);//订购时间SERORDERTIME index=3
                }
                if(objects.get(4)!=null&&!"".equals(objects.get(4).toString().trim())){
                    Date date= Tools.getDateByFORMAT(objects.get(4).toString().trim(),Tools.yyyyMMddHHmms);
                    subscribeInfo.setEffectivetime(date);//生效时间SERSTARTTIME index=4
                }
                if(objects.get(5)!=null&&!"".equals(objects.get(5).toString().trim())){
                    Date date= Tools.getDateByFORMAT(objects.get(5).toString().trim(),Tools.yyyyMMddHHmms);
                    subscribeInfo.setExpiretime(date);//失效时间 SERSTOPTIME index=5
                }
                subscribeInfo.setResumetime(null);//暂停恢复时间
                subscribeInfo.setWithdrawreason(null);//退订原因
                if(objects.get(8)!=null&&!"".equals(objects.get(8).toString().trim())){
                    Date date= Tools.getDateByFORMAT(objects.get(8).toString().trim(),Tools.yyyyMMddHHmms);
                    subscribeInfo.setWithdrawtime(date);//退订时间CANCELCONTINUETIME index=8
                }
                subscribeInfo.setIssubscription(objects.get(6)==null?null: Integer.parseInt(objects.get(6).toString().trim()));//是否续订CONTINUEFLAG index=6
                subscribeInfo.setFee(objects.get(20)==null?null: Integer.parseInt(objects.get(20).toString().trim()));//PRODUCT_FEE index=20
                subscribeInfo.setRealfee(objects.get(21)==null?null:Integer.parseInt(objects.get(21).toString().trim()));//FEE index=21
                subscribeInfo.setPaytype(1);//支付方式
                subscribeInfo.setTable(Tools.getUserHashTable(Tools.I_SUBSCRIBEINFO,objects.get(1)==null?null:objects.get(1).toString().trim()));
               subscribeInfoMapper.insertSelective(subscribeInfo);
            }catch (Exception e){
                LOGGER.error("-------------------------file:"+monthpack+"------------------------------");
                LOGGER.error(list.toString());
                LOGGER.error("import failed!",e);
            }
        });
        list.clear();
    }
}
