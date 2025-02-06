package ch05;

public class ArrayTest {

	public static void main(String[] args) {
		
		int[] iArr1;
		int iArr2 [];				//선언
		
		iArr1 = new int[3];			//초기화
		System.out.println(iArr1.length);		//length는 3, 인덱스는 0~2
		System.out.println(iArr1[0]);
		//System.out.println(iArr1[3]);	//ArrayIndexOutOfBoundsException
		
		int [] iArr3 = new int [3]; //선언후 초기화 
		
		int [] iArr4 = {999, 777, 888}; //생성과 동시에 값 대입 //이거 다 가능
		//iArr2 = {555, 777, 888};		//이건 안됨, 선언시에만 가능
		iArr2 = new int[] {555, 777, 888};	//이렇게 해야함
		
	}

}
