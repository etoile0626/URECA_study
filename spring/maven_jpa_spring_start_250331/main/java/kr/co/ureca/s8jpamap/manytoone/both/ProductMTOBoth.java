package kr.co.ureca.s8jpamap.manytoone.both;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "product_mto_both")
public class ProductMTOBoth extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long number;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Integer price;
	
	@Column(nullable = false)
	private Integer stock;
	
	@ManyToOne								//product 여러개에 하나의 provider product 존재
	@JoinColumn(name = "provider_id")
	@ToString.Exclude
	private ProviderMTOBoth provider;		
}
