package ch14;

class DataShare2 implements Runnable{
	int i = 0;
	@Override
	public synchronized void run() {		//동기화 메소드, 동시 접근 제한
		while(i<30) {
			System.out.println(i+" : "+Thread.currentThread().getName());
			i++;
		}
	}
	
}

public class RunnableShare2 {
	
	public static void main(String[] args) {			//변화되는 모습 관찰, 같은 객체 하나를 thread 3개에 태움
		DataShare2 ds = new DataShare2();
		Thread t1 = new Thread(ds, "1111111111");
		Thread t2 = new Thread(ds, "22222222222222");
		Thread t3 = new Thread(ds, "33333");
		t1.start();
		t2.start();
		t3.start();
	}
}
