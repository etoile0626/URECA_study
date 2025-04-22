package kr.co.ureca.dto;

public enum CommonResponse {
	
	SUCCESS(0, "Success"),
	FAIL(-1, "Fail");
	
	public int code;
	public String msg;
	
	CommonResponse(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
	
}
