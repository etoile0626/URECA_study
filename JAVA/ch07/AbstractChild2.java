package ch07;

public class AbstractChild2 extends AbstractSuper{	//환자
	
	String patientNo;
	
	public void empPrint() {
		System.out.println(name+ssn+patientNo);
	}
	
	public void print() {
		System.out.println(name+ssn+patientNo);
	}

}
