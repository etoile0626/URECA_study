package kr.co.ureca.s13batch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

//@Configuration
//@EnableScheduling
public class BatchConfigType1 {

	//@Bean
	public BatchJobObjectType1 createBatchJobObjectType1() {
		return new BatchJobObjectType1();
	}
}
