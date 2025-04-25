package kr.co.ureca.s10exception;

public class IDNotFoundException extends Exception {

	public IDNotFoundException() {
		super("입력하신 아이디를 찾을 수 없습니다. 확인 후 다시 시도해 주세요.");
	}

	public IDNotFoundException(String id) {
		super("입력하신 아이디 [" + id + "]를 찾을 수 없습니다. 확인 후 다시 시도해 주세요.");
	}

	public IDNotFoundException(String message, String id) {
		super(id + " : " + message);
	}

} // class
