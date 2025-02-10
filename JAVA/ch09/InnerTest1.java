package ch09;

public class InnerTest1 {
	
	public class InnerA{		//이너(instance nested class)클래스는 private, proteced도 가능함!
		String s = "AString";
		InnerA(){
			System.out.println("A 생성자");
		}
		public void innerAPrint() {
			System.out.println(s);
		}
	}
	private class InnerB{		//이너(인스턴스 멤버)클래스는 private, proteced도 가능함!
		
	}
	class InnerC{}
	
	protected class InnerD{		//이너(인스턴스 멤버)클래스는 private, proteced도 가능함!
		
	}
	
	public static class InnerE{		//static nested class(정적 멤버 클래스)
		//생성자가 따로필요가 없네
		public static void innerEPrint() {	//메소드도 static으로
			System.out.println("StaticE");
		}
	}
	
	class InnerF extends InnerC{
	
	}
	public interface InnerInfA{}
	protected interface InnerInfB{}
	interface InnerInfC{}
	private interface InnerInfD{}
	interface InnerInfE extends InnerInfA, InnerInfC{}
	
}
