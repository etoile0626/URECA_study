package ch06;

public class Car1 {
	//생성자 없으면 자동추가됨
	Car1(String name){	//이렇게 생성자가 있으면 기본 생성자 안 만듦.
		System.out.println(name);
	}
	
	//default 생성자 만드는걸 습관화 하자!
	Car1(){}


}
