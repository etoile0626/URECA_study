package kr.co.ureca.s13batch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

//@Configuration
//@EnableScheduling <-주석처리 안하면 서버 띄울때마다 돌아감
public class BatchConfigType2 implements SchedulingConfigurer{

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		//batch를 도는 스레드 풀 설정
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(10);
		taskScheduler.setThreadNamePrefix("Scheduling - ");		//logger 출력 앞에 들어오는 이름
		taskScheduler.initialize();
		
		taskRegistrar.setTaskScheduler(taskScheduler);
	}
}
