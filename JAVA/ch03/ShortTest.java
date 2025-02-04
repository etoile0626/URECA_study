package ch03;

public class ShortTest {

	public static void main(String[] args) {
		
		//비교연산자가 하나만 있는 경우는 앞과 뒤의 로직을 모두 검사함
		if (1 < 2 | 0 < 2) System.out.println("| True");
		
		//if (1 < 2 | (5/0) < 2 ) System.out.println("True");	//ArithmeticException
		
		//숏서킷 로직: || 왼쪽의 로직이 참이면, 오른쪽의 로직을 검사하지 않음(앞에 참이 있으니까 뒤까지 볼 필요가 없다!)
		if (1 < 2 || (5/0) < 2) System.out.println("|| True");	//근데 이건 된다?
		
		//숏서킷 로직: && 왼쪽의 로직이 거짓이면, 오른쪽의 로직을 검사하지 않음(앞에 거짓이 있으니까 뒤까지 볼 필요가 없다!)
		if (1 > 2 && (5/0) < 2) System.out.println("&& False");	

	}

}
