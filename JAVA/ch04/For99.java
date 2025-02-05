package ch04;

public class For99 {

	public static void main(String[] args) {
		
		for(int dan = 2; dan <= 9; dan++) {
			System.out.println(dan + "단 ==================");
			for(int gop =1; gop <=9; gop++) {
				System.out.printf("%d * %d = %d\t", dan, gop, dan*gop);
				if(gop % 3 == 0) {
					System.out.println();
				}
			}
			System.out.println();
		}
		
		int dan =2;
		while(dan<=9) {
			System.out.println(dan + "단!!!!!!!!!!!!");
			
			int gop =1;
			while(gop <=9) {
				System.out.printf("%d * %d = %d\t", dan, gop, dan*gop);
				if(gop % 3 == 0) {
					System.out.println();
				}
				gop++;
			}
			System.out.println();
			
			dan++;
		}

	}

}
