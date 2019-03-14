package generator;

import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.gen.GenConfig;
import org.beetl.sql.ext.gen.MapperCodeGen;

public class Test {

    @org.junit.Test
    public void contextLoads() throws Exception {
        SQLManager sqlManager;
        System.out.println("before");
        String url="jdbc:mysql://192.168.229.129:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
        String driver="com.mysql.jdbc.Driver";
        String userName="yazheng";
        String password="yazheng123";
        ConnectionSource source = ConnectionSourceHelper.getSimple(driver, url, userName, password);
        DBStyle mysql = new MySqlStyle();
        // sql语句放在classpagth的/sql 目录下
        SQLLoader loader = new ClasspathLoader("/sql");
        // 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，下划线风格的，
        UnderlinedNameConversion nc = new  UnderlinedNameConversion();
        // 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
        sqlManager = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});

        System.out.println("Test");
        GenConfig config=  new GenConfig();
        MapperCodeGen mapper = new MapperCodeGen("cn.njyazheng.dao");
        mapper.setMapperTemplate(config.getTemplate("/org/beetl/sql/ext/gen/mapper.btl"));
        config.codeGens.add(mapper);
        System.out.println("-------------------------------华丽的分割线-------------------------------------");
        sqlManager.genPojoCode("I_USERINFO","cn.njyazheng.domain",config);
        System.out.println("-------------------------------华丽的分割线-------------------------------------");


        sqlManager.genSQLFile("I_USERINFO",config);
        System.out.println("-------------------------------华丽的分割线-------------------------------------");


    }
}
