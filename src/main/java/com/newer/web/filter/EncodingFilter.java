package com.newer.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter{
	
	private String encoder;//字符集编码格式

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)arg0;
		HttpServletResponse resp=(HttpServletResponse)arg1;
		
		req.setCharacterEncoding(encoder);
		resp.setContentType("text/html;charset="+encoder);
		
		//System.out.println("完成"+encoder+"转码");
		
		//通过当前过滤器
		arg2.doFilter(req, resp);
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//通过配置外部参数获取字符集编码格式
		encoder=filterConfig.getInitParameter("encoder");
	}
	
	

}
