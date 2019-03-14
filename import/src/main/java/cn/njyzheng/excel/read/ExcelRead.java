package cn.njyzheng.excel.read;

import cn.cn.njyazheng.service.ExcelService;
import cn.njyazheng.domain.IUserinfo;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ExcelRead {
    // 解析每行结果在listener中处理
    @Autowired
    private ExcelService excelService;
    @Autowired
    private ExcelListener excelListener;
    public void handleExcel() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("D:\\亚信\\天津电信\\subscriberinfo.xlsx");
        try {
            // ExcelReader excelReader = new ExcelReader(inputStream,null, listener);
            //excelReader.read();
            excelListener.initCounter();
            ExcelReader excelReader = EasyExcelFactory.getReader(inputStream, excelListener);
            excelReader.read(excelReader.getSheets().get(0));
            excelListener.doAfterAllAnalysed(null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void insert(){
        try {
            List<IUserinfo> userinfos=new ArrayList<>();
            IUserinfo iUserinfo=new IUserinfo();
            iUserinfo.setAddress("123");
            iUserinfo.setCertificate("1");
            iUserinfo.setCerttype(1);
            iUserinfo.setCreateoperator("123");
            iUserinfo.setCreatetime(new Date());
            iUserinfo.setEmail("12");
            iUserinfo.setLanguagepref(1);
            iUserinfo.setLoginaccount("12312");
            iUserinfo.setModifyoperator("12");
            iUserinfo.setModifytime(new Date());
            iUserinfo.setPhonenum("12312");
            iUserinfo.setUsername("12312");
            userinfos.add(iUserinfo);
            iUserinfo=new IUserinfo();
            iUserinfo.setAddress("123");
            iUserinfo.setCertificate("1");
            iUserinfo.setCerttype(1);
            iUserinfo.setCreateoperator("123");
            iUserinfo.setCreatetime(new Date());
            iUserinfo.setEmail("12");
            iUserinfo.setLanguagepref(1);
            iUserinfo.setLoginaccount("456");
            iUserinfo.setModifyoperator("12");
            iUserinfo.setModifytime(new Date());
            iUserinfo.setPhonenum("12312");
            iUserinfo.setUsername("12312");
            userinfos.add(iUserinfo);
            if(excelService.addBatch(userinfos).get()){
                System.out.println("ooooooooooooooooooooooooooooooooooooooooo");
            };
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
