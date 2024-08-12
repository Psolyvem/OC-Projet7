package com.openclassrooms.pcs.controller;

import com.openclassrooms.pcs.controllers.RuleNameController;
import com.openclassrooms.pcs.domain.RuleName;
import com.openclassrooms.pcs.service.IRuleNameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RuleNameControllerTest
{
	RuleNameController ruleNameController;
	@Mock
	IRuleNameService ruleNameService;
	@Mock
	Model model;
	@Mock
	BindingResult bindingResult;
	RuleName ruleName;

	@BeforeEach
	public void setUp()
	{
		this.ruleNameController = new RuleNameController(this.ruleNameService);

		this.ruleName = new RuleName();
		ruleName.setName("Test");
		ruleName.setDescription("Test");
		ruleName.setJson("Test");
		ruleName.setTemplate("Test");
		ruleName.setSqlStr("Test");
		ruleName.setSqlPart("Test");
	}

	@Test
	public void homeTest()
	{
		ruleNameController.home(model);
		verify(ruleNameService, times(1)).getRuleNames();
	}

	@Test
	public void validateTest()
	{
		ruleNameController.validate(ruleName, bindingResult, model);
		verify(ruleNameService, times(1)).createRuleName(ruleName);
	}

	@Test
	public void showUpdateFormTest()
	{
		when(ruleNameService.getRuleNameById(1)).thenReturn(Optional.of(ruleName));
		ruleNameController.showUpdateForm(1, model);
		verify(ruleNameService, times(1)).getRuleNameById(1);
	}

	@Test
	public void updateRuleNameTest()
	{
		when(ruleNameService.getRuleNameById(1)).thenReturn(Optional.of(ruleName));
		ruleNameController.updateRuleName(1, ruleName, bindingResult, model);
		verify(ruleNameService, times(1)).updateRuleName(ruleName);
	}

	@Test
	public void deleteRuleNameTest()
	{
		when(ruleNameService.getRuleNameById(1)).thenReturn(Optional.of(ruleName));
		ruleNameController.deleteRuleName(1, model);
		verify(ruleNameService, times(1)).deleteRuleName(ruleName);
	}
}
