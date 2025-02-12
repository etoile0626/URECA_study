package ch14;

public class BreadBaker extends Thread{
	BreadShop shop;
	
	public BreadBaker(String threadName, BreadShop shop) {
		super(threadName);
		this.shop = shop;
	}
	
	@Override
	public void run() {
		while(true) {
			shop.setBread(1);
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
