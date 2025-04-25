package kr.co.ureca.s3aop.config;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPConfig {

	public static final Logger logger = LoggerFactory.getLogger(AOPConfig.class);

	@Before( "execution(* kr.co.ureca.*.controller.*.*(..) )" )
	public void aopBefore(JoinPoint joinPoint) {
		logger.info( ">>> aopBefore start <<<" );
		logger.info( joinPoint.toString() );
		Date date = new Date();
		logger.info( "aopBefore start time : " + date.toString() );
		logger.info( ">>> aopBefore end <<<" );
	} // aopBefore

	@After( "execution(* kr.co.ureca.*.controller.*.*(..))" )
	public void aopAfter(JoinPoint joinPoint) {
		logger.info( ">>> aopAfter start <<<" );
		logger.info( joinPoint.toString() );
		Date date = new Date();
		logger.info( "aopAfter start time : " + date.toString() );
		logger.info( ">>> aopAfter end <<<" );
	} // aopAfter

//	@Around( "execution(* kr.co.ureca.*.controller.*.*(..))" )
	public void aopAround(ProceedingJoinPoint joinPoint) throws Throwable {

		logger.info(">>> aopAround start <<<");
		logger.info( joinPoint.toString() );

		AOPAroundWork work = new AOPAroundWork();

		work.beforeMethod();

		Object result = joinPoint.proceed();

		work.afterMethod();

		logger.info( result.toString() );
		logger.info(">>> aopAround end <<<");
	} // aopAround

} // class
