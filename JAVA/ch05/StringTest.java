package ch05;

public class StringTest {

	public static void main(String[] args) {
		
		String originStr = new String("hi hello how are you nice to meet you");
		System.out.println(originStr);
		//System.out.println(originStr.replace("i", "A"));
		//System.out.println(originStr.replace("you", "U~~"));	
		//System.out.println(originStr.replaceAll("o", "O"));	//해당하는 애 전부 바꿈, 근데 replace도 전부 바꿀 수 있음
		//System.out.println(originStr.replaceFirst("o", "O"));	//처음에 나오는애만 바꿈
		
		//System.out.println("Answer : " + originStr.concat(originStr)); //+와 같은 역할 : concat
		//System.out.println(originStr.substring(9));		//9번 인덱스부터 출력
		//System.out.println(originStr.substring(3, 7)); //앞에 넣은 인덱스까지 포함, 뒤에 넣은 인덱스부터 미포함
		//System.out.println(originStr);//원본인 originStr에 영향을 주지 않음

		//문자열 찾기
		//System.out.println(originStr.indexOf("are"));
		//System.out.println(originStr.indexOf("are", 15));
		//System.out.println(originStr.indexOf('i', 5, 15));
		//System.out.println(originStr.lastIndexOf('o'));
	
		//split-문자열 자르기
		String[] arrs = originStr.split(" ");
		for (int i = 0; i < arrs.length; i++) {
			System.out.println(arrs[i]);
		}
		System.out.println(originStr);//원본인 originStr에 영향을 주지 않음
	}

}
