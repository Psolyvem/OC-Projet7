package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.BidList;

import java.util.Optional;

/**
 * An Interface defining the methods needed for an implementation of a BidListService.
 */
public interface IBidListService
{
	public Iterable<BidList> getBidLists();

	public Optional<BidList> getBidListById(int id);

	public void createBidList(BidList bidList);

	public void updateBidList(BidList bidList);

	public void deleteBidList(BidList bidList);
}
