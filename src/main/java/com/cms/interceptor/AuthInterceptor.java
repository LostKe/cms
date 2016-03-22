package com.cms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cms.annotation.AuthPassport;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			 AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);
			if (authPassport != null && authPassport.validate()) {
				// TODO 进行权限判断
				System.out.println("处理权限");
			}
		}
		return true;
	}

}
