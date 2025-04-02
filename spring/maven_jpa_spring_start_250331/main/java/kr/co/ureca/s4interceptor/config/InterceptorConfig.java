package kr.co.ureca.s4interceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//WebMvcConfigurationSupport 상속 받았으면 @Configuration 떼고 젤 밑에 메소드 하나 추가해야 사용가능
//@Configuration // 설정 Bean 등록 
public class InterceptorConfig extends WebMvcConfigurationSupport {

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {

		// addInterceptor( new InterceptorTest() ) : InterceptorTest 객체를 인터셉터로 등록.
		// addPathPatterns : 인터셉터를 적용할 주소 패턴.
		// excludePathPatterns : 인터셉터를 적용하지 않을 주소 패턴.
		registry.addInterceptor( new InterceptorWorker() )
//				.addPathPatterns("/*") // 전체 URL에 적용.
				.addPathPatterns("/itcp1")
				.excludePathPatterns("/itcp2");

	} // addInterceptors

	@Override
	protected void configureViewResolvers(ViewResolverRegistry registry) {

		// WebMvcConfigurationSupport가 application.properties보다 우선.
		registry.jsp("/WEB-INF/views/", ".jsp");

	} // configureViewResolvers
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {

	registry.addResourceHandler("/swagger-ui/**")
	.addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/5.17.14/");
	} // addResourceHandlers

} // class
