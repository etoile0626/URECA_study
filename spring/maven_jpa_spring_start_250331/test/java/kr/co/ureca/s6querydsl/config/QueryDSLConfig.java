package kr.co.ureca.s6querydsl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Configuration	//설정 파일임을 의미
public class QueryDSLConfig {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Bean		//이거 쓰려고 config함
	public JPAQueryFactory jpaQueryFactory(){
		
		return new JPAQueryFactory(entityManager);
	}
}
