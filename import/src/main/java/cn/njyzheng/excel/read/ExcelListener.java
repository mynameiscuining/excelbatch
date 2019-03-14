package cn.njyzheng.excel.read;

import cn.cn.njyazheng.service.ExcelService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ExcelListener extends AnalysisEventListener {
    @Autowired
    private ExcelService excelService;
    //计数
    private int i=0;

    public void initCounter(){
        i=0;
    }

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<Object> datas =new ArrayList<Object>() ;
    @Override
    public void invoke(Object object, AnalysisContext context) {
        //System.out.println("当前行："+context.getCurrentRowNum());
        //System.out.println(object);
        doSomething(object,context.getTotalCount());//根据自己业务做处理
}
    private void doSomething(Object object,Integer total) {
        datas.add(object);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
//        if(total<=1000&&datas.size()==total){
//            excelService.addBatch(datas);
//        }else if(total>1000&&(total-i*1000)<=1000&&datas.size()==(total-i*1000)){
//            excelService.addBatch(datas);
//        }else if(total>1000&&(total-i*1000)>1000&&datas.size()==1000){
//            i++;
//            excelService.addBatch(datas);
//            datas=new ArrayList<>();
//        }
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // datas.clear();//解析结束销毁不用的资源
        datas.clear();
    }
    public List<Object> getDatas() {
        return datas;
    }
    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}
