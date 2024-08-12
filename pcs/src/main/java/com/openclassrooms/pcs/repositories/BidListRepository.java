package com.openclassrooms.pcs.repositories;

import com.openclassrooms.pcs.domain.BidList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface that let Spring implements all basic CRUD methods for accessing the bid_list table in the database.
 */
public interface BidListRepository extends JpaRepository<BidList, Integer>
{

}
