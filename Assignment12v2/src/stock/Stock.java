package stock;

/*
 * Code from http://www.tutorialspoint.com/easymock/easymock_first_application.htm
 */

public class Stock {
	private String stockId;
	private String name;	
	private int quantity;

	public Stock(String stockId, String name, int quantity){
		this.stockId = stockId;
		this.name = name;		
		this.quantity = quantity;		
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getTicker() {
		return name;
	}
	
	public void addQuantity(int quantity){
		if (quantity < 0 )
			throw new IllegalArgumentException("Quantity must be greater than zero.");
		
		this.quantity += quantity;
	}
}
