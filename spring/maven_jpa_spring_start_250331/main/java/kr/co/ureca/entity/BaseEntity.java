package kr.co.ureca.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass		//super class 하는 역할임을 의미, 얘가 있어야 child와 원할히 교환가능
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	
	@CreatedDate				//입력 시간 자동 세팅
	@Column(updatable = false)	//업데이트 못하게 막기
	private LocalDateTime createdAt;	
	
	@LastModifiedDate				//수정 시간 자동 세팅
	private LocalDateTime modifiedAt;

}
