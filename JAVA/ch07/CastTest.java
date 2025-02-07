package ch07;

public class CastTest {
	public static void main(String[] args) {
		
		CastSuper su = new CastChild(); //자동형변환, 다형성 기초
		su.printSuper();
		
		CastChild ch = (CastChild) su; //강제형변환
		ch.printChild(); 			 //강제형변환하면서 자식거 사용가능해짐
		
		//이형의 데이터를 담는 배열: heterogeneous collection //ex) list, set, map
		CastSuper[] suArr = new CastSuper[4];	//헤테로 지니어스 컬렉션
		suArr[0] = new CastChild();
		suArr[1] = new CastChild2();
		
		Object[] oArr = new Object[4];	//자바의 모든 클래스는 Object 를 상속받음 ->다형성과관련있음
		oArr[0] = new CastChild();
		oArr[1] = new CastChild2();
		oArr[2] = new Phone();
		oArr[3] = new SmartPhone();
		
		CastTest ct = new CastTest();
		ct.print(suArr[0]);
		ct.print(suArr[1]);
		
	}
	
	public void print(CastSuper su) {	//super 타입으로 매개변수를 넣으면 자식 타입도 다 들어갈수있다.
		su.printSuper();
		if(su instanceof CastChild) {		//좌항의 객체가 우항의 타입이면 참
			CastChild ch = (CastChild) su;
			ch.printChild();
		}
		else if (su instanceof CastChild2) {
			CastChild2 ch = (CastChild2) su;
			ch.printChild2();
		}
	}
}
