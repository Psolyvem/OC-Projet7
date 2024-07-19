package com.openclassrooms.pcs.repositories;

import com.openclassrooms.pcs.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TradeRepository extends JpaRepository<Trade, Integer> {
}
