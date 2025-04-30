package kr.co.ureca.s13batch;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
/* cron = "초 분 시 일 월 요일" , 정해진 시각마다 반복?
 * @Scheduled(cron = "0/3 * * * * *") //없는 자리는 *로 쓰기, 3초마다 모든분 모든시 모든일 모든월 모든요일
 * @Scheduled(cron = "5 * * * * *") //없는 자리는 *로 쓰기,"매분" 5초마다 모든분 모든시 모든일 모든월 모든요일
 * @Scheduled(cron = "5 14 15 * * 0") //없는 자리는 *로 쓰기, 5초 14분 15시 모든일 모든월 일요일
 */
public class BatchJobObjectType1 {

	//@Scheduled(cron = "0/5 * * * * *") 
	//@Scheduled(fixedRate = 3000) 	//작업 시작부터 시간을 측정
	public void testScheduler1() {
		System.out.println("BatchJobObjectType1 - testScheduler1");
	}
	
	//@Async		//@SpringBootApplication  또는 @Configuration에 @EnableAsync를 추가해야 사용 가능!
	//@Scheduled(fixedDelay = 3000) 	//작업 종료부터 시간을 측정
	public void testScheduler2() {
		System.out.println("BatchJobObjectType1 - testScheduler2");
	}
	
}
