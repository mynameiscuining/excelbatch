package cn.njyazheng.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class AsyncConfig implements AsyncConfigurer {
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
        threadPoolExecutor.setWaitForTasksToCompleteOnShutdown(true);//等待任务在关机时完成--表明等待所有线程执行完
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
