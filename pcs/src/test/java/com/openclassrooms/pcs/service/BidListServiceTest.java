package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.BidList;
import com.openclassrooms.pcs.repositories.BidListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BidListServiceTest
{
	IBidListService bidListService;
	@Mock
	BidListRepository bidListRepository;
	BidList bidList;

	@BeforeEach
	public void setUp()
	{
		this.bidListService = new BidListService(this.bidListRepository);

		this.bidList = new BidList();
		bidList.setAccount("Test");
		bidList.setType("Test");
		bidList.setBidQuantity(50.d);
	}

	@Test
	public void getBidListsTest()
	{
		bidListService.getBidLists();
		verify(bidListRepository, times(1)).findAll();
	}

	@Test
	public void getBidListByIdTest()
	{
		bidListService.getBidListById(1);
		verify(bidListRepository, times(1)).findById(1);
	}

	@Test
	public void createBidListTest()
	{
		bidListService.createBidList(bidList);
		verify(bidListRepository, times(1)).save(bidList);
	}

	@Test
	public void updateBidListTest()
	{
		bidListService.updateBidList(bidList);
		verify(bidListRepository, times(1)).save(bidList);
	}

	@Test
	public void deleteBidListTest()
	{
		bidListService.deleteBidList(bidList);
		verify(bidListRepository, times(1)).delete(bidList);
	}
}
