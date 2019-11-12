package com.wirk.demo.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "0",urlPatterns = "/user/*")
public class UserFilter implements Filter {

  private Logger logger = LogManager.getLogger(this.getClass());

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    logger.debug("过滤器初始化成功!");
    logger.debug(filterConfig);
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
      logger.debug("------------------>>>>>>>filter");
      chain.doFilter(request,response);
  }

  @Override
  public void destroy() {
    logger.debug("过滤器销毁!");
  }
}
