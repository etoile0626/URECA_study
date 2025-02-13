package ch16;
/*
 * 람다식(lambda expression)
 * - 자바에서 함수형 프로그래밍(functional programming)을 구현하는 방식
 * - 자바 8 부터 지원
 * - 클래스를 생성하지 않고 함수의 호출만으로 기능을 수행
 * 람다식 구현하기 (익명 함수 만들기)
 * - 매개  변수와 매개 변수를 활용한 실행문으로 구현
 * - 두 수를 입력 받아 더하는 add() 함수
 * - 함수 이름 반환 형을 없애고 -> 를 사용
 * - { } 까지 실행문을 의미
 */
@FunctionalInterface
interface SimpleLamda {
	public int add(int x, int y);
}
class SimpleLamdaChild implements SimpleLamda {
	@Override
	public int add(int x, int y) {
		return x + y;
	}
}
public class Lambda1OverView {

	public static void main(String[] args) {
		SimpleLamda func = (x, y)->{return x+y;};
		System.out.println(func.add(333, 444));

		SimpleLamdaChild c = new SimpleLamdaChild();
		System.out.println(c.add(333, 444));
	}

}
