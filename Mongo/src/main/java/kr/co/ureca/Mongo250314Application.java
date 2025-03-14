package kr.co.ureca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}) //자동실행환경 잡는 것을 예외처리 해둠
public class Mongo250314Application {

	public static void main(String[] args) {
		SpringApplication.run(Mongo250314Application.class, args);
	}

}
