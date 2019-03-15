package cn.njyazheng.excel.read;

import cn.njyazheng.service.ExcelService;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

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

//            if(excelService.addBatch(userinfos).get()){
//                System.out.println("ooooooooooooooooooooooooooooooooooooooooo");
//            };
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
