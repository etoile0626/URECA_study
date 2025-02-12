package ch14;

public class BreadCustomer extends Thread{

	BreadShop shop;
	
	public BreadCustomer(String threadName, BreadShop shop) {
		super(threadName);
		this.shop = shop;
	}
	
	@Override
	public void run() {
		while(true) {
			shop.buyBread();
		}
	}
}
