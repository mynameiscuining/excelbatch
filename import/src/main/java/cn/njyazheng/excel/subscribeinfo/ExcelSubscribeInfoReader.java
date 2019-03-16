package cn.njyazheng.excel.subscribeinfo;

import cn.njyazheng.annotation.Subscribeinfo;
import cn.njyazheng.excel.ExcelReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Subscribeinfo
public class ExcelSubscribeInfoReader implements ExcelReaderService {
    @Autowired
    private ExcelSubscribleinfoPerviewReader perviewReader;
    @Autowired
    private ExcelSubscribleinfoMonthPackReader monthPackReader;

    @Value("${subscrinfo.monthpack.read:1}")
    private int monthpack;
    @Value("${subscrinfo.perview.read:1}")
    private int perview;
    @Override
    public void handleExcel() throws Exception {
        if(perview==1){
            perviewReader.setExcel();
        }
        if(monthpack==1){
            monthPackReader.setExcel();
        }
    }
}
