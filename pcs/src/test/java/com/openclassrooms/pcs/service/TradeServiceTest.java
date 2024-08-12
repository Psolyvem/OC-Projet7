package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.Trade;
import com.openclassrooms.pcs.repositories.TradeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TradeServiceTest
{
	ITradeService tradeService;
	@Mock
	TradeRepository tradeRepository;
	Trade trade;

	@BeforeEach
	public void setUp()
	{
		this.tradeService = new TradeService(this.tradeRepository);

		this.trade = new Trade();
		trade.setAccount("Test");
		trade.setType("Test");
		trade.setBuyQuantity(10.d);
	}

	@Test
	public void getTradesTest()
	{
		tradeService.getTrades();
		verify(tradeRepository, times(1)).findAll();
	}

	@Test
	public void getTradeByIdTest()
	{
		tradeService.getTradeById(1);
		verify(tradeRepository, times(1)).findById(1);
	}

	@Test
	public void createTradeTest()
	{
		tradeService.createTrade(trade);
		verify(tradeRepository, times(1)).save(trade);
	}

	@Test
	public void updateTradeTest()
	{
		tradeService.updateTrade(trade);
		verify(tradeRepository, times(1)).save(trade);
	}

	@Test
	public void deleteTradeTest()
	{
		tradeService.deleteTrade(trade);
		verify(tradeRepository, times(1)).delete(trade);
	}
}
