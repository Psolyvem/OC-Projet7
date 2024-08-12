package com.openclassrooms.pcs.controllers;

import com.openclassrooms.pcs.domain.RuleName;
import com.openclassrooms.pcs.service.IRuleNameService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinylog.Logger;

/**
 * Controller for handling HTTP request concerning RuleNames.
 */
@Controller
public class RuleNameController
{

	IRuleNameService ruleNameService;

	/**
	 * Constructor, used only for testing.
	 *
	 * @param ruleNameService injection of dependency IRuleNameService
	 */
	public RuleNameController(IRuleNameService ruleNameService)
	{
		this.ruleNameService = ruleNameService;
	}

	/**
	 * Called when an HTTP request GET is done on ruleName/list.
	 *
	 * @param model The data handled to the view
	 * @return The view of ruleName/list
	 */
	@RequestMapping("/ruleName/list")
	public String home(Model model)
	{
		model.addAttribute("ruleNames", ruleNameService.getRuleNames());
		return "ruleName/list";
	}

	/**
	 * Called when an HTTP request GET is done on ruleName/add.
	 *
	 * @return The view of ruleName/add
	 */
	@GetMapping("/ruleName/add")
	public String addRuleForm(RuleName ruleName)
	{
		return "ruleName/add";
	}

	/**
	 * Called when an HTTP request POST is done on ruleName/validate.
	 *
	 * @param ruleName The ruleName object constructed from the form
	 * @param result   The eventual errors that returns to the view
	 * @param model    The data handled to the view
	 * @return Either the ruleName/list page updated or the ruleName/add page with errors
	 */
	@Transactional
	@PostMapping("/ruleName/validate")
	public String validate(@Valid RuleName ruleName, BindingResult result, Model model)
	{
		if (!result.hasErrors())
		{
			ruleNameService.createRuleName(ruleName);
			model.addAttribute("ruleNames", ruleNameService.getRuleNames());
			return "redirect:/ruleName/list";
		}
		return "ruleName/add";
	}

	/**
	 * Called when an HTTP request GET is done on ruleName/update/{id}.
	 *
	 * @param id    Id of the object to update (from URL)
	 * @param model The data handled to the view
	 * @return The view of ruleName/update
	 */
	@GetMapping("/ruleName/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model)
	{
		try
		{
			RuleName ruleName = ruleNameService.getRuleNameById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ruleName Id:" + id));
			model.addAttribute("ruleName", ruleName);
		}
		catch (IllegalArgumentException e)
		{
			Logger.error("Invalid RuleName id : " + id + ", unable to update.");
			return "redirect:/ruleName/list";
		}
		return "ruleName/update";
	}

	/**
	 * Called when an HTTP request POST is done on ruleName/update/{id}.
	 *
	 * @param id       Id of the object to update (from URL)
	 * @param ruleName The ruleName object constructed from the form
	 * @param result   The eventual errors that returns to the view
	 * @param model    The data handled to the view
	 * @return Either the ruleName/list page updated or the ruleName/update page with errors
	 */
	@Transactional
	@PostMapping("/ruleName/update/{id}")
	public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName, BindingResult result, Model model)
	{
		if (!result.hasErrors())
		{
			try
			{
				ruleNameService.getRuleNameById(id).orElseThrow(() -> new IllegalArgumentException());
				ruleNameService.updateRuleName(ruleName);
				model.addAttribute("ruleNames", ruleNameService.getRuleNames());
			}
			catch (IllegalArgumentException e)
			{
				Logger.error("Invalid RuleName id : " + id + ", unable to update.");
			}
			return "redirect:/ruleName/list";
		}
		return "ruleName/update";
	}

	/**
	 * Called when an HTTP request POST is done on ruleName/update/{id}.
	 *
	 * @param id    Id of the object to delete (from URL)
	 * @param model The data handled to the view
	 * @return The view of ruleName/list updated
	 */
	@GetMapping("/ruleName/delete/{id}")
	public String deleteRuleName(@PathVariable("id") Integer id, Model model)
	{
		try
		{
			RuleName ruleName = ruleNameService.getRuleNameById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ruleName Id:" + id));
			ruleNameService.deleteRuleName(ruleName);
			model.addAttribute("ruleNames", ruleNameService.getRuleNames());
		}
		catch (IllegalArgumentException e)
		{
			Logger.error("Invalid RuleName id : " + id + ", unable to update.");
		}
		return "redirect:/ruleName/list";
	}
}
