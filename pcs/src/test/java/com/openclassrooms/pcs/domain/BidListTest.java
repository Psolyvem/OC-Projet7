package com.openclassrooms.pcs.domain;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

public class BidListTest
{
	BidList bidList;

	@Test
	public void bidListTest()
	{
		this.bidList = new BidList();
		bidList.setBidListId(1);
		bidList.setAccount("test");
		bidList.setType("test");
		bidList.setBidQuantity(1.d);
		bidList.setAskQuantity(1.d);
		bidList.setBid(1.d);
		bidList.setAsk(1.d);
		bidList.setBenchmark("test");
		bidList.setBidListDate(new Timestamp(2000));
		bidList.setCommentary("test");
		bidList.setSecurity("test");
		bidList.setStatus("test");
		bidList.setTrader("test");
		bidList.setBook("test");
		bidList.setCreationName("test");
		bidList.setCreationDate(new Timestamp(2000));
		bidList.setRevisionName("test");
		bidList.setRevisionDate(new Timestamp(2000));
		bidList.setDealName("test");
		bidList.setDealType("test");
		bidList.setSourceListId("test");
		bidList.setSide("test");

		bidList.getBidListId();
		bidList.getAccount();
		bidList.getType();
		bidList.getBidQuantity();
		bidList.getAskQuantity();
		bidList.getBid();
		bidList.getAsk();
		bidList.getBenchmark();
		bidList.getBidListDate();
		bidList.getCommentary();
		bidList.getSecurity();
		bidList.getStatus();
		bidList.getTrader();
		bidList.getBook();
		bidList.getCreationName();
		bidList.getCreationDate();
		bidList.getRevisionName();
		bidList.getRevisionDate();
		bidList.getDealName();
		bidList.getDealType();
		bidList.getSourceListId();
		bidList.getSide();
	}
}
