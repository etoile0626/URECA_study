package ch07;

public class SmartPhone extends Phone {
	public SmartPhone(){
		System.out.println("SmartPhone 생성자");
	}
	
	//자식 생성자 선언
	public SmartPhone(String model, String color) {
		super(); //부모의 생성자 호출
		this.model = model;
		this.color = color;
		System.out.println("SmartPhone 생성자");
	}
}
