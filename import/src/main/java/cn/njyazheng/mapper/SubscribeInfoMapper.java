package cn.njyazheng.mapper;

import cn.njyazheng.domain.SubscribeInfo;

public interface SubscribeInfoMapper {
    int deleteByPrimaryKey(String subscriptionid);

    int insert(SubscribeInfo record);

    int insertSelective(SubscribeInfo record);

    SubscribeInfo selectByPrimaryKey(String subscriptionid);

    int updateByPrimaryKeySelective(SubscribeInfo record);

    int updateByPrimaryKey(SubscribeInfo record);
}