package ch08;

public class RemoteControlExample {

	public static void main(String[] args) {
		//인터페이스를 사용한 polymorphism(상속관계?)을 구현 가능!	//audio를 타고 갔더니 리모트 컨트롤이 나오고 텔레비전을 타고 가니 텔레비전이 나오더라
		RemoteControl [] rcArr = new RemoteControl[2];
		rcArr[0] = new Audio();
		rcArr[1] = new Television();

	}

}
