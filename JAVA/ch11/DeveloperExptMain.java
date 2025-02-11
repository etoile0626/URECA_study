package ch11;

public class DeveloperExptMain {

	public static void main(String[] args) {
		
		String id = args[0];
		String pwd = args[1];
		
		CheckIdPwd chk = new CheckIdPwd();
		try {
			System.out.println(chk.checkId(id));
			System.out.println(chk.checkId(pwd));
		}catch (IdPwdException e){
			System.out.println(e.getMessage());
		}
	}

}
