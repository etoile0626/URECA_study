package kr.co.ureca.s11transaction;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleMasterService {
	
	@Autowired
	private SaleMasterRepository masterRepository;
	
	@Autowired
	private SaleDetailRepository detailRepository;
	
	public void saleInsert(SaleMasterDTO dto) {
		SaleMaster master = new SaleMaster();
		master.setSaleNo(dto.getSaleNo());
		master.setTotalPrice(dto.getTotalPrice());
		master.setSaleDate(LocalDateTime.now());
		masterRepository.save(master);
		
		//saledetaile은 여러개니까 여러개 저장
		for(int i = 0; i < dto.getProductNo().length; i++) {
			SaleDetail detail = new SaleDetail();
			detail.setMaster(master);
			detail.setProductNo(dto.getProductNo()[i]);
			detail.setQuantity(dto.getQuantity()[i]);
			detail.setPrice(dto.getPrice()[i]);
			detail.setDiscount(dto.getDiscount()[i]);
			detail.setSalePrice(dto.getSalePrice()[i]);
			detailRepository.save(detail);
		}
		
		
	}
}
