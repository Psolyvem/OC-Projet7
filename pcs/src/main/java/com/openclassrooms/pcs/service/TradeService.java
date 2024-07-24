package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.Trade;
import com.openclassrooms.pcs.repositories.TradeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TradeService implements ITradeService
{
	TradeRepository tradeRepository;

	public TradeService(TradeRepository tradeRepository)
	{
		this.tradeRepository = tradeRepository;
	}

	@Override
	public Iterable<Trade> getTrades()
	{
		return tradeRepository.findAll();
	}

	@Override
	public Optional<Trade> getTradeById(int id)
	{
		return tradeRepository.findById(id);
	}

	@Override
	public void createTrade(Trade trade)
	{
		tradeRepository.save(trade);
	}

	@Override
	public void updateTrade(Trade trade)
	{
		tradeRepository.save(trade);
	}

	@Override
	public void deleteTrade(Trade trade)
	{
		tradeRepository.delete(trade);
	}
}
