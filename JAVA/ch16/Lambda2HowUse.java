package ch16;
/*
 * How Use Lamda?
 * 1.함수형 인터페이스 선언하기
 * 2.람다식 구현과 호출
 */
@FunctionalInterface
interface StrPrintLamda {
	public void print(String str);
}
public class Lambda2HowUse {
	public static void main(String[] args) {
		StrPrintLamda sp = (String str) -> {System.out.println(str);};
		sp.print("sp : StrPrintLamda");
		//매개변수가 하나인 경우, 자료형과 괄호 생략 가능.
		StrPrintLamda sp1 = str -> {System.out.println(str);};
		sp1.print("sp1 : StrPrintLamda");
		//중괄호 안의 구현부가 한 문장인 경우 중괄호 생략 가능.
		StrPrintLamda sp2 = str -> System.out.println(str);
		sp2.print("sp2 : StrPrintLamda");

		SimpleLamda func = (x, y)->{return x+y;};
		System.out.println(func.add(333, 444));
		//중괄호 안의 구현부가 반환문 하나라면 return과 중괄호 모두 생략 가능.
		SimpleLamda func2 = (x, y)-> x+y;
		System.out.println(func2.add(333, 444));
		//매개 변수가 두 개인 경우 괄호 생략 불가.
		//SimpleLamda func3 = x, y -> x+y;//error
	}

}
