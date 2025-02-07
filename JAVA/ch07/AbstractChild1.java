package ch07;

public class AbstractChild1 extends AbstractSuper{	//의사

	String job;
	
	public void empPrint() {
		System.out.println(name+ssn+job);
	}
	
	public void print() {
		System.out.println(name+ssn+job);
	}
}
