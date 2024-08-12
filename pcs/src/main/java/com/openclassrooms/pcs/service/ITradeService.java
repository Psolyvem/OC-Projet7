package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.Trade;

import java.util.Optional;

/**
 * An Interface defining the methods needed for an implementation of a TradeService.
 */
public interface ITradeService
{
	public Iterable<Trade> getTrades();

	public Optional<Trade> getTradeById(int id);

	public void createTrade(Trade trade);

	public void updateTrade(Trade trade);

	public void deleteTrade(Trade trade);
}
