package com.openclassrooms.pcs.controllers;

import com.openclassrooms.pcs.domain.CurvePoint;
import com.openclassrooms.pcs.service.ICurvePointService;
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
 * Controller for handling HTTP request concerning CurvePoints.
 */
@Controller
public class CurveController
{

	ICurvePointService curvePointService;

	/**
	 * Constructor, used only for testing.
	 * @param curvePointService injection of dependency ICurvePointService
	 */
	public CurveController(ICurvePointService curvePointService)
	{
		this.curvePointService = curvePointService;
	}

	/**
	 * Called when an HTTP request GET is done on curvePoint/list.
	 * @param model The data handled to the view
	 * @return The view of curvePoint/list
	 */
	@RequestMapping("/curvePoint/list")
	public String home(Model model)
	{
		model.addAttribute("curvePoints", curvePointService.getCurvePoints());
		return "curvePoint/list";
	}

	/**
	 * Called when an HTTP request GET is done on curvePoint/add.
	 * @return The view of curvePoint/add
	 */
	@GetMapping("/curvePoint/add")
	public String addCurvePointForm(CurvePoint curvePoint)
	{
		return "curvePoint/add";
	}

	/**
	 * Called when an HTTP request POST is done on curvePoint/validate.
	 * @param curvePoint The curvePoint object constructed from the form
	 * @param result The eventual errors that returns to the view
	 * @param model The data handled to the view
	 * @return Either the curvePoint/list page updated or the curvePoint/add page with errors
	 */
	@Transactional
	@PostMapping("/curvePoint/validate")
	public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model)
	{
		if (!result.hasErrors())
		{
			curvePointService.createCurvePoint(curvePoint);
			model.addAttribute("curvePoints", curvePointService.getCurvePoints());
			return "redirect:/curvePoint/list";
		}
		return "curvePoint/add";
	}

	/**
	 * Called when an HTTP request GET is done on curvePoint/update/{id}.
	 * @param id Id of the object to update (from URL)
	 * @param model The data handled to the view
	 * @return The view of curvePoint/update
	 */
	@GetMapping("/curvePoint/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model)
	{
		try
		{
			CurvePoint curvePoint = curvePointService.getCurvePointById(id).orElseThrow(() -> new IllegalArgumentException("Invalid curvePoint Id:" + id));
			model.addAttribute("curvePoint", curvePoint);
		}
		catch (IllegalArgumentException e)
		{
			Logger.error("Invalid CurvePoint id : " + id + ", unable to update.");
			return "redirect:/curvePoint/list";
		}
		return "curvePoint/update";
	}

	/**
	 * Called when an HTTP request POST is done on curvePoint/update/{id}.
	 * @param id Id of the object to update (from URL)
	 * @param curvePoint The curvePoint object constructed from the form
	 * @param result The eventual errors that returns to the view
	 * @param model The data handled to the view
	 * @return Either the curvePoint/list page updated or the curvePoint/update page with errors
	 */
	@Transactional
	@PostMapping("/curvePoint/update/{id}")
	public String updateCurvePoint(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint, BindingResult result, Model model)
	{
		if (!result.hasErrors())
		{
			try
			{
				curvePointService.getCurvePointById(id).orElseThrow(() -> new IllegalArgumentException());
				curvePointService.updateCurvePoint(curvePoint);
				model.addAttribute("curvePoints", curvePointService.getCurvePoints());
			}
			catch (IllegalArgumentException e)
			{
				Logger.error("Invalid CurvePoint id : " + id + ", unable to update.");
			}
			return "redirect:/curvePoint/list";
		}

		return "curvePoint/update";
	}

	/**
	 * Called when an HTTP request POST is done on curvePoint/update/{id}.
	 * @param id Id of the object to delete (from URL)
	 * @param model The data handled to the view
	 * @return The view of curvePoint/list updated
	 */
	@GetMapping("/curvePoint/delete/{id}")
	public String deleteCurvePoint(@PathVariable("id") Integer id, Model model)
	{
		try
		{
			CurvePoint curvePoint = curvePointService.getCurvePointById(id).orElseThrow(() -> new IllegalArgumentException("Invalid curvePoint Id:" + id));
			curvePointService.deleteCurvePoint(curvePoint);
			model.addAttribute("curvePoints", curvePointService.getCurvePoints());
		}
		catch (IllegalArgumentException e)
		{
			Logger.error("Invalid CurvePoint id : " + id + ", unable to update.");
		}
		return "redirect:/curvePoint/list";
	}
}
