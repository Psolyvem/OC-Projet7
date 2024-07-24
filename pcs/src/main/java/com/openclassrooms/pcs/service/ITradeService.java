package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.Trade;

import java.util.Optional;

public interface ITradeService
{
	public Iterable<Trade> getTrades();

	public Optional<Trade> getTradeById(int id);

	public void createTrade(Trade trade);

	public void updateTrade(Trade trade);

	public void deleteTrade(Trade trade);
}
