package ch04;

public class Stars {

	public static void main(String[] args) {
		//강사님풀이
		for(int i =0; i<5; i++) {
			for(int j =5; j>0; j--) {		//공백찍기
				if(i == j) break;
				System.out.print(" ");
			}
			for(int j =0; j<10; j++) {		//별찍기
				System.out.print("*");
				if(j/2 == i) break;
			}
			System.out.println();
		}
		System.out.println("=============");
		for(int i =0; i<5; i++) {
			for(int j = 0; j<5; j++) {		//공백찍기
				if(i == j) break;
				System.out.print(" ");
			}
			for(int j =9; j>=0; j--) {		//별찍기
				System.out.print("*");
				if(j/2 == i) break;
			}
			System.out.println();
		}
	}
}
