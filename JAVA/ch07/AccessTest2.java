package ch07;

import ch07.pac.ProtectedClass;

public class AccessTest2 {
	public static void main(String[] args) {
		ProtectedClass pro = new ProtectedClass();
		//System.out.println(pro.proStr);	//다른 패키지라 오류남
		//pro.print();
	}
}
