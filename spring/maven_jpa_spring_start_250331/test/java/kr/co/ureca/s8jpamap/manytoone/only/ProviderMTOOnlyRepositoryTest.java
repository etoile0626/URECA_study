package kr.co.ureca.s8jpamap.manytoone.only;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProviderMTOOnlyRepositoryTest {

	public static final Logger logger = LoggerFactory.getLogger(ProviderMTOOnlyRepositoryTest.class);

	@Autowired
	private ProductMTOOnlyRepository productRepository;

	@Autowired
	private ProviderMTOOnlyRepository providerRepository;

	@Test
	void test() {
		ProviderMTOOnly provider = new ProviderMTOOnly();
		provider.setName("넝심");
		ProviderMTOOnly savedProvider = providerRepository.save(provider);

		ProductMTOOnly product = new ProductMTOOnly();
		product.setName("노래방 양파링 대용량"); product.setPrice(5000); product.setStock(500);
		product.setProvider(savedProvider);
		ProductMTOOnly savedProduct = productRepository.save(product);

		ProductMTOOnly product2 = new ProductMTOOnly();
		product2.setName("신라면 멀티팩"); product2.setPrice(5000); product2.setStock(500);
		product2.setProvider(savedProvider);
		ProductMTOOnly savedProduct2 = productRepository.save(product2);

		logger.info("test start ======================");
		logger.info(savedProvider.toString());
		logger.info(savedProduct.toString());
		logger.info(savedProduct2.toString());
		logger.info("test end =========================");
	} // test

} // class
