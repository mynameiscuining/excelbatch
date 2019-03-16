package cn.njyazheng.excel.subscribeinfo;

import cn.njyazheng.annotation.Subscribeinfo;
import cn.njyazheng.excel.ExcelReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Subscribeinfo
public class ExcelSubscribeInfoReader implements ExcelReaderService {
    @Autowired
    private ExcelSubscribleinfoPerviewReader perviewReader;
    @Autowired
    private ExcelSubscribleinfoMonthPackReader monthPackReader;
    @Override
    public void handleExcel() throws Exception {
        perviewReader.handleExcel();
        monthPackReader.handleExcel();
    }
}
