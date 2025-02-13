package ch16;

import java.util.Random;

/*
 * @FunctionalInterface : 함수형 인터페이스.
 * - 람다식을 선언하기 위한 인터페이스.
 * - 익명 함수와 매개 변수만으로 구현되므로 단 하나의 메서드만을 가져야 함 .
 * - 두 개 이상의 메서드인 경우 어떤 메서드의 호출인지 모호해 짐.
 * - 여러 개의 메서드를 선언하면 에러.
 */
@FunctionalInterface
interface FindLotto {
	int findLottoNum();
	//void printLottoNum();//error - 메소드는 하나만 선언해야 한다.
}
public class Lambda3Interface {
	public static void main(String[] args) {
		FindLotto fr = new FindLotto() {
			@Override
			public int findLottoNum() {
				Random rand = new Random();
				return rand.nextInt(45)+1;
			}
		};
		getInterface(1,fr);

		FindLotto fr2 = () -> {
			Random rand = new Random();
			return rand.nextInt(45)+1;
		};//함수 선언을 interface 타입의 변수에 담을 수 있다.
		getInterface(2,fr2);//interface 타입의 변수 전달.

		getInterface(3, new FindLotto() {
			@Override
			public int findLottoNum() {
				Random rand = new Random();
				return rand.nextInt(45)+1;
			}
		});//anonymous inner class.
	}//main
	public static void getInterface(int callNo, FindLotto lotto) {
		//interface 타입의 변수를 파라미터로 받을 수 있다.
		System.out.println(callNo+" : "+lotto.findLottoNum());
	}
}
