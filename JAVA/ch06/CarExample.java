package ch06;

public class CarExample {

	public static void main(String[] args) {
		//Car car = new Car("소나타");
		Car car = new Car("소나타", "검은색");
		//Car car = new Car("소나타", "하얀색", 300);
		System.out.println("Model : "+car.model);
		System.out.println("color : "+car.color);
		System.out.println("maxSpeed : "+car.maxSpeed);

	}

}
