package com.openclassrooms.pcs.domain;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

public class TradeTest
{
	Trade trade;

	@Test
	void tradeTest()
	{
		this.trade = new Trade();
		trade.setTradeId(1);
		trade.setAccount("test");
		trade.setType("test");
		trade.setBuyQuantity(1.d);
		trade.setSellQuantity(1.d);
		trade.setBuyPrice(1.d);
		trade.setSellPrice(1.d);
		trade.setBenchmark("test");
		trade.setTradeDate(new Timestamp(2000));
		trade.setSecurity("test");
		trade.setStatus("test");
		trade.setTrader("test");
		trade.setBook("test");
		trade.setCreationName("test");
		trade.setCreationDate(new Timestamp(2000));
		trade.setRevisionName("test");
		trade.setRevisionDate(new Timestamp(2000));
		trade.setDealName("test");
		trade.setDealType("test");
		trade.setSourceListId("test");
		trade.setSide("test");

		trade.getTradeId();
		trade.getAccount();
		trade.getType();
		trade.getBuyQuantity();
		trade.getSellQuantity();
		trade.getBuyPrice();
		trade.getSellPrice();
		trade.getBenchmark();
		trade.getTradeDate();
		trade.getSecurity();
		trade.getStatus();
		trade.getTrader();
		trade.getBook();
		trade.getCreationName();
		trade.getCreationDate();
		trade.getRevisionName();
		trade.getRevisionDate();
		trade.getDealName();
		trade.getDealType();
		trade.getSourceListId();
		trade.getSide();
	}
}
