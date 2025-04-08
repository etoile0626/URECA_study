package kr.co.ureca.s10exception;

public class IDNotFoundException extends Exception{
	
	public IDNotFoundException() {
		super("ID를 찾을 수 없습니다.");
	}
	
	public IDNotFoundException(String id) {
		super("입력하신 아이디 ["+id+"]를 찾을 수 없습니다.");
	}
	
	public IDNotFoundException(String message, String id) {
		super(id + " : " + message);
	}
}
