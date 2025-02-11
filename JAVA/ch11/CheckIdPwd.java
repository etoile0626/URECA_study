package ch11;

public class CheckIdPwd {

	private String id = "super";
	private String pwd = "fly";
	public String checkId(String id) throws IdPwdException{
		if(this.id.equalsIgnoreCase(id)) {
			return "ok";
		}else throw new IdPwdException("ID가 올바르지 않습니다");
	}
	
	public String checkPwd(String pwd) throws IdPwdException{
		if(this.id.equalsIgnoreCase(pwd)) {
			return "ok";
		}else throw new IdPwdException("pwd가 올바르지 않습니다");
	}
	
}
