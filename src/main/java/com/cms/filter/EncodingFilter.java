package com.cms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encoding;

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (request.getCharacterEncoding() == null) {
			String encoding = getEncoding();
			if (encoding != null) {
				request.setCharacterEncoding(encoding);
			}
		}
		response.setContentType("text/html;charset=" + encoding);
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);

	}

	public void init(FilterConfig filterconfig) throws ServletException {
		this.encoding = filterconfig.getInitParameter("encoding");
	}

}
