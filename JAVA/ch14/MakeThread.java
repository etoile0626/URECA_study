package ch14;

class Thread1 extends Thread{						//상속받아 만드는 스레드
	public Thread1(String name) {
		super(name);
	}
	@Override
	public void run() {		//실제 스레드가 작업하는 코드
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread1 : " +i);
		}
	}
}

class Thread2 implements Runnable{					//Runnable 구현으로 만드는 스레드
	
	@Override
	public void run() {		//실제 스레드가 작업하는 코드
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread2 : " +i);
		}
	}
} 

public class MakeThread {

	public static void main(String[] args) {
		
			Thread1 t1 = new Thread1("first thread");		//상속받은애는 그냥 선언하면됨
			Thread2 t2 = new Thread2();
			Thread thread = new Thread(t2);	//Runnable인 애는 Thread 객체도 만들어 넣어줘야 실행 가능!
			thread.setName("second thread");		//스레드 이름 설정
			System.out.println("t1 name: "+t1.getName());
			System.out.println("thread name: "+thread.getName());
			
			System.out.println("t1 State: "+t1.getState());
			
			t1.start();
			thread.start();
			
			System.out.println("t1 State: "+t1.getState());
			try {
				Thread.sleep(1000); //메인 스레드를 재움
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			System.out.println("t1 State: "+t1.getState());
			//System.out.println("thread State: "+thread.getState());
	}

}
