package com.openclassrooms.pcs.domain;

import org.junit.jupiter.api.Test;

public class RuleNameTest
{
	RuleName ruleName;

	@Test
	void ruleNameTest()
	{
		this.ruleName = new RuleName();
		ruleName.setId(1);
		ruleName.setName("test");
		ruleName.setDescription("test");
		ruleName.setJson("test");
		ruleName.setTemplate("test");
		ruleName.setSqlStr("test");
		ruleName.setSqlPart("test");

		ruleName.getId();
		ruleName.getName();
		ruleName.getDescription();
		ruleName.getJson();
		ruleName.getTemplate();
		ruleName.getSqlStr();
		ruleName.getSqlPart();
	}
}
