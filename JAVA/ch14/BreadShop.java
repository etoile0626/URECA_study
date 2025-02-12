package ch14;

public class BreadShop {
	
	private int breadNo = 0; //빵갯수, 0이면 setBread 수행, 0보다 크면 buyBread 수행
	
	public synchronized void setBread(int breadNoByBaker) {	//baker 수행
		if(breadNo != 0) {
			System.out.println("빵 있음. 제빵사는 휴식. : " +Thread.currentThread().getName());
			try {
				this.wait();	//baker wait()
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			breadNo = breadNoByBaker;
			System.out.println("빵 들어왔다고 알림. : " +Thread.currentThread().getName());
			notifyAll();			//baker notify()
		}
	}
	public synchronized void buyBread() {		//customer 수행
		if(breadNo == 0) {					
			System.out.println("빵이 없음. 빵을 사려고 줄을 선다. : "+Thread.currentThread().getName());
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 		//customer wait
		}else {
			breadNo = 0;
			System.out.println("빵을 샀어요. : " +Thread.currentThread().getName());
			notifyAll();		//customer notify()
			
		}
	}
	
	public static void main(String[] args) {
		BreadShop shop = new BreadShop();
		
		BreadBaker baker = new BreadBaker("파리바게", shop);
		
		BreadCustomer customer = new BreadCustomer("손님", shop);
		
		baker.start();
		customer.start();
	}
}
