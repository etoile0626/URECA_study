package kr.co.ureca.s8jpamap.manytoone.both;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ProviderMTOBothRepositoryTest {

	public static final Logger logger = LoggerFactory.getLogger(ProviderMTOBothRepositoryTest.class);

	@Autowired
	private ProviderMTOBothRepository providerRepository;
	
	@Autowired
	private ProductMTOBothRepository productRepository;
	
	@Test
	void test() {
		
		ProviderMTOBoth provider = new ProviderMTOBoth();
		provider.setName("오뚜기");
		ProviderMTOBoth savedProvider = providerRepository.save(provider);
		
		ProductMTOBoth product1 = new ProductMTOBoth();
		product1.setName("진라면 매운맛"); product1.setPrice(1000); product1.setStock(1000);
		product1.setProvider(savedProvider);
		
		ProductMTOBoth product2 = new ProductMTOBoth();
		product2.setName("진라면 순한맛"); product2.setPrice(1000); product2.setStock(500);
		product2.setProvider(savedProvider);
		
		/*
		savedProvider.getList().add(product1);
		savedProvider.getList().add(product2);
		providerRepository.save(savedProvider);	*/	//이런식으로는 저장 안 됨->mappedBy = "provider"이기 때문?
		
		
		productRepository.save(product1);
		productRepository.save(product2);			//이런식으로 저장햐여함
		
		logger.info("test start ======================");
		logger.info(savedProvider.toString());
		logger.info("test end =========================");
		
	}

}
