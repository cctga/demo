package com.wirk.demo.config.error;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Mao LuDong
 * @date : Created in 16:43 2019/11/20
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {
  @Override
  public void registerErrorPages(ErrorPageRegistry registry) {
    registry.addErrorPages(new ErrorPage("/sys/404.html"));
  }

//  @Bean
//  public EmbeddedServletContainerCustomizer containerCustomizer(){
//    return new EmbeddedServletContainerCustomizer();
//  }
}
