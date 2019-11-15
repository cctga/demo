package com.wirk.demo.config.async;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author : Mao LuDong
 * @date : Created in 15:30 2019/11/15
 */
@Configuration
@EnableAsync
public class ExecutePool implements AsyncConfigurer {

  private static final Logger log = LogManager.getLogger(ExecutePool.class);

  @Resource
  private ExecutePoolConfig executePoolConfig;

  @Override
  public Executor getAsyncExecutor() {
    log.info("线程池初始化使用参数：{}",executePoolConfig);
    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    threadPoolTaskExecutor.setCorePoolSize(executePoolConfig.getSize());
    threadPoolTaskExecutor.setMaxPoolSize(executePoolConfig.getMaxSize());
    threadPoolTaskExecutor.setQueueCapacity(executePoolConfig.getQueueCapacity());
    threadPoolTaskExecutor.setKeepAliveSeconds(executePoolConfig.getKeepAliveSeconds());
    threadPoolTaskExecutor.setThreadNamePrefix("Executor-");
    threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    threadPoolTaskExecutor.initialize();
    return threadPoolTaskExecutor;
  }

  @Override
  public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return (arg0, arg1, arg2) -> {
      log.error("==========================" + arg0.getMessage() + "=======================", arg0);
      log.error("exception method:" + arg1.getName());
    };
  }
}
