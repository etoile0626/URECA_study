package ch03;

public class OperTest {

	public static void main(String[] args) {
		
		int a = 7, b = 7, c = 0, d = 0;
		c = a++;		//c에 대입 후 a값 상승
		d = ++b;		//b값 상승 후 d에 대입
		System.out.printf("a : %d, b : %d, c : %d, d : %d\n", a, b, c, d);
		//a : 8, b : 8, c : 7, d : 8

		a = 7; b = 7; c = 0; d = 0;
		c = a--;		//c에 대입 후 a값 감소
		d = --b;		//b값 감소 후 d에 대입
		System.out.printf("a : %d, b : %d, c : %d, d : %d\n", a, b, c, d);
		//a : 6, b : 6, c : 7, d : 6
		
		a = 7; b = 7; c = 0; d = 0;
		c = a++ * 3;		//후치연산, ++이 가장 마지막에 수행.
		d = ++b * 3;		//전치연산, ++이 가장 먼저 수행.
		System.out.printf("a : %d, b : %d, c : %d, d : %d\n", a, b, c, d);
		//a : 8, b : 8, c : 21, d : 24
		
		a = 123; b = 4;
		System.out.println("123 / 4 : " + a / b);	//정수형 나눗셈이라 정수로떨어짐
		System.out.println("123 % 4 : " + a % b);	//나머지연산, 짝수, 배수, 홀수 등등 구할때 사용, 기억해두기
		
		//overflow
		byte byteVar1 = (byte) 128;
		//byteVar1 = (byte) 129;
		//byteVar1 = (byte) 130;
		//byteVar1 = (byte) 131;
		//byteVar1 = (byte) 132;
		byteVar1 = (byte) -129;	//underflow
		System.out.println("byteVar1 : " + byteVar1);
		
		float fVar = 1.23456789f;
		System.out.println(fVar); 	//1.2345679 -> float는 소수6째까지만 유효 ->7번째부터 유효 x
		
		double dVar1 = 5 / 0.0;
		if (Double.isInfinite(dVar1)) {
			System.out.println("Infinite");
		}else {
			System.out.println("dVar1 : " + dVar1);
		}
		
		double dVar2 = 5 % 0.0;
		if (Double.isInfinite(dVar1)) {
			System.out.println("NaN");
		}else {
			System.out.println("dVar2 : " + dVar2);
		}
	}

}
