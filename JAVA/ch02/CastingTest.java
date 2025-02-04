package ch02;

/*datatype casting
 * -promotion(묵시적/자동적 형태변환) : 작은 데이터 타입 -> 큰 데이터 타입으로 옮길때
 * -demotion(명시적/강제적 형태변환) : 큰 데이터 타입 -> 작은 데이터 타입으로 옮길때
 */

public class CastingTest {

	public static void main(String[] args) {
		byte bVar = 127;
		int iVar = bVar;		//아무 문제 없음, promotion(묵시적/자동적 형변환)
		System.out.println("bVar : " + bVar);
		System.out.println("iVar : " + iVar);
		
		int iVar2 = 127;		
		iVar2 = 128;			//byte가 표현할 수 있는 범위를 넘어서면 형변환시 데이터가 흘러넘침(음수쪽으로 가버림, 오버플로우)
		iVar2 = 129;
		iVar2 = 130;
		byte bVar2 = (byte)iVar2;		//강제/명시적 형변환 (demotion)
		System.out.println("bVar2 : " + bVar2);
		System.out.println("iVar2 : " + iVar2);
		
		int iVar3 = 999999999;
		double dVar3 = iVar3;
		System.out.println("iVar3 : " + iVar3);
		System.out.println("dVar3 : " + dVar3);		//지수로 표현함
		
		double dVar4 = 9.123456789;
		int iVar4 = (int)dVar4;
		System.out.println("iVar4 : " + iVar4);		//소수점이 다 날라감
		System.out.println("dVar4 : " + dVar4);		
		
		char chVar = 'Z';
		System.out.println("chVar : " + chVar);
		System.out.println("(byte)chVar : " + (byte)chVar);
		
		int iVar5 = chVar;
		System.out.println("iVar5 : " + iVar5);
		
		char chVar2 = (char) iVar5;						//무슨 키를 눌렀는지 키 이벤트를 확인할때 많이 사용?
		System.out.println("chVar2 : " + chVar2);
		
		byte bVar6 = 7, bVar7 = 8;
		int iVar7 = bVar6 + bVar7;	//연산자를 만나면 int로 형변환이 됨
		byte bVar8 = (byte)(bVar6 + bVar7);	// 그래서 바이트에 담으려면 오류가 남(바이트끼리 더했는데 바이트에 못 더함=>결과에 캐스팅)
		
		
		float fVar1 = 99.9F, fVar2 = 3.14f;	//소수를 넣을때는 뒤에 소, 대문자 f를 넣어야함
		float fVar3 = fVar1 + fVar2;
		System.out.println("fVar3 : " + fVar3);

		long lVar = 999999L, lVar2 = 777777l; //long도 뒤에 l을 붙어줘야함
	}

}
