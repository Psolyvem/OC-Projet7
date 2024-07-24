package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.RuleName;

import java.util.Optional;

public interface IRuleNameService
{
	public Iterable<RuleName> getRuleNames();

	public Optional<RuleName> getRuleNameById(int id);

	public void createRuleName(RuleName ruleName);

	public void updateRuleName(RuleName ruleName);

	public void deleteRuleName(RuleName ruleName);
}
