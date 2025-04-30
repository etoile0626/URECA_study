package kr.co.ureca.s13batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component		//컴포넌트로 등록
public class BatchJobObjectType2 {
	
	private final static Logger logger = LoggerFactory.getLogger(BatchJobObjectType2.class);
	
	//@Scheduled(cron = "0/3 * * * * *")
	public void testScheduler1() {
		logger.info("testScheduler1");
	}
	
	//@Scheduled(cron = "0/3 * * * * *")
	public void testScheduler2() {
		logger.info("testScheduler2");
	}
	
	//@Scheduled(cron = "0/3 * * * * *")
	public void testScheduler3() {
		logger.info("testScheduler3");
	}
}
