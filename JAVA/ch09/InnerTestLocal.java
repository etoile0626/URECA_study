package ch09;

public class InnerTestLocal {

	public void innreClassMethod() {		//메소드 안에 만든 클래스라 메소드가 끝나면 데이터가 지워짐
		class LocalInner{
			public String innerString = "Local Inner String";
			public void localInnerPrint() {
				System.out.println(innerString);
			}
		}
		LocalInner inner = new LocalInner();
		inner.innerString = "Inner String changed..";
		inner.localInnerPrint();
	}
	public static void main(String[] args) {
		InnerTestLocal local = new InnerTestLocal();
		local.innreClassMethod();

	}

}
