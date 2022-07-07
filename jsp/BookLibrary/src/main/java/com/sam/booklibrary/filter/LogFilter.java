/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.booklibrary.filter;

import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tuancat
 */
@WebFilter("/*")
public class LogFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init Log Filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      String ipAddress = request.getRemoteAddr();
      HttpServletResponse httpResp = (HttpServletResponse) response;
      Date d = new Date();
      // Log the IP address and current timestamp.
      System.out.println("IP "+ ipAddress + ", Time "  + d.toString());

      // Pass request back down the filter chain
      chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
