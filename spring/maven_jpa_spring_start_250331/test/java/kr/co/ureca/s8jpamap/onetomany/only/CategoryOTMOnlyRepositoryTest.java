package kr.co.ureca.s8jpamap.onetomany.only;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.ureca.s8jpamap.manytomany.both.ProductMTMBoth;

@SpringBootTest
class CategoryOTMOnlyRepositoryTest {

	public static final Logger logger = LoggerFactory.getLogger(CategoryOTMOnlyRepositoryTest.class);

	@Autowired
	private ProductOTMOnlyRepository productRepository;

	@Autowired
	private CategoryOTMOnlyRepository categoryRepository;

	@Test
	void test() {
		ProductOTMOnly product1 = new ProductOTMOnly();
		product1.setName("양파링"); product1.setPrice(1500); product1.setStock(300);
		product1 = productRepository.save(product1);

		CategoryOTMOnly category1 = new CategoryOTMOnly();
		category1.setName("봉지 과자류");
		category1.getList().add(product1);
		category1 = categoryRepository.save(category1);

		logger.info("test start ======================");
		logger.info(category1.getList().toString());
		logger.info("test end =========================");
	} // test

} // class
