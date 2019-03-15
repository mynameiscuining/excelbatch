package cn.njyazheng.mapper;

import cn.njyazheng.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(String loginaccount);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String loginaccount);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}