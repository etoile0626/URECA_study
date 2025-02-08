package a0207;

import java.util.Stack;

public class StacPopPeekSize {

	public static void main(String[] args) {
		
		Stack<String> strStack = new Stack<>();
		strStack.push("hi");
		strStack.push("hello");
		strStack.push("how are you");
		strStack.push("if");
		strStack.push("ty");
		
		System.out.println("Size : "+strStack.size());
		System.out.println("Pop : "+strStack.pop());
		System.out.println("Peek : "+strStack.peek());
	}

}
