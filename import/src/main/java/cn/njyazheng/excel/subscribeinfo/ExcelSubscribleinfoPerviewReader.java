package cn.njyazheng.excel.subscribeinfo;

import cn.njyazheng.service.SubscribeinfolService;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelSubscribleinfoPerviewReader extends AnalysisEventListener  {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelSubscribleinfoPerviewReader.class);

    @Value("${subscrinfo.perview.dir}")
    private String dir;
    @Value("${subscrinfo.perview.file}")
    private String file;
    @Autowired
    private SubscribeinfolService excelService;
    @Value("${read.fist-line:1}")
    private int readfist;
    @Value("${import.once-size:200}")
    private int onceSize;

    //计数
    private int i=0;

    public void initCounter(){
        i=0;
    }
    public void handleExcel() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(dir+file);
        try {
            // ExcelReader excelReader = new ExcelReader(inputStream,null, listener);
            //excelReader.read();
            LOGGER.info("---------------------------------{} start import---------------------------------",file);
            initCounter();
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

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<List> datas =new ArrayList<List>() ;
    @Override
    public void invoke(Object object, AnalysisContext context) {
        //System.out.println("当前行："+context.getCurrentRowNum());
        //System.out.println(object);
        if(readfist==1&&context.getCurrentRowNum().intValue()!=0){
            doSomething(object,context.getTotalCount()-1);//根据自己业务做处理
        }
    }
    private void doSomething(Object object,int total){
        datas.add((List) object);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        int curr=0;
        int count=total/onceSize;
        count+=total%onceSize==0?0:1;
        if(total<=onceSize&&datas.size()==total){
            i++;
            curr=datas.size();
            excelService.addPerViewBatch(datas);
            LOGGER.info("file:{},this time batch:{},total batch:{}, this batch contain items:{},total item:{}",file,i,count,curr,total);
        }else if(total>onceSize&&(total-i*onceSize)<=onceSize&&datas.size()==(total-i*onceSize)){
            i++;
            curr=datas.size();
            excelService.addPerViewBatch(datas);
            LOGGER.info("file:{},this time batch:{},total batch:{}, this batch contain items:{},total item:{}",file,i,count,curr,total);
        }else if(total>onceSize&&(total-i*onceSize)>onceSize&&datas.size()==onceSize){
            i++;
            curr=datas.size();
            excelService.addPerViewBatch(datas);
            LOGGER.info("file:{},this time batch:{},total batch:{}, this batch contain items:{},total item:{}",file,i,count,curr,total);
            datas=new ArrayList<>();
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
