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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebFilter(filterName = "1", urlPatterns = "/user/*")
public class User1Filter implements Filter {

  private Logger logger = LogManager.getLogger(this.getClass());

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    logger.debug("过滤器1初始化成功!");
    logger.debug(filterConfig);
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    logger.debug("------------------>>>>>>>filter1");
    request.setAttribute("hello", 'c');
    Map<String, String[]> parameterMap = request.getParameterMap();
//    if (parameterMap.get("name")[0].equals("xxx")) {
//      HttpServletRequest req = ((HttpServletRequest) request);
//      req.getRequestDispatcher("/main/paramsError").forward(request,response);
//    } else {
//      chain.doFilter(request, response);
//    }
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    logger.debug("过滤器1销毁!");
  }
}
