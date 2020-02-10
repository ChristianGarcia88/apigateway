package com.example.demo.filtros.zull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class FiltroPost   extends  ZuulFilter {

	private  Logger  log=  Logger.getLogger(FiltroPost.class);
	@Override
public String filterType() {
	// TODO Auto-generated method stub
	return "post";
}
	
	
		
	@Override
	public Object run() throws ZuulException {
		RequestContext  ctx  = RequestContext.getCurrentContext();
		HttpServletRequest request  =  ctx.getRequest();
		
		float   tiempoFinal=   System.currentTimeMillis();
		float tiempoCompleto=  tiempoFinal -  (float) request.getAttribute("tiempoInicial"); 
		System.out.println("zull post"+ tiempoFinal);
		log.info(tiempoCompleto );
	
		
		
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
