package kr.co.ureca.s3aop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AOPAroundWork { // AOP @Around의 실행 클래스

	public static final Logger logger = LoggerFactory.getLogger(AOPAroundWork.class);

	public void beforeMethod() {
		logger.info(">>> beforeMethod <<<");
	} // beforeMethod

	public void afterMethod() {
		logger.info(">>> afterMethod <<<");
	} // afterMethod

} // class
