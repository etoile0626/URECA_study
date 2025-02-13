package ch15;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class collection3Map {

	public static void main(String[] args) {
		Map<Integer, String> mapOrigin = new HashMap<>();
		mapOrigin.put(1, "hi");
		mapOrigin.put(2, "hello");
		mapOrigin.put(3, "how are you");
		mapOrigin.put(4, "i am fine");
		mapOrigin.put(5, "thank you");

		System.out.println("size: "+mapOrigin.size());
		System.out.println(mapOrigin.toString());	//toString으로 뽑으면 중괄호로 나오고 그냥 mapOrigin으로 뽑으면 대괄호로 나옴
		
		Set<Integer> set1 = mapOrigin.keySet();
		System.out.println("key: "+set1);//키만 출력, 키 값을 모를때 키를 뽑아냄->근데 set이라 이터레이터 필요
		
		Iterator iter1 = set1.iterator();
		while(iter1.hasNext()) {
			Object key = iter1.next();
			System.out.println(key+" : "+mapOrigin.get(key));	//key값을 통해 value를 끄집어 냄
		}
		
		Collection<String> col1 = mapOrigin.values();	//값만 출력
		System.out.println("values: "+col1);
	}

}
