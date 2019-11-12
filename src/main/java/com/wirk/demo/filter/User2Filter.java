package com.wirk.demo.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "2" ,urlPatterns = "/user/*" )
public class User2Filter implements Filter {

  private Logger logger = LogManager.getLogger(this.getClass());

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    logger.debug("过滤器2初始化成功!");
    logger.debug(filterConfig);
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
      logger.debug("------------------>>>>>>>filter2");
    System.out.println(request.getAttribute("hello"));
      chain.doFilter(request,response);
  }

  @Override
  public void destroy() {
    logger.debug("过滤器2销毁!");
  }
}

