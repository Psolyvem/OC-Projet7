package com.openclassrooms.pcs.controller;

import com.openclassrooms.pcs.controllers.TradeController;
import com.openclassrooms.pcs.domain.Trade;
import com.openclassrooms.pcs.service.ITradeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TradeControllerTest
{
	TradeController tradeController;
	@Mock
	ITradeService tradeService;
	@Mock
	Model model;
	@Mock
	BindingResult bindingResult;
	Trade trade;

	@BeforeEach
	public void setUp()
	{
		this.tradeController = new TradeController(this.tradeService);

		this.trade = new Trade();
		trade.setAccount("Test");
		trade.setType("Test");
		trade.setBuyQuantity(10.d);
	}

	@Test
	public void homeTest()
	{
		tradeController.home(model);
		verify(tradeService, times(1)).getTrades();
	}

	@Test
	public void validateTest()
	{
		tradeController.validate(trade, bindingResult, model);
		verify(tradeService, times(1)).createTrade(trade);
	}

	@Test
	public void showUpdateFormTest()
	{
		when(tradeService.getTradeById(1)).thenReturn(Optional.of(trade));
		tradeController.showUpdateForm(1, model);
		verify(tradeService, times(1)).getTradeById(1);
	}

	@Test
	public void updateTradeTest()
	{
		when(tradeService.getTradeById(1)).thenReturn(Optional.of(trade));
		tradeController.updateTrade(1, trade, bindingResult, model);
		verify(tradeService, times(1)).updateTrade(trade);
	}

	@Test
	public void deleteTradeTest()
	{
		when(tradeService.getTradeById(1)).thenReturn(Optional.of(trade));
		tradeController.deleteTrade(1, model);
		verify(tradeService, times(1)).deleteTrade(trade);
	}
}
