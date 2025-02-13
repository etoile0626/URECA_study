package ch15;

import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		
		TreeMap<String, String> map1 = new TreeMap<>();
		map1.put("ddd","44444");
		map1.put("eee","55555");
		map1.put("AAA","66666");
		map1.put("aaa","11111");
		map1.put("zzz","77777");
		System.out.println(map1);
		
		TreeMap<TreeMapObj, TreeMapObjValue> map2 = new TreeMap<>();
		map2.put(new TreeMapObj(777), new TreeMapObjValue("hi"));
		map2.put(new TreeMapObj(999), new TreeMapObjValue("hello"));
		map2.put(new TreeMapObj(555), new TreeMapObjValue("how are you"));
		System.out.println(map2);	//정렬되서 나옴 => key쪽이 Comparable 구현되서
	}

}
