package ch11;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptChild extends ExceptSuper{
	
//	@Override	//throws를 제거해도 override 가능
//	public void name() {}

	@Override	//부모와 동일하게 Exception override 가능
	public void name() throws IOException {}
	
//	@Override	//부모보다 Exception이 자식레벨이면 Exception override 가능
//	public void name() throws FileNotFoundException {}
	
//	@Override	//다만 이렇게 부모보다 Exception이 부모레벨의 Exception override 불가
//	public void name() throws Exception {}	//에러

}
