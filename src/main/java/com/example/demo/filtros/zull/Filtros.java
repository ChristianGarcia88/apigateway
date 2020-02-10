package com.example.demo.filtros.zull;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class Filtros   extends  ZuulFilter {

	private  Logger  log=  Logger.getLogger(Filtros.class);
	@Override
public String filterType() {
	// TODO Auto-generated method stub
	return "pre";
}
	
	
	
	@Override
	public Object run() throws ZuulException {
		RequestContext  ctx  = RequestContext.getCurrentContext();
		HttpServletRequest  request  =  ctx.getRequest();
		
		float   tiempoInicial=   System.currentTimeMillis();
		System.out.println("zull request--------------------------------------------------------------------------------------------------------" + tiempoInicial);
		
		log.info("metodo requerido:" +request.getMethod() + " ,   url requerida"  + request.getRequestURI());
	
		request.setAttribute("tiempoInicial", tiempoInicial);
		
		return null;
	}
	
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}
	
}
