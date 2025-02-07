package ch07;

public class AbstractTest {

	public static void main(String[] args) {
		
		AbstractChild1 ch1 = new AbstractChild1();
		AbstractChild2 ch2 = new AbstractChild2();
		
		AbstractTest test = new AbstractTest();
		test.name(ch1);
		test.name(ch2);
	}
	
	private void name(AbstractSuper su) {
		su.print();							//추상클래스로 부모에게 선언해두지않으면 이게 안됨, 의사 클래스 따로 환자 클래스 따로 구분해서 메소드를 정의해야 굴러감
	}
	/*
	private void name(AbstractSuper su) {
		if(su instanceof AbstractChild1) {
			AbstractChild1 ch1 = (AbstractChild1) su;
			ch1.Print();
		}
	}*/
	
}
