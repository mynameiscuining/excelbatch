package cn.njyazheng;

import cn.njyazheng.excel.ExcelReaderService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
@MapperScan("cn.njyazheng.mapper")
public class SpringBootApplicaton implements CommandLineRunner {
    @Autowired
    private ExcelReaderService excelRead;
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext= SpringApplication.run(SpringBootApplicaton.class, args);
        int exitcode= SpringApplication.exit(configurableApplicationContext);
        System.exit(exitcode);
    }

    @Override
    public void run(String... args) throws Exception {
        excelRead.handleExcel();

    }
}
