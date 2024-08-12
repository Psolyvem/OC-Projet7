package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.RuleName;
import com.openclassrooms.pcs.repositories.RuleNameRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the IRuleNameService that gets and process information from the repositories.
 */
@Service
public class RuleNameService implements IRuleNameService
{
	RuleNameRepository ruleNameRepository;

	public RuleNameService(RuleNameRepository ruleNameRepository)
	{
		this.ruleNameRepository = ruleNameRepository;
	}

	/**
	 * Gets all the RuleName from the database.
	 * @return an Iterable of RuleName
	 */
	@Override
	public Iterable<RuleName> getRuleNames()
	{
		return ruleNameRepository.findAll();
	}

	/**
	 * Gets a RuleName from the database based on its ID.
	 * @return an Optional of RuleName
	 */
	@Override
	public Optional<RuleName> getRuleNameById(int id)
	{
		return ruleNameRepository.findById(id);
	}

	/**
	 * Save a RuleName object to the database.
	 * @param ruleName the RuleName to save.
	 */
	@Override
	public void createRuleName(RuleName ruleName)
	{
		ruleNameRepository.save(ruleName);
	}

	/**
	 * Updates a RuleName object in the database or create it if it doesn't exist.
	 * @param ruleName the RuleName to update.
	 */
	@Override
	public void updateRuleName(RuleName ruleName)
	{
		ruleNameRepository.save(ruleName);
	}

	/**
	 * Delete a RuleName object if it exists in the database.
	 * @param ruleName the RuleName to delete.
	 */
	@Override
	public void deleteRuleName(RuleName ruleName)
	{
		ruleNameRepository.delete(ruleName);
	}
}
