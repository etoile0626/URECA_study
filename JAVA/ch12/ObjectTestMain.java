package ch12;

public class ObjectTestMain {

	public static void main(String[] args) {
		
		ObjectTest ot1 = new ObjectTest();
		System.out.println(ot1.hashCode());
		System.out.println(ot1.toString());
		
		ObjectTest ot2 = new ObjectTest("yoon", "2000");
		System.out.println(ot2.toString());
		
		ObjectTest ot3 = new ObjectTest("yoon", "2000");
		System.out.println(ot2.equals(ot3));		//false, 단순 해시코드만 검색해서 ->오버라이드하기 ->true
		
		ObjectTest ot4 = new ObjectTest("yoon", "2120");
		System.out.println(ot2.equals(ot4));
	}

}
