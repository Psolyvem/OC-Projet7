package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.BidList;

import java.util.Optional;

public interface IBidListService
{
	public Iterable<BidList> getBidLists();

	public Optional<BidList> getBidListById(int id);

	public void createBidList(BidList bidList);

	public void updateBidList(BidList bidList);

	public void deleteBidList(BidList bidList);
}
