package com.openclassrooms.pcs.repositories;

import com.openclassrooms.pcs.domain.RuleName;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface that let Spring implements all basic CRUD methods for accessing the rule_name table in the database.
 */
public interface RuleNameRepository extends JpaRepository<RuleName, Integer>
{
}
