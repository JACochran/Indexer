package stock;

/*
 * Original code from http://www.tutorialspoint.com/easymock/easymock_first_application.htm
 * and modified for the purposes of this assignment
 */

public interface StockService {
	public double getPrice(Stock stock);
	
	public int getVolume(Stock stock);
	
	public double getOpenPrice(Stock stock);
	
	public double getYearlyHigh(Stock stock);
	
	public double getClosingPrice(Stock stock);
	
	public double getYield(Stock stock);
}