package ch12;

public class ObjectTest {

	String name;
	String birthYear;
	
	ObjectTest(){
		
	}
	ObjectTest(String nm, String year){
		this.name = nm;
		this.birthYear = year;
	}
	
	@Override
	public String toString() {
		return this.name+" : "+this.birthYear+"\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		ObjectTest ot = (ObjectTest)obj;
		if(ot.name.equals(name) && ot.birthYear.equals(birthYear)){
			return true;
		}
		return false;
	}
}
