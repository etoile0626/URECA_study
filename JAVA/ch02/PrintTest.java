package ch02;

public class PrintTest {

	public static void main(String[] args) {
		
		System.out.print("Hi\t");
		System.out.print("Hello\n");
		System.out.print("HowAreYou");
		System.out.println("");
		System.out.printf("%s이 %s에게 %d만원을 년이자 %f에 빌렸다.\n", "홍길동", "국민은행", 200, 3.14);
		
		System.out.printf("%6d\n", 200); //총 6자리를 표현하는데 앞에 남은 자리를 비워라
		System.out.printf("%-6d\n", 200); //총 6자리를 표현하는데 뒤에 남은 자리를 비워라
		System.out.printf("%06d", 200); //6자리를 표현하는데 빈자리는 0으로 채워라
		
		System.out.printf("%s이 %s에게 %d만원을 년이자 %10.3f에 빌렸다.\n", "홍길동", "국민은행", 200, 3.14);
		//10.3f = 전체 자리수 10자리(소수점 포함, 소수점 아래는 3자리 표현)
	}

}
