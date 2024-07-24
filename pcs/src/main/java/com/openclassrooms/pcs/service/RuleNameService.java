package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.RuleName;
import com.openclassrooms.pcs.repositories.RuleNameRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RuleNameService implements IRuleNameService
{
	RuleNameRepository ruleNameRepository;

	public RuleNameService(RuleNameRepository ruleNameRepository)
	{
		this.ruleNameRepository = ruleNameRepository;
	}

	@Override
	public Iterable<RuleName> getRuleNames()
	{
		return ruleNameRepository.findAll();
	}

	@Override
	public Optional<RuleName> getRuleNameById(int id)
	{
		return ruleNameRepository.findById(id);
	}

	@Override
	public void createRuleName(RuleName ruleName)
	{
		ruleNameRepository.save(ruleName);
	}

	@Override
	public void updateRuleName(RuleName ruleName)
	{
		ruleNameRepository.save(ruleName);
	}

	@Override
	public void deleteRuleName(RuleName ruleName)
	{
		ruleNameRepository.delete(ruleName);
	}
}
