package ch15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class collection2Iterator {

	public static void main(String[] args) {
		
		ArrayList<String> origin2 = new ArrayList<String>();
		origin2.add("Before First");
		origin2.add("First");
		origin2.add("Four");
		
		Iterator<String> iter1 = origin2.iterator();
		while (iter1.hasNext()) {			//현재 커서 위치의 다음위치에 데이터가 잇는가
			String str = (String) iter1.next();	//있으면 커서를 이동시키고 데이터를 가져와라
			System.out.println(str);			//가져와서 출력
		}
		
		//set도 위랑 비슷하게 사용
		Set<String> setOrigin = new HashSet<>();
		setOrigin.add("Before First");
		setOrigin.add("First");
		setOrigin.add("Four");
		setOrigin.add(new String("Four"));	//중복저장 안됨
		
		System.out.println("set toString: " + setOrigin.toString());
		Object objArr[] = setOrigin.toArray();
		for(int i =0; i<objArr.length;i++) {
			String str = (String) objArr[i];
			System.out.println(i+" : "+str);
		}
		
		//이터레이터 사용
		Iterator<String> iter2 = setOrigin.iterator();
		while(iter2.hasNext()) {
			String str = (String) iter2.next();	//있으면 커서를 이동시키고 데이터를 가져와라
			System.out.println(str);			//가져와서 출력
		}
		
	}

}
