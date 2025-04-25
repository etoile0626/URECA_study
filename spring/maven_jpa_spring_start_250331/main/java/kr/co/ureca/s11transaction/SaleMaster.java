package kr.co.ureca.s11transaction;

import java.time.LocalDateTime;

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

@Entity
@Table(name="sale_master")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="sale_no")
	private String saleNo;
	
	@Column(name="total_price")
	private Integer totalPrice;
	
	@Column(name="sale_date")
	private LocalDateTime saleDate;
}
