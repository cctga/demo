package com.wirk.demo.config.async;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Mao LuDong
 * @date : Created in 15:40 2019/11/15
 */
@Configuration
@ConfigurationProperties(prefix = "task.pool")
public class ExecutePoolConfig {
  private int size;
  private int maxSize;
  private int keepAliveSeconds;
  private int queueCapacity;

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getMaxSize() {
    return maxSize;
  }

  public void setMaxSize(int maxSize) {
    this.maxSize = maxSize;
  }

  public int getKeepAliveSeconds() {
    return keepAliveSeconds;
  }

  public void setKeepAliveSeconds(int keepAliveSeconds) {
    this.keepAliveSeconds = keepAliveSeconds;
  }

  public int getQueueCapacity() {
    return queueCapacity;
  }

  public void setQueueCapacity(int queueCapacity) {
    this.queueCapacity = queueCapacity;
  }

  @Override
  public String toString() {
    return "ExecutePoolConfig{" +
               "size=" + size +
               ", maxSize=" + maxSize +
               ", keepAliveSeconds=" + keepAliveSeconds +
               ", queueCapacity=" + queueCapacity +
               '}';
  }
}
