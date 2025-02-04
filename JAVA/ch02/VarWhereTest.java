package ch02;

public class VarWhereTest {

	public static void main(String[] args) {
		
		int aVar = 7;
		{
			int bVar = 8;
			System.out.println("1st brace aVar : " + aVar);
			System.out.println("1st brace bVar : " + bVar);
		}
		System.out.println("main aVar : " + aVar);
		//System.out.println("bVar : " + bVar); // 여기선 bVar를 쓸 수 없음(중괄호 안에서 선언 되었기 때문)
		
		{
			int bVar = 888;
			System.out.println("2nd brace bVar : " + bVar);
		}
		
		int bVar = 111;
		System.out.println("main bVar : " + bVar);
		
	}

}
