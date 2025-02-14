package ch18;

import java.io.Serializable;

public class ObjectInOut implements Serializable{	//이거 선언해야만 Stream을 통해 입출력이 가능함
	
	public String name;
	public int age;
	
	public ObjectInOut(String name, int age) {
		this.name =name;
		this.age = age;
	}
	
	@Override
		public String toString() {
			return name + " : "+ age;
		}
}
