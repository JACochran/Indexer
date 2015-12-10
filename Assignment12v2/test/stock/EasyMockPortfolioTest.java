package stock;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class EasyMockPortfolioTest {
	private static final double EPSILON = 0.001;
	Portfolio portfolio;
	StockService stockService;

	@Before
	public void setUp() throws Exception {
		// Create a portfolio object which is to be tested
		portfolio = new Portfolio();

		// Create the mock object of stock service
		stockService = EasyMock.createMock(StockService.class);

		// set the stockService to the portfolio
		portfolio.setStockService(stockService);
	}

	@Test
	public void exampleTest() {
		// Creates a list of stocks to be added to the portfolio
		List<Stock> stocks = new ArrayList<Stock>();
		Stock googleStock = new Stock("1", "Google", 10);
		Stock microsoftStock = new Stock("2", "Microsoft", 100);

		stocks.add(googleStock);
		stocks.add(microsoftStock);

		// add stocks to the portfolio
		portfolio.setStocks(stocks);

		// mock the behavior of stock service to return the value of various
		// stocks
		EasyMock.expect(stockService.getPrice(googleStock)).andReturn(50.00);
		EasyMock.expect(stockService.getPrice(microsoftStock)).andReturn(1000.00);

		// activate the mock
		EasyMock.replay(stockService);

		double marketValue = portfolio.getMarketValue();
		assertTrue(marketValue == 100500.0);
	}

	@Test
	public void getMoreStocks() {
		// Creates a list of stocks to be added to the portfolio
		List<Stock> stocks = new ArrayList<Stock>();
		Stock googleStock = new Stock("1", "Google", 10);
		Stock microsoftStock = new Stock("2", "Microsoft", 100);

		stocks.add(googleStock);
		// add stocks to portfolio (exclude microsoft)
		portfolio.setStocks(stocks);
		// set up return values
		EasyMock.expect(stockService.getPrice(googleStock)).andReturn(35.00).times(1);
		EasyMock.expect(stockService.getPrice(microsoftStock)).andReturn(57.0).times(2);

		EasyMock.expect(stockService.getVolume(googleStock)).andReturn(100).times(1);
		EasyMock.expect(stockService.getVolume(microsoftStock)).andReturn(900).times(2);
		// activate!
		EasyMock.replay(stockService);
		// buy the stock, and ensure it returns true
		assertTrue(portfolio.buyAdditionalStock(0.01, microsoftStock));
		assertTrue(portfolio.buyAdditionalStock(0.07, googleStock));
		// buy more than you have money for! should be unsuccessful
		assertFalse(portfolio.buyAdditionalStock(0.99, microsoftStock));
	}

	@Test
	public void stockEarnings() {
		// Creates a list of stocks to be added to the portfolio
		List<Stock> stocks = new ArrayList<Stock>();
		Stock googleStock = new Stock("1", "Google", 10);
		Stock microsoftStock = new Stock("2", "Microsoft", 100);

		stocks.add(googleStock);
		stocks.add(microsoftStock);

		portfolio.setStocks(stocks);

		// set up return values
		EasyMock.expect(stockService.getClosingPrice(googleStock)).andReturn(22.0).times(1);
		EasyMock.expect(stockService.getOpenPrice(googleStock)).andReturn(35.00).times(1);
		EasyMock.expect(stockService.getClosingPrice(microsoftStock)).andReturn(70.0).times(1);
		EasyMock.expect(stockService.getOpenPrice(microsoftStock)).andReturn(57.0).times(1);

		// activate!
		EasyMock.replay(stockService);

		assertTrue(1170.0 == portfolio.todaysStockEarnings());

		EasyMock.verify(stockService);
	}

	@Test
	public void yearlyHigh() {
		// Creates a list of stocks to be added to the portfolio
		List<Stock> stocks = new ArrayList<Stock>();
		Stock googleStock = new Stock("1", "Google", 10);
		Stock microsoftStock = new Stock("2", "Microsoft", 100);

		stocks.add(googleStock);
		stocks.add(microsoftStock);

		portfolio.setStocks(stocks);

		// set up return values
		EasyMock.expect(stockService.getPrice(googleStock)).andReturn(82.0).times(1);
		EasyMock.expect(stockService.getYearlyHigh(googleStock)).andReturn(75.00).times(1);
		EasyMock.expect(stockService.getPrice(microsoftStock)).andReturn(70.0).times(1);
		EasyMock.expect(stockService.getYearlyHigh(microsoftStock)).andReturn(157.0).times(1);

		// activate!
		EasyMock.replay(stockService);
		
		double microsoftYearlyHighPercent = portfolio.percentageOffYearlyHigh(microsoftStock);
		double googleYearlyHighPercent = portfolio.percentageOffYearlyHigh(googleStock);
		//see if it returns the expected value within three decimal places 
		assertTrue(microsoftYearlyHighPercent - 0.554 <= EPSILON);
		assertTrue(googleYearlyHighPercent - (-0.093) <= EPSILON);
	}
}
