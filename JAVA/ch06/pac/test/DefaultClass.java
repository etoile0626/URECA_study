package ch06.pac.test;

//접근제한자 없음: default, 같은 폴더의 class만 접근가능
public class DefaultClass {
	String defaultStr = "DefaultClass의 defaultStr";
	
	String className = "DefaultClass의 defaultStr";
	
	void print() {
		System.out.println(className);
	}
}
