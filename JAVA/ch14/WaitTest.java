package ch14;


class WaitThread implements Runnable{
	int i = 0;
	@Override
	public synchronized void run() {
		while(i<30) {
			System.out.println(i+ " :  "+Thread.currentThread().getName());
			i++;
			notify();						//깨워주기
			try {
				this.wait();				//잠들기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

public class WaitTest {

	public static void main(String[] args) {
		WaitThread wt = new WaitThread();
		Thread t1 = new Thread(wt, "11111111");
		Thread t2 = new Thread(wt, "22222");
		Thread t3 = new Thread(wt, "333");
		t1.start();					
		t2.start();
		t3.start();							//각 스레드가 한 번 출력하고 wait 상태에 들어감(계속 실행중임)
	}

}
