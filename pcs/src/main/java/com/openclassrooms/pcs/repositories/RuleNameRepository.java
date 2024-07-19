package com.openclassrooms.pcs.repositories;

import com.openclassrooms.pcs.domain.RuleName;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RuleNameRepository extends JpaRepository<RuleName, Integer> {
}
