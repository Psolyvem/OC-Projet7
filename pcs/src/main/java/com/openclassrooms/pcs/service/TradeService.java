package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.Trade;
import com.openclassrooms.pcs.repositories.TradeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the ITradeService that gets and process information from the repositories.
 */
@Service
public class TradeService implements ITradeService
{
	TradeRepository tradeRepository;

	public TradeService(TradeRepository tradeRepository)
	{
		this.tradeRepository = tradeRepository;
	}

	/**
	 * Gets all the Trade from the database.
	 * @return an Iterable of Trade
	 */
	@Override
	public Iterable<Trade> getTrades()
	{
		return tradeRepository.findAll();
	}

	/**
	 * Gets a Trade from the database based on its ID.
	 * @return an Optional of Trade
	 */
	@Override
	public Optional<Trade> getTradeById(int id)
	{
		return tradeRepository.findById(id);
	}

	/**
	 * Save a Trade object to the database.
	 * @param trade the Trade to save.
	 */
	@Override
	public void createTrade(Trade trade)
	{
		tradeRepository.save(trade);
	}

	/**
	 * Updates a Trade object in the database or create it if it doesn't exist.
	 * @param trade the Trade to update.
	 */
	@Override
	public void updateTrade(Trade trade)
	{
		tradeRepository.save(trade);
	}

	/**
	 * Delete a Trade object if it exists in the database.
	 * @param trade the Trade to delete.
	 */
	@Override
	public void deleteTrade(Trade trade)
	{
		tradeRepository.delete(trade);
	}
}
