package kr.co.ureca.s3aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect							//aspect로 등록?
@Component
public class AOPTest {
	
	public static final Logger logger = LoggerFactory.getLogger(AOPTest.class);
						//모든리턴타입 패키지경로.클래스.메소드(매개변수)의 형태
	@Before( "execution( * kr.co.ureca.*.controller.*.*(..) )" ) //괄호안에 포인트 컷 들어감, 이걸로 언제 실행될지 지정 가능
	public void aopBefore(JoinPoint joinPoint) {//joinpoint = 명시적으로 호출할 포인트를 적어주는애 (위에 excution을 구체적으로 적용할 대상)
		logger.info(">>>aopBefore start<<<");
		logger.info(joinPoint.toString());
		Date date = new Date();
		logger.info("aopBefore start time : "+date.toString());
		logger.info(">>>aopBefore end<<<");
	}
	
	@After( "execution( * kr.co.ureca.*.controller.*.*(..) )" )
	public void aopAfter(JoinPoint joinPoint) {
		logger.info(">>>aopAfter start<<<");
		logger.info(joinPoint.toString());
		Date date = new Date();
		logger.info("aopAfter start time : "+date.toString());
		logger.info(">>>aopAfter end<<<");
	}
	
	@Around( "execution( * kr.co.ureca.*.controller.*.*(..) )" ) //얘가 제일 먼저 돌음
	public void aopAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		logger.info(">>>aopAround start<<<");
		logger.info(joinPoint.toString());
		
		AOPAroundWork work = new AOPAroundWork();
		
		work.beforeMethod();
		
		Object result = joinPoint.proceed();		//procced는 object로 나옴
		logger.info(result.toString());
		
		work.afterMethod();
		
		logger.info(">>>aopAround end<<<");
		
	}
}
