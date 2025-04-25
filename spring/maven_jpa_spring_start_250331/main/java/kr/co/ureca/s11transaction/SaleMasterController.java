package kr.co.ureca.s11transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleMasterController {

	@Autowired
	private SaleMasterService service;
	
	@PostMapping("/sale_ins")
	public ResponseEntity<String> saleInsert(SaleMasterDTO dto) {
		service.saleInsert(dto);
		
		return ResponseEntity.ok("success");
	}
}
