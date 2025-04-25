package kr.co.ureca.s8jpamap.onetoone.both;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductOTOBothRepositoryTest {

	public static final Logger logger = LoggerFactory.getLogger(ProductOTOBothRepositoryTest.class);

	@Autowired
	private ProductOTOBothRepository productRepository;

	@Autowired
	private ProductDetailOTOBothRepository productDetailRepository;

	@Test
	void test() {
		ProductOTOBoth product = new ProductOTOBoth();
		product.setName("노래방 새우깡 대용량"); product.setPrice(5000); product.setStock(500);
		ProductOTOBoth savedProduct = productRepository.save(product);

		ProductDetailOTOBoth productDetail = new ProductDetailOTOBoth();
		productDetail.setDescription("노래방 사업자를 위한 대용량 새우깡");
		productDetail.setProduct(product);
		ProductDetailOTOBoth savedProductDetail = productDetailRepository.save(productDetail);

		savedProduct.setProductDetail(savedProductDetail);
		productRepository.save(savedProduct);

		logger.info("test start ======================");
		logger.info(savedProduct.toString());
		logger.info(savedProduct.getProductDetail().toString());
		logger.info(savedProductDetail.toString());
		logger.info("test end =========================");
	} // test

} // class
