package kr.co.ureca.s11transaction;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="sale_detail")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private SaleMaster master;
	
	@Column(name="product_no")
	private String productNo;
	
	private Integer quantity;
	
	private Integer price;
	
	private Integer discount;
	
	@Column(name="sale_price")
	private Integer salePrice;
	
	
}
