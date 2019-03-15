package cn.njyazheng.service;

import cn.njyazheng.domain.User;
import cn.njyazheng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class ExcelService {
    @Autowired
    private UserMapper userMapper;
    @Async
    public Future<Boolean> addBatch(List<User> list) throws InterruptedException {
        userMapper.insertBatch(list);
        list.clear();
        return new AsyncResult(true);
    }
}
