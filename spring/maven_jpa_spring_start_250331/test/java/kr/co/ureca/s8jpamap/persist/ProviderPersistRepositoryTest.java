package kr.co.ureca.s8jpamap.persist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProviderPersistRepositoryTest {

	public static final Logger logger = LoggerFactory.getLogger(ProviderPersistRepositoryTest.class);

	@Autowired
	private ProductPersistRepository productRepository;
	
	@Autowired
	private ProviderPersistRepository providerRepository;
	
	@Test
	void test() {
		//=================test1========================
		ProductPersist product1 = new ProductPersist();
		product1.setName("오징어짬뽕"); product1.setPrice("1500"); product1.setStock("200");
		
		ProductPersist product2 = new ProductPersist();
		product2.setName("배홍동"); product2.setPrice("1500"); product2.setStock("800");
		
		ProviderPersist provider = new ProviderPersist();
		provider.setName("농심홀딩스");
		provider.getProductList().add(product1);
		provider.getProductList().add(product2);
		ProviderPersist savedProvider =  providerRepository.save(provider);		//이러면 product도 같이 저장됨? 연관관계라서?
		
		logger.info("test start ======================");
		logger.info(provider.getProductList().toString());
		logger.info("test end =========================");
		
		
		//=================test2. orphanRemoval = true 적용 전========================
		//providerRepository.delete(savedProvider); ->고아 객체 남아있음
		
		//=================test3. orphanRemoval = true 적용 후========================
		//providerRepository.delete(savedProvider); ->고아 객체 제거
		
		
	}

}
