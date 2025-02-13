package ch15;

import java.util.ArrayList;

public class Collection1List {

	public static void main(String[] args) {
		
		ArrayList origin1 = new ArrayList();	//이 안에 담긴 내용이 알 수가 없어 경고가 뜸
		origin1.add(777);
		origin1.add(3.14);
		origin1.add("Three");
		
		ArrayList clone1 = (ArrayList) origin1.clone();		//clone(): 리스트 복사해오기, Object 타입으로 반환되서 캐스팅해줘야함
		ArrayList clone2 = (ArrayList) origin1.clone();
		ArrayList clone3 = (ArrayList) origin1.clone();
		
		System.out.println("origin1: "+origin1.toString());
		System.out.println("clone1: "+clone1.toString());				//둘 다 같음
		System.out.println("clone2: "+clone2.toString());
		System.out.println("clone3: "+clone3.toString());
		System.out.println("origin1.size(): "+origin1.size());
		System.out.println("origin1.indexOf(\"three\"): "+clone1.indexOf("Three"));
		
		Object objArr[] = origin1.toArray();
		for(int i = 0; i<objArr.length; i++) {
			System.out.println(i + " : "+objArr[i]);
		}
		
		clone1.clear();	//clone1 내용 전체제거
		System.out.println("clear after clone1.toString(): "+clone1.toString());
		
		clone2.remove(0);
		clone2.remove("Three");
		System.out.println("remove after clone2.toString(): "+clone2.toString());
		
		clone2.add("Four");
		clone2.add(0, "Before First");
		clone2.add(1, "First");
		System.out.println("add after clone2.toString(): "+clone2.toString());
		System.out.println("clone2.contains(3.14): " +clone2.contains(3.14));
		
		for(Object obj: clone2) {
			System.out.println(obj);
		}
		
		ArrayList<String> origin2 = new ArrayList<String>();
		origin2.add("Before First");
		origin2.add("First");
		origin2.add("Four");
		for(String obj: origin2) {
			System.out.println(obj);
		}
		
		for(int i= 0; i<origin2.size(); i++) {
			System.out.println(origin2.get(i));	//get메소드 사용
		}
	}

}
