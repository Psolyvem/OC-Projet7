package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.RuleName;
import com.openclassrooms.pcs.repositories.RuleNameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RuleNameServiceTest
{
	IRuleNameService ruleNameService;
	@Mock
	RuleNameRepository ruleNameRepository;
	RuleName ruleName;

	@BeforeEach
	public void setUp()
	{
		this.ruleNameService = new RuleNameService(this.ruleNameRepository);

		this.ruleName = new RuleName();
		ruleName.setName("Test");
		ruleName.setDescription("Test");
		ruleName.setJson("Test");
		ruleName.setTemplate("Test");
		ruleName.setSqlStr("Test");
		ruleName.setSqlPart("Test");
	}

	@Test
	public void getRuleNamesTest()
	{
		ruleNameService.getRuleNames();
		verify(ruleNameRepository, times(1)).findAll();
	}

	@Test
	public void getRuleNameByIdTest()
	{
		ruleNameService.getRuleNameById(1);
		verify(ruleNameRepository, times(1)).findById(1);
	}

	@Test
	public void createRuleNameTest()
	{
		ruleNameService.createRuleName(ruleName);
		verify(ruleNameRepository, times(1)).save(ruleName);
	}

	@Test
	public void updateRuleNameTest()
	{
		ruleNameService.updateRuleName(ruleName);
		verify(ruleNameRepository, times(1)).save(ruleName);
	}

	@Test
	public void deleteRuleNameTest()
	{
		ruleNameService.deleteRuleName(ruleName);
		verify(ruleNameRepository, times(1)).delete(ruleName);
	}
}
