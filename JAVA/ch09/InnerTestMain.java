package ch09;

public class InnerTestMain {

	public static void main(String[] args) {
		
		InnerTest1 t1 = new InnerTest1();
		//instance nested class
		InnerTest1.InnerA iA = t1.new InnerA();		//이렇게 선언해야 이너클래스에 접근가능, 기억해두기
		iA.innerAPrint();
		
		//static nested class
		InnerTest1.InnerE.innerEPrint();

	}

}
