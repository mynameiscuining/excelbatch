package cn.njyazheng.excel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class ExcelListener extends AnalysisEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelListener.class);
    //计数
    public int i=0;
    //自定义用于暂时存储data。
    //可以通过实例获取该值
    protected List<List> datas =new ArrayList<List>() ;
    public void initCounter(){
        i=0;
    }
    public void setExcel(String dir,String file) throws FileNotFoundException {
        InputStream inputStream  = new FileInputStream(dir+file);
        try {
            // ExcelReader excelReader = new ExcelReader(inputStream,null, listener);
            //excelReader.read();
            initCounter();
            LOGGER.info("---------------------------------{} start import---------------------------------",file);
            ExcelReader excelReader = EasyExcelFactory.getReader(inputStream, this);
            excelReader.read(excelReader.getSheets().get(0));
        } catch (Exception e) {
            LOGGER.error(file+"import error, please check!",e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // datas.clear();//解析结束销毁不用的资源
        datas.clear();
    }
    public List<List> getDatas() {
        return datas;
    }
    public void setDatas(List<List> datas) {
        this.datas = datas;
    }
}
