package kr.co.ureca.s8jpamap.manytomany.both;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.ureca.s8jpamap.manytomany.only.ProducerMTMOnly;
import kr.co.ureca.s8jpamap.manytomany.only.ProductMTMOnly;

@SpringBootTest
class ProductMTMBothRepositoryTest {
	
	public static final Logger logger = LoggerFactory.getLogger(ProductMTMBothRepositoryTest.class);

	@Autowired
	private ProducerMTMBothRepository producerRepository;
	
	@Autowired
	private ProductMTMBothRepository productRepository;

	@Test
	void test() {
		ProductMTMBoth product1 = new ProductMTMBoth();
		product1.setName("양파링"); product1.setPrice(1500); product1.setStock(300);
		product1 = productRepository.save(product1);
		
		ProductMTMBoth product2 = new ProductMTMBoth();
		product2.setName("새우깡"); product2.setPrice(1500); product2.setStock(500);
		product2 = productRepository.save(product2);
		
		ProductMTMBoth product3 = new ProductMTMBoth();
		product3.setName("포카칩"); product3.setPrice(1500); product3.setStock(700);
		product3 = productRepository.save(product3);
		
		ProducerMTMBoth producer1 = new ProducerMTMBoth();
		producer1.setName("농심 전북 공장");
		producer1 = producerRepository.save(producer1);
		
		ProducerMTMBoth producer2 = new ProducerMTMBoth();
		producer2.setName("농심 전남 공장");
		producer2 = producerRepository.save(producer2);
		
		//교차로 add 후 저장
		//producer
		producer1.addProduct(product1);
		producer1.addProduct(product2);
		producer1 = producerRepository.save(producer1);
		
		producer2.addProduct(product2);
		producer2.addProduct(product3);
		producer2 = producerRepository.save(producer2);
		
		//product
		product1.addProducer(producer1);
		product1 = productRepository.save(product1);
		
		product2.addProducer(producer1);
		product2.addProducer(producer2);
		product2 = productRepository.save(product2);
		
		product3.addProducer(producer2);
		product3 = productRepository.save(product3);
		
	}

}
