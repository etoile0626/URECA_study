package kr.co.ureca.s4interceptor.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InterceptorWorker implements HandlerInterceptor {

	public static final Logger logger = LoggerFactory.getLogger(InterceptorWorker.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info( ">>> preHandle <<< : " + request.getRequestURI() );
		logger.info( ">>> preHandle <<< : " + request.getQueryString() );

		return HandlerInterceptor.super.preHandle(request, response, handler);
	} // preHandle

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		logger.info( ">>> postHandle <<< : " + modelAndView.getViewName() );
		logger.info( ">>> postHandle <<< : " + modelAndView.getModel() );
		logger.info( ">>> postHandle <<< : " + request.getAttribute("author") );

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String realtime = sdf.format( new Date() );

		Cookie coo2 = new Cookie("realtime", realtime);
		response.addCookie(coo2);

		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	} // postHandle

} // class
