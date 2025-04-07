package kr.co.ureca.s8jpamap.onetoone.both;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "product_oto_both")
public class ProductOTOBoth extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long number;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Integer price;
	
	@Column(nullable = false)
	private Integer stock;
	
	@OneToOne(mappedBy = "product")			//product 쪽이 주체임을 의미
	@ToString.Exclude		//toString 제외점
	private ProductDetailOTOBoth productDetail;
	
	
}
