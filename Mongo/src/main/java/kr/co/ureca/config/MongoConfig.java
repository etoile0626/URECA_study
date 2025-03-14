package kr.co.ureca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/* 스프링 몽고DB 연동
 * 1. Mongo250314Application -> @SpringBootApplication(exclude={DataSourceAutoConfiguration.class}) 적용
 * 2. application.properties 설정
		spring.data.mongodb.host=127.0.0.1
		spring.data.mongodb.port=27017
		spring.data.mongodb.database=ureca
 * 3. 아래 @Configuration 설정 참고
 */

//@Configuration //configuration 파일로 만드는 어노테이션
public class MongoConfig {

	public MongoClient mongoClient() {
		return MongoClients.create("mongodb://localhost:27017");
	} // mongoClient

	public SimpleMongoClientDatabaseFactory mongoClientDBFactory() {
		return new SimpleMongoClientDatabaseFactory(mongoClient(), "ureca");
	} // mongoClientDBFactory

//	@Bean // 객체 등록을 해주는 어노테이션
	public MongoOperations mongoOps() {
		return new MongoTemplate(mongoClientDBFactory());
	} // mongoOps

} // class
