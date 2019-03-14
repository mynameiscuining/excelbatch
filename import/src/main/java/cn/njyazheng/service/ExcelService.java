package cn.njyazheng.service;

import cn.njyazheng.dao.IUserinfoDao;
import cn.njyazheng.domain.IUserinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class ExcelService {
    @Autowired
    private IUserinfoDao userinfoDao;
    @Async
    public Future<Boolean> addBatch(List<IUserinfo> list) throws InterruptedException {
        userinfoDao.insertBatch(list);
        list.clear();
        return new AsyncResult(true);
    }
}
