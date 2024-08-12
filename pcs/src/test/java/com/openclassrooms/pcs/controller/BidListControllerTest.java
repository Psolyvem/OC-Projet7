package com.openclassrooms.pcs.controller;

import com.openclassrooms.pcs.controllers.BidListController;
import com.openclassrooms.pcs.domain.BidList;
import com.openclassrooms.pcs.service.IBidListService;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.ui.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BidListControllerTest
{
	BidListController bidListController;
	@Mock
	IBidListService bidListService;
	@Mock
	Model model;
	@Mock
	BindingResult bindingResult;
	BidList bidList;

	@BeforeEach
	public void setUp()
	{
		this.bidListController = new BidListController(this.bidListService);

		this.bidList = new BidList();
		bidList.setAccount("Test");
		bidList.setType("Test");
		bidList.setBidQuantity(50.d);
	}

	@Test
	public void homeTest()
	{
		bidListController.home(model);
		verify(bidListService, times(1)).getBidLists();
	}

	@Test
	public void validateTest()
	{
		bidListController.validate(bidList, bindingResult, model);
		verify(bidListService, times(1)).createBidList(bidList);
	}

	@Test
	public void showUpdateFormTest()
	{
		when(bidListService.getBidListById(1)).thenReturn(Optional.of(bidList));
		bidListController.showUpdateForm(1, model);
		verify(bidListService, times(1)).getBidListById(1);
	}

	@Test
	public void updateBidListTest()
	{
		when(bidListService.getBidListById(1)).thenReturn(Optional.of(bidList));
		bidListController.updateBid(1, bidList, bindingResult, model);
		verify(bidListService, times(1)).updateBidList(bidList);
	}

	@Test
	public void deleteBidListTest()
	{
		when(bidListService.getBidListById(1)).thenReturn(Optional.of(bidList));
		bidListController.deleteBid(1, model);
		verify(bidListService, times(1)).deleteBidList(bidList);
	}
}
