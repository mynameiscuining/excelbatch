package cn.njyazheng.service;

import cn.njyazheng.domain.Renew;
import cn.njyazheng.mapper.RenewMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RenewService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscribeinfolService.class);
    @Autowired
    private RenewMapper renewMapper;

    public void  addRenew(Renew renew,String file){
        try {
            renewMapper.insertSelective(renew);
        }catch (Exception e) {
            LOGGER.error("-------------------------file:" + file + "------------------------------");
            LOGGER.error(renew.toString());
            LOGGER.error("renew import failed!", e);
        }
    }
}
