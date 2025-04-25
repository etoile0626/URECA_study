package kr.co.ureca.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "emp")
@Entity
@Getter
@Setter
@ToString( callSuper = true )
@NoArgsConstructor
@AllArgsConstructor
public class Emp extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "empno", nullable = false, unique = true)
	private Integer empno;

	@Column(name = "ename", nullable = true, unique = false, length = 255)
	private String ename;

	@Column
	private String job;

	@Column
	private Integer mgr;

	@Column
	private String hiredate;

	@Column
	private Integer sal;

	@Column
	private Integer comm;

	@Column
	private Integer deptno;

	// @Transient : DB에 반영 안하는 자바 변수.
	@Transient
	private LocalDateTime createUser;

	@Transient
	private LocalDateTime updateUser;

} // class
