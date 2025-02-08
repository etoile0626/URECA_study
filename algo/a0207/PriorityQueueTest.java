package a0207;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	static class Object1{
		int no, score;
		
		public Object1(int no, int score){
			this.no = no;
			this.score = score;
		}
		@Override
		public String toString() {
			return "Object1 [no="+no+", score="+score+"]";
		}
	}
	
	static class Object2 implements Comparable<Object2>{
		int no, score;
		
		public Object2(int no, int score){
			super();
			this.no = no;
			this.score = score;
		}
		
		@Override
		public int compareTo(Object2 o) {
			return this.score - o.score;	//비교값 설정(점수 비교), 오름차순
		}
		
		@Override
		public String toString() {
			return "Object2 [no="+no+", score="+score+"]";
		}
	}
	
	public static void main(String[] args) {
		//Comparable을 구현하지 않은 객체를 우선순위큐로 이렇게 만들면 에러다
		PriorityQueue<Object1> p1 = new PriorityQueue<>();
		/*
		p1.offer(new Object1(1, 95));
		p1.offer(new Object1(2, 77));
		p1.offer(new Object1(3, 84));
		System.out.println(p1); 	//error
		*/
		
		//Comparable을 구현한 객체를 우선순위큐로 만들때
		PriorityQueue<Object2> p2 = new PriorityQueue<Object2>();//내부에 들어가는 컬렉션은 Comparable을 구현해야함
		p2.offer(new Object2(1, 95));
		p2.offer(new Object2(2, 77));
		p2.offer(new Object2(3, 84));
		System.out.println(p2.poll());	//poll로 확인해야함
		System.out.println(p2.poll());
		System.out.println(p2.poll());
		
		//Comparable을 구현하지 않은 클래스로 우선순위 큐를 만들기 => Comparator를 만들어 정렬기준을 만들어준다
		PriorityQueue<Object1> p3 = new PriorityQueue<Object1>(new Comparator<Object1>() {
			@Override
			public int compare(Object1 o1, Object1 o2) {
				return o2.score-o1.score;		//내림차순
			}
		});
		p3.offer(new Object1(1, 95));
		p3.offer(new Object1(2, 77));
		p3.offer(new Object1(3, 84));
		System.out.println(p3.poll());
		System.out.println(p3.poll());
		System.out.println(p3.poll());

	}

}
