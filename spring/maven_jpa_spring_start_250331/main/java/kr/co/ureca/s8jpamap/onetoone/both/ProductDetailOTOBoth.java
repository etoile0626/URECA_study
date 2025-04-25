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
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "product_detail_oto_both")
public class ProductDetailOTOBoth extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

//	@OneToOne(optional = true) // product 값이 없이 detail 객체를 생성 가능. - default
//	@OneToOne(optional = false) // product 값이 없이 detail 객체를 생성 불가능.
	@OneToOne
	@JoinColumn(name = "product_number")
	private ProductOTOBoth product;

} // class
