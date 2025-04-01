package kr.co.ureca.s3aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AOPAroundWork {
	
	public static final Logger logger = LoggerFactory.getLogger(AOPAroundWork.class);
	
	public void beforeMethod() {
		logger.info(">>>BeforeMethod<<<");
	}
	
	public void afterMethod() {
		logger.info(">>>afterMethod<<<");
	}

}
