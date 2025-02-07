package ch07;

public abstract class AbstractSuper {		//person	
	
	public final static int INT_W = 20;	//상수 선언가능
	String name;						//변수 선언 가능
	String ssn;
	
	public void name() {};				//일반메소드도 선언가능
	
	public abstract void print();	//구현은 자식객체에서 니들이 알아해라
}
