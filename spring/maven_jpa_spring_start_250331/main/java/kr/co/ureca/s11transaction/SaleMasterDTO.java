package kr.co.ureca.s11transaction;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleMasterDTO {
	private String saleNo;
	
	private Integer totalPrice;
	
	private String[] productNo;
	
	private Integer[] quantity;
	
	private Integer[] price;
	
	private Integer[] discount;
	
	private Integer[] salePrice;
}
