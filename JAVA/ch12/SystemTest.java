package ch12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SystemTest {

	public static void main(String[] args) {
		Map<String, String> envMap = System.getenv(); //getenv-시스템 클래스에 있던거
		Set<String> keys = envMap.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()) {
			String keyNm = iter.next();
			System.out.print(keyNm+" : ");
			System.out.println(envMap.get(keyNm));
		}
	}

}
