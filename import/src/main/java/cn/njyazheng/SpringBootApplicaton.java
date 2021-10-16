package cn.njyazheng;

import cn.njyazheng.dao.DepartmentMapper;
import cn.njyazheng.dao.GuestCardMapper;
import cn.njyazheng.domain.*;
import cn.njyazheng.excel.ExcelReaderService;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@SpringBootApplication
@MapperScan("cn.njyazheng.dao")
public class SpringBootApplicaton implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootApplicaton.class);
    @Autowired
    private GuestCardMapper cardMapper;
    @Autowired
    private DepartmentMapper departmentMapper;


    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringBootApplicaton.class, args);
        int exitcode = SpringApplication.exit(configurableApplicationContext);
        System.exit(exitcode);
    }

    @Override
    public void run(String... args) throws Exception {
        //jiuyue();
        kecan();
    }


    private void jiuyue() {
        EasyExcel.read("E:\\用户\\餐饮系统导出数据\\用户管理_导出2109181853.xlsx", UU.class, new AnalysisEventListener<UU>() {
            List<UU> uus = new ArrayList<>();
            /**
             * 单次缓存的数据量
             */
            public static final int BATCH_COUNT = 3000;

            @Override
            public void invoke(UU data, AnalysisContext context) {
                if (data.getUsercode().equals("2106280454")||data.getCardtype().indexOf("客餐") > -1||data.getUsername().indexOf("WL")>-1||data.getUsername().indexOf("WX")>-1) {
                    LOGGER.info("{}",data.toString());
                    uus.add(data);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                Map<String, Integer> map = uus.stream().collect(Collectors.toMap(UU::getUsercode, c -> 1));
                //读取excel
                //
                List<Consums> cachedDataConsums = new ArrayList<>();
                Map<String, String> usercodedanme = new HashMap<>();
                EasyExcel.read("D:\\资料\\餐饮\\12\\202109_20210924121442.xlsx", Consums.class, new AnalysisEventListener<Consums>() {
                    /**
                     *临时存储
                     */
                    @Override
                    public void invoke(Consums data, AnalysisContext context) {
                        if (map.get(data.getUsercode()) == null) {
                            LOGGER.info("{}", data);
                            String dname = usercodedanme.get(data.getUsercode());
                            if (dname == null) {
                                Department department = departmentMapper.selectByUserCode(data.getUsercode());
                                if (department == null) {
                                    data.setDanme("未查询到部门");
                                } else {
                                    data.setDanme(department.getDname());
                                }
                                usercodedanme.put(data.getUsercode(), data.getDanme());
                            } else {
                                data.setDanme(dname);
                            }
                            cachedDataConsums.add(data);
                        }
                    }

                    @Override
                    public void doAfterAllAnalysed(AnalysisContext context) {
                        //saveData();
                        LOGGER.info("1111111111111111111111111111111111111111111111111111111111111111！");
                        Map<String, List<Consums>> stringConsumsMap = cachedDataConsums.stream().collect(Collectors.groupingBy(Consums::getDanme));
                        ExcelWriter build = null;
                        try {
                            build = EasyExcel.write("D:\\资料\\餐饮\\13\\9月.xlsx", Consums.class).build();
                            int i = 0;
                            for (Map.Entry<String, List<Consums>> entry : stringConsumsMap.entrySet()) {
                                WriteSheet writeSheet = EasyExcel.writerSheet(i, entry.getKey()).build();
                                build.write(entry.getValue(), writeSheet);
                                i++;
                            }
                        } finally {
                            if (build != null) {
                                build.finish();
                            }
                        }
                    }

                    /**
                     * 加上存储数据库
                     */
                    private void saveData() {

                    }
                }).sheet().doRead();

            }

        }).sheet().doRead();
    }

    private void kecan() {





        EasyExcel.read("E:\\用户\\餐饮系统导出数据\\用户管理_导出2109181853.xlsx", UU.class, new AnalysisEventListener<UU>() {
            List<UU> uus = new ArrayList<>();
            /**
             * 单次缓存的数据量
             */
            public static final int BATCH_COUNT = 3000;

            @Override
            public void invoke(UU data, AnalysisContext context) {
                if (data.getCardtype().indexOf("院本部客餐") > -1||data.getUsercode().equals("2106280454")) {
                    LOGGER.info("{}",data.toString());
                    uus.add(data);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                Map<String, Integer> map = uus.stream().collect(Collectors.toMap(UU::getUsercode, c -> 1));
                //读取excel
                //
                String ss = "D:\\资料\\餐饮\\12\\";

                File file = new File(ss);
                File[] files = file.listFiles();
                for (File f : files) {
                    List<Consums> cachedDataConsums = new ArrayList<>();
                    LOGGER.info("文件:{}", f.getName());
                    EasyExcel.read(ss + f.getName(), Consums.class, new AnalysisEventListener<Consums>() {
                        /**
                         * 单次缓存的数据量
                         */
                        public static final int BATCH_COUNT = 3000;

                        /**
                         *临时存储
                         */


                        @Override
                        public void invoke(Consums data, AnalysisContext context) {
                            if (map.get(data.getUsercode()) != null) {
                                LOGGER.info("{}", data);
                                cachedDataConsums.add(data);
                            }
                        }

                        @Override
                        public void doAfterAllAnalysed(AnalysisContext context) {
                            LOGGER.info("1111111111111111111111111111111111111111111111111111111111111111！");
                            EasyExcel.read("D:\\资料\\餐饮\\老系统操作员餐饮公司.xlsx", Oper.class, new AnalysisEventListener<Oper>() {
                                /**
                                 * 单次缓存的数据量
                                 */
                                public static final int BATCH_COUNT = 3000;
                                /**
                                 *临时存储
                                 */
                                private List<Oper> cachedDataOper = new ArrayList<>();

                                @Override
                                public void invoke(Oper data, AnalysisContext context) {
                                    cachedDataOper.add(data);
                                }

                                @Override
                                public void doAfterAllAnalysed(AnalysisContext context) {
                                    Map<String, String> mapoper = cachedDataOper.stream().collect(Collectors.toMap(Oper::getOper, Oper::getCompany));
                                    List<Consums> temp = cachedDataConsums.stream().filter(consums -> mapoper.get(consums.getSaller()) != null).collect(Collectors.toList());
                                    EasyExcel.write("D:\\资料\\餐饮\\13\\客餐" + f.getName(), Consums.class)
                                            .sheet("模板")
                                            .doWrite(temp);
                                }

                            }).sheet().doRead();
                        }

                        /**
                         * 加上存储数据库
                         */
                        private void saveData() {

                        }
                    }).sheet().doRead();

                }
            }

        }).sheet().doRead();

    }
}
