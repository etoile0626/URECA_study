package ch11;

public class CallerMain {

	public static void main(String[] args) {
		ExceptThrow et = new ExceptThrow();

		try {
			et.makeException();	
		}catch(Exception e){
			System.out.println("예외처리 완료");
		}
	}
}
