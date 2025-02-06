package ch06.pac.test;

public class AccessTest {

	public static void main(String[] args) {
		
		DefaultClass dc = new DefaultClass();
		dc.className = "같은 폴더의 AccessTest에서 이름 변경";
		dc.print();
		
		PrivateTest pt = new PrivateTest();
		//pt.age = -10; //error
		pt.setAge(-10);
	}

}
