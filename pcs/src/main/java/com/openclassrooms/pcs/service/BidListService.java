package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.BidList;
import com.openclassrooms.pcs.repositories.BidListRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the IBidListService that gets and process information from the repositories.
 */
@Service
public class BidListService implements IBidListService
{
	BidListRepository bidListRepository;

	public BidListService(BidListRepository bidListRepository)
	{
		this.bidListRepository = bidListRepository;
	}

	/**
	 * Gets all the BidList from the database.
	 * @return an Iterable of BidList
	 */
	@Override
	public Iterable<BidList> getBidLists()
	{
		return bidListRepository.findAll();
	}

	/**
	 * Gets a BidList from the database based on its ID.
	 * @return an Optional of BidList
	 */
	@Override
	public Optional<BidList> getBidListById(int id)
	{
		return bidListRepository.findById(id);
	}

	/**
	 * Save a BidList object to the database.
	 * @param bidList the BidList to save.
	 */
	@Override
	public void createBidList(BidList bidList)
	{
		bidListRepository.save(bidList);
	}

	/**
	 * Updates a BidList object in the database or create it if it doesn't exist.
	 * @param bidList the BidList to update.
	 */
	@Override
	public void updateBidList(BidList bidList)
	{
		bidListRepository.save(bidList);
	}

	/**
	 * Delete a BidList object if it exists in the database.
	 * @param bidList the BidList to delete.
	 */
	@Override
	public void deleteBidList(BidList bidList)
	{
		bidListRepository.delete(bidList);
	}
}
