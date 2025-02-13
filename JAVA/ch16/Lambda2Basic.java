package ch16;

@FunctionalInterface
interface IFParent2 {//반드시 @FunctionalInterface
	//반드시 메소드가 1개만
	public int add(int a, int b);
//	public int minus(int a, int b);
}
public class Lambda2Basic {
	public static void main(String[] args) {
		IFParent2 var = (a, b)->{return a+b;};
		System.out.println(var.add(111, 222));
		IFParent2 var2 = (a, b)->{return a*b;};
		System.out.println(var2.add(111, 222));
	}//main
}//class
