package kr.co.ureca.s4interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration //설정 been 등록
public class InterceptorConfig extends WebMvcConfigurationSupport{
	//config = 실행환경 파일 
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
			//addIntercepotr test =   new InterceptorTest()); // InterceptorTest 객체를 인터셉트로
		// addPathPatterns : 인터셉터를 적용한 주소
		// excludePathPatterns : 인터셉터를 적용하지 않은 주소
		registry.addInterceptor(new InterceptorTest())
				//.addPathPatterns("/*"); //전체 url에 적용
				.addPathPatterns("/itcp1")
				.excludePathPatterns("/itcp2");
	}
	
	@Override
	protected void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}	//얘가 application properties 보다 우선
}
