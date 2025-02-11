package ch11;

public class IdPwdException extends Exception {	//내가 만든 사용자 예외

	public IdPwdException() {}
	
	public IdPwdException(String message) {
		super(message);
	}
}
