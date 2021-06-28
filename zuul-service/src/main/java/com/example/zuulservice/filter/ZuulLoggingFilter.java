package com.example.zuulservice.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

// 스테레오 타입으로 지정 할 수 있음.
// 일반적인 컴포넌트, 빈 상태로 등록 할때는 컴포넌트로 등록한다.
@Slf4j  //lombok
@Component
public class ZuulLoggingFilter extends ZuulFilter{
	//Logger logger = org.slf4j.LoggerFactory.getLogger(ZuulLoggingFilter.class);

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		log.info("************* printing logs: ");
		
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		
		
		log.info("************* printing logs: "+request.getRequestURI());
		return null;
	}
	
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
