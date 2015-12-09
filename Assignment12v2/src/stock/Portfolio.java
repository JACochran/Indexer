package stock;

import java.util.List;

/*
 * Code from http://www.tutorialspoint.com/easymock/easymock_first_application.htm
 */

public class Portfolio {
	
	private StockService stockService;
	private List<Stock> stocks;
	private double accountBalance = 50000.00;

	public StockService getStockService() {
		return stockService;
	}
   
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public double getMarketValue(){
		double marketValue = 0.0;
      
		for(Stock stock:stocks){
			marketValue += stockService.getPrice(stock) * stock.getQuantity();
		}
		return marketValue;
   }
	
	public boolean buyAdditionalStock(double percent, Stock stock) {
		if (percent <= 0.0 || percent > 100.0 )
			throw new IllegalArgumentException ("Percent must be between 0 and 100");
		
		int volume = this.stockService.getVolume(stock);
		int quantity = (int) (volume * percent);
		double totalCost = quantity * stockService.getOpenPrice(stock);
		
		if (totalCost > accountBalance )
			return false;
		else{
			accountBalance -= totalCost;
			if (this.stocks.contains(stock)){
				int i = this.stocks.indexOf(stock);
				this.stocks.get(i).addQuantity(quantity);
			}
			else{
				this.stocks.add(new Stock(stock.getStockId(), stock.getTicker(), quantity));
			}
			
			return true;
		}	
	}

}
