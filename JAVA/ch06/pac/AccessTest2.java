package ch06.pac;

import ch06.pac.test.DefaultClass;

public class AccessTest2 {

	public static void main(String[] args) {
		DefaultClass dc = new DefaultClass();
		//dc.className = "같은 폴더의 AccessTest에서 이름 변경";	//폴더가 달라서 오류 발생, default는 같은 패키지에서만 가능
		//dc.print();
	}

}
