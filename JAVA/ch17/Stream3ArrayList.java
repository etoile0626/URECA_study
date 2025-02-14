package ch17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Stream3ArrayList {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("hi");
		list.add("hello");
		list.add("how are you");
		list.add("i am fine");
		list.add("thank you");
		
		Stream<String> stream = list.stream();

		stream.forEach(s->System.out.print(s + "\t"));
		System.out.println();
		
		list.stream().sorted().forEach(s->System.out.print(s+ "\t"));
		System.out.println();
		list.stream().map(s->s.length()).forEach(n->System.out.print(n+ "\t"));
		System.out.println();
		list.stream().map(s->s.length()).filter(n->n > 5).forEach(n->System.out.print(n+ "\t"));
		System.out.println();
		list.stream().filter(s->s.length() >= 5).forEach(s->System.out.print(s+ "\t"));

	}//main

}
