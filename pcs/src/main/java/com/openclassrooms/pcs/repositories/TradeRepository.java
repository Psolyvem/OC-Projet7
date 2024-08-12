package com.openclassrooms.pcs.repositories;

import com.openclassrooms.pcs.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Interface that let Spring implements all basic CRUD methods for accessing the trade table in the database.
 */
public interface TradeRepository extends JpaRepository<Trade, Integer>
{
}
