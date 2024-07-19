package com.openclassrooms.pcs.repositories;

import com.openclassrooms.pcs.domain.BidList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BidListRepository extends JpaRepository<BidList, Integer> {

}
