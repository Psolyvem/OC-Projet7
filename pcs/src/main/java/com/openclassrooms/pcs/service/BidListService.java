package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.BidList;
import com.openclassrooms.pcs.repositories.BidListRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BidListService implements IBidListService
{
	BidListRepository bidListRepository;

	public BidListService(BidListRepository bidListRepository)
	{
		this.bidListRepository = bidListRepository;
	}

	@Override
	public Iterable<BidList> getBidLists()
	{
		return bidListRepository.findAll();
	}

	@Override
	public Optional<BidList> getBidListById(int id)
	{
		return bidListRepository.findById(id);
	}

	@Override
	public void createBidList(BidList bidList)
	{
		bidListRepository.save(bidList);
	}

	@Override
	public void updateBidList(BidList bidList)
	{
		bidListRepository.save(bidList);
	}

	@Override
	public void deleteBidList(BidList bidList)
	{
		bidListRepository.delete(bidList);
	}
}
