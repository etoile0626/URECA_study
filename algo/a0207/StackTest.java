package a0207;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {

		String str = "6528-*2/+";
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i< str.length(); i++) {
			char tmp = str.charAt(i);
			if(Character.isDigit(tmp)) {	//숫자면
				stack.push(tmp - '0');			//- '0' 처리로 숫자로 바꿈
				System.out.println(stack);
			}else {							//기호면
				int iVar1 = stack.pop();
				int iVar2 = stack.pop();
				
				switch(tmp) {
				case '+': 
					stack.push(iVar1 + iVar2);
					System.out.println(stack);
					break;
				case '-': 
					stack.push(iVar1 - iVar2);
					System.out.println(stack);
					break;
				case '*': 
					stack.push(iVar1 * iVar2);
					System.out.println(stack);
					break;
				case '/': 
					stack.push(iVar1 / iVar2);
					System.out.println(stack);
					break;
				}
			}
		}
	}

}
