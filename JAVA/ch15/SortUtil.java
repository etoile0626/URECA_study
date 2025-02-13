package ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortUtil {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(777);list1.add(999);list1.add(555);
		System.out.println(list1);
		Collections.sort(list1);		//정렬도 가능함
		System.out.println(list1);

		int iArr[] = {5,9,7,3};
		for(int i : iArr) {
			System.out.println(i);
		}
		Arrays.sort(iArr);	
		//System.out.println(iArr);	//이렇게 하면 출력ㅇ 안됨
		for(int i : iArr) {
			System.out.println("sort: "+i);
		}
	}

}
