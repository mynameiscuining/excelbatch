package cn.njyazheng.excel.subscribeinfo;

import cn.njyazheng.excel.ExcelListener;
import cn.njyazheng.service.SubscribeinfolService;
import com.alibaba.excel.context.AnalysisContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelSubscribleinfoPerviewReader extends ExcelListener {

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

    public void setExcel() {
        try {
            super.setExcel(dir,file);
        } catch (FileNotFoundException e) {
            LOGGER.error(dir+file+":FileNotFoundException");
        }
    }
    @Override
    public void invoke(Object object, AnalysisContext context) {
        //System.out.println("当前行："+context.getCurrentRowNum());
        //System.out.println(object);
        if(readfist==1&&context.getCurrentRowNum().intValue()!=0){
            doSomething(object,context.getTotalCount()-1);//根据自己业务做处理
        }
    }
    public void doSomething(Object object, int total){
        datas.add((List) object);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        int curr=0;
        int count=total/onceSize;
        count+=total%onceSize==0?0:1;
        if(total<=onceSize&&datas.size()==total){
            i++;
            curr=datas.size();
            excelService.addbatch(datas,0);
            LOGGER.info("file:{},this time batch:{},total batch:{}, this batch contain items:{},total item:{}",file,i,count,curr,total);
        }else if(total>onceSize&&(total-i*onceSize)<=onceSize&&datas.size()==(total-i*onceSize)){
            i++;
            curr=datas.size();
            excelService.addbatch(datas,0);
            LOGGER.info("file:{},this time batch:{},total batch:{}, this batch contain items:{},total item:{}",file,i,count,curr,total);
        }else if(total>onceSize&&(total-i*onceSize)>onceSize&&datas.size()==onceSize){
            i++;
            curr=datas.size();
            excelService.addbatch(datas,0);
            LOGGER.info("file:{},this time batch:{},total batch:{}, this batch contain items:{},total item:{}",file,i,count,curr,total);
            datas=new ArrayList<>();
        }
    }
}
