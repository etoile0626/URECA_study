package kr.co.ureca.s8jpamap.onetoone.only;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductDetailOTOOnlyTest {

	public static final Logger logger = LoggerFactory.getLogger(ProductDetailOTOOnlyTest.class);

	@Autowired
	private ProductOTOOnlyRepository productRepository;

	@Autowired
	private ProductDetailOTOOnlyRepository productDetailRepository;

	@Test
	void test() {
		ProductOTOOnly product = new ProductOTOOnly();
		product.setName("노래방 새우깡 대용량"); product.setPrice(5000); product.setStock(500);
		ProductOTOOnly savedProduct = productRepository.save(product);

		ProductDetailOTOOnly productDetail = new ProductDetailOTOOnly();
		productDetail.setDescription("노래방 사업자를 위한 대용량 새우깡");
		productDetail.setProduct(product);
		ProductDetailOTOOnly savedProductDetail = productDetailRepository.save(productDetail);

		ProductDetailOTOOnly productDetail2 = new ProductDetailOTOOnly();
		productDetail2.setDescription("@OneToOne의 option test");
		ProductDetailOTOOnly savedProductDetail2 = productDetailRepository.save(productDetail2);

		logger.info("test start ======================");
		logger.info(savedProduct.toString());
		logger.info(savedProductDetail.toString());
		logger.info(savedProductDetail2.toString());
		logger.info("test end =========================");
	} // test

} // class


