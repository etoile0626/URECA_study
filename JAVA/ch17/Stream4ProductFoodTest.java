package ch17;

import java.util.ArrayList;
import java.util.List;

public class Stream4ProductFoodTest {

	public static void main(String[] args) {
		
		ProductFood food1 = new ProductFood("새우깡", 1000, 1500);
		ProductFood food2 = new ProductFood("신라면", 10000, 1000);
		ProductFood food3 = new ProductFood("사이다", 100, 2000);
		
		List<ProductFood> foodList = new ArrayList<>();
		foodList.add(food1);
		foodList.add(food2);
		foodList.add(food3);
		
		System.out.print("상품 : ");
		foodList.stream().map(c->c.getpName()).forEach(s->System.out.print(s+"\t"));
		System.out.println();
		System.out.println();

		int totalStock = foodList.stream().mapToInt(c->c.getStock()).sum();
		System.out.println("재고 량 :" + totalStock + "입니다");
		System.out.println();

		int totalAmt = foodList.stream().mapToInt(c->c.getPrice() * c.getStock()).sum();
		System.out.println("재고 금액 :" + totalAmt + "입니다");
		System.out.println();

		System.out.print("1000개 이상 재고 상품 : ");
		foodList.stream().filter(c->c.getStock() >= 1000).map(c->c.getpName()).sorted().forEach(s->System.out.print(s+"\t"));
	}
}
