package ch17;

public class ProductFood {

	private String pName;
	private int stock;
	private int price;
	public ProductFood(String productName, int expirationDate, int price) {
		this.pName = productName;
		this.stock = expirationDate;
		this.price = price;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String toString() {
		return "pName : " + pName + "stock : " + stock + "price : " + price; 
	}

}
