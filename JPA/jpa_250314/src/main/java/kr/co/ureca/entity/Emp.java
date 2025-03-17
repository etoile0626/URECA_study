package kr.co.ureca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity	//엔티티임을 표시하는 어노테이션 => db와 매핑되는 엔티티, 즉 테이블이 됨
@AllArgsConstructor
@NoArgsConstructor
@Table(name="emp") 		//클래스명과 테이블 명이 다르면 어노테이션에 name 속성으로 테이블 이름 끌어오기 가능
@Getter
@Setter
@ToString				//연관 관계가 있을때 tostring은 꽤 위험한 트리거가 될 수 있음 -> 조심할 것 
public class Emp {
	
	@Id							//pk임을 지칭하는 어노테이션
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//=autoinclement
	@Column(name = "id")		//속성임을 지칭						
	private Long id;			//사실상 pk값, serialVersionUID로 사용한다고 봐도 됨 (serialVersionUID : 동일객체 여부 검사 UID)
	
	@Column(name = "empno")	
	private Integer empno;
	
	@Column(name = "ename")	
	private String ename;
	
	@Column(name = "job")	
	private String job;
	
	@Column(name = "mgr")	
	private Integer mgr;
	
	@Column(name = "hiredate")	
	private String hiredate;
	
	@Column(name = "sal")	
	private Integer sal;
	
	@Column(name = "comm")	
	private Integer comm;		//null 들어간 애들은 String(혹은 Integer로? String 권장)으로 지칭해주는게 좋음
	
	@Column(name = "deptno")	
	private Integer deptno;
	
}
