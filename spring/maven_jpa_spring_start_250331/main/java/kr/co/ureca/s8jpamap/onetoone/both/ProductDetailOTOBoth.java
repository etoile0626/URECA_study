package kr.co.ureca.s8jpamap.onetoone.both;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kr.co.ureca.entity.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString (callSuper = true) //말 그대로 super를 부르겠다는 뜻
@EqualsAndHashCode ( callSuper = true)
@Table(name = "product_detail_oto_both")
public class ProductDetailOTOBoth extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@OneToOne		//얘랑 1:1 연관 관계임을 명시
	//@OneToOne(optional = true) product 값 없이 detail 클래스 매핑 가능 <-> false는 불가, default는 true
	@JoinColumn(name = "product_number") //product 객체의 number 변수와 join한다
	private ProductOTOBoth product;
}
