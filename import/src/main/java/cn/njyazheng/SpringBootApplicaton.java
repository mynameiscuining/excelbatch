package cn.njyazheng;

import cn.njyazheng.excel.read.ExcelRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringBootApplicaton implements CommandLineRunner {
    @Autowired
    private ExcelRead excelRead;
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext= SpringApplication.run(SpringBootApplicaton.class, args);
        int exitcode= SpringApplication.exit(configurableApplicationContext);
        System.exit(exitcode);
    }

    @Override
    public void run(String... args) throws Exception {
//         excelRead.handleExcel();
        excelRead.insert();
    }
}
