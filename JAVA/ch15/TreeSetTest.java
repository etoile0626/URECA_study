package ch15;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		// TreeSet의 잘못된 사용법
		TreeSet<Integer> tset2 = new TreeSet<>();
		tset2.add(333);
		tset2.add(222);
		tset2.add(111);
		tset2.add(555);
		tset2.add(444);
		System.out.println(tset2);	//자동으로 정렬이 되어서 나옴((Integer가 Comparable이 상속되어있어서?)

		TreeSet<TreeSetObj> tset1 = new TreeSet<>();		//예외가 나옴
		tset1.add(new TreeSetObj(222));				//에러가 뜨는 이유 ->TreeSetObj가 comparable이 상속되지 않아서
		tset1.add(new TreeSetObj(111));
		tset1.add(new TreeSetObj(333));
		System.out.println(tset1);

	}

}
