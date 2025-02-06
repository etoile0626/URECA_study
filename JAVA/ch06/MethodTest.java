package ch06;

public class MethodTest {

	//접근제한자 리턴타입 메소드명(파라미터들){실행코드}의 형태
	//리턴타입 : 이 메소드를 호출하면 가져가는 데이터의 형태, 실행결과 데이터의 형태.
	//(파라미터들): 이 메소드를 싱핼하려면 가져와야 하는 데이터의 형태와 갯수
	public void name() {
	
	}
		
	public int plus(int iVar1, int iVar2) {	//얘는 객체가 아님, MethodTest 클래스 안에 있는 메소드임. 객체를 선언해야 사용할 수 있음
		
		return iVar1+iVar2;
		//System.out.println();		//도달하지 않는 코드
	}
	public static void main(String[] args) {
		MethodTest mt = new MethodTest();
		int result = mt.plus(7, 8);
		System.out.println(result);
	}
}
