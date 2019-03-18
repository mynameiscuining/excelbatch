package cn.njyazheng.mapper;

import cn.njyazheng.domain.Renew;

public interface RenewMapper {
    int deleteByPrimaryKey(Integer serno);

    int insert(Renew record);

    int insertSelective(Renew record);

    Renew selectByPrimaryKey(Integer serno);

    int updateByPrimaryKeySelective(Renew record);

    int updateByPrimaryKey(Renew record);
}