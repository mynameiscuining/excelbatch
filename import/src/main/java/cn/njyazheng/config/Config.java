package cn.njyazheng.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class Config  implements AsyncConfigurer {
    /**
     * 数据源配置
     *
     * @param
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        return dataSource;
    }

    //退出
    @Bean
    public ExitCodeGenerator exitCodeGenerator(){
        return  ()->42;
    }

    //线程池
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor=new ThreadPoolTaskExecutor();
        //配置核心线程数
        threadPoolExecutor.setCorePoolSize(50);
        //配置最大线程数
        threadPoolExecutor.setMaxPoolSize(50);
        //配置队列大小
        threadPoolExecutor.setQueueCapacity(400);
        //配置线程池中的线程的名称前缀
        threadPoolExecutor.setThreadNamePrefix("thread-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.initialize();
        return threadPoolExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
