package kr.co.ureca.s8jpamap.manytomany.only;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

class ProducerMTMOnlyRepositoryTest {

	public static final Logger logger = LoggerFactory.getLogger(ProducerMTMOnlyRepositoryTest.class);

	@Autowired
	private ProducerMTMOnlyRepository producerRepository;
	
	@Autowired
	private ProductMTMOnlyRepository productRepository;
	
	@Test
	void test() {
		
		ProductMTMOnly product1 = new ProductMTMOnly();
		product1.setName("양파링"); product1.setPrice(1500); product1.setStock(300);
		product1 = productRepository.save(product1);
		
		ProductMTMOnly product2 = new ProductMTMOnly();
		product2.setName("새우깡"); product2.setPrice(1500); product2.setStock(500);
		product2 = productRepository.save(product2);
		
		ProductMTMOnly product3 = new ProductMTMOnly();
		product3.setName("포카칩"); product3.setPrice(1500); product3.setStock(700);
		product3 = productRepository.save(product3);
		
		ProducerMTMOnly producer1 = new ProducerMTMOnly();
		producer1.setName("농심 충북 공장");
		
		producer1.addProduct(product1);
		producer1.addProduct(product2);
		
		ProducerMTMOnly producer2 = new ProducerMTMOnly();
		producer2.setName("농심 경북 공장");
		
		producer2.addProduct(product2);
		producer2.addProduct(product3);
		
		producerRepository.save(producer1);
		producerRepository.save(producer2);
		
	}

}
