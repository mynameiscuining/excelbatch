package cn.njyazheng.excel.read;

import cn.njyazheng.domain.User;
import cn.njyazheng.service.ExcelService;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
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
            List<User> userList=new ArrayList<>();
            User user=new User();
            user.setAddress("1");
            user.setCertificate("1");
            user.setCerttype(1);
            user.setCreateoperator("1");
            user.setCreatetime(new Date());
            user.setEmail("1");
            user.setLanguagepref(1);
            user.setLoginaccount("1");
            user.setModifyoperator("1");
            user.setModifytime(new Date());
            user.setPhonenum("1");
            user.setUsername("1");
            userList.add(user);
            user=new User();
            user.setAddress("2");
            user.setCertificate("2");
            user.setCerttype(2);
            user.setCreateoperator("2");
            user.setCreatetime(new Date());
            user.setEmail("2");
            user.setLanguagepref(2);
            user.setLoginaccount("2");
            user.setModifyoperator("2");
            user.setModifytime(new Date());
            user.setPhonenum("2");
            user.setUsername("2");
            userList.add(user);
            if(excelService.addBatch(userList).get()){
                System.out.println("ooooooooooooooooooooooooooooooooooooooooo");
            };
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
