package ch07.pac;

public class AccessTest {
	public static void main(String[] args) {
		ProtectedClass pro = new ProtectedClass();
		System.out.println(pro.proStr);
		pro.print();
	}
}
