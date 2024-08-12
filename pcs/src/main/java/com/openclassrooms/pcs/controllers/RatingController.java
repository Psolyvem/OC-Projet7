package com.openclassrooms.pcs.controllers;

import com.openclassrooms.pcs.domain.Rating;
import com.openclassrooms.pcs.service.IRatingService;
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
 * Controller for handling HTTP request concerning Ratings.
 */
@Controller
public class RatingController
{

	IRatingService ratingService;

	/**
	 * Constructor, used only for testing.
	 * @param ratingService injection of dependency IRatingService
	 */
	public RatingController(IRatingService ratingService)
	{
		this.ratingService = ratingService;
	}

	/**
	 * Called when an HTTP request GET is done on rating/list.
	 * @param model The data handled to the view
	 * @return The view of rating/list
	 */
	@RequestMapping("/rating/list")
	public String home(Model model)
	{
		model.addAttribute("ratings", ratingService.getRatings());
		return "rating/list";
	}

	/**
	 * Called when an HTTP request GET is done on rating/add.
	 * @return The view of rating/add
	 */
	@GetMapping("/rating/add")
	public String addRatingForm(Rating rating)
	{
		return "rating/add";
	}

	/**
	 * Called when an HTTP request POST is done on rating/validate.
	 * @param rating The rating object constructed from the form
	 * @param result The eventual errors that returns to the view
	 * @param model The data handled to the view
	 * @return Either the rating/list page updated or the rating/add page with errors
	 */
	@Transactional
	@PostMapping("/rating/validate")
	public String validate(@Valid Rating rating, BindingResult result, Model model)
	{
		if (!result.hasErrors())
		{
			ratingService.createRating(rating);
			model.addAttribute("ratings", ratingService.getRatings());
			return "redirect:/rating/list";
		}
		return "rating/add";
	}

	/**
	 * Called when an HTTP request GET is done on rating/update/{id}.
	 * @param id Id of the object to update (from URL)
	 * @param model The data handled to the view
	 * @return The view of rating/update
	 */
	@GetMapping("/rating/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model)
	{
		try
		{
			Rating rating = ratingService.getRatingById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id:" + id));
			model.addAttribute("rating", rating);
		}
		catch (IllegalArgumentException e)
		{
			Logger.error("Invalid Rating id : " + id + ", unable to update.");
			return "redirect:/rating/list";
		}
		return "rating/update";
	}

	/**
	 * Called when an HTTP request POST is done on rating/update/{id}.
	 * @param id Id of the object to update (from URL)
	 * @param rating The rating object constructed from the form
	 * @param result The eventual errors that returns to the view
	 * @param model The data handled to the view
	 * @return Either the rating/list page updated or the rating/update page with errors
	 */
	@Transactional
	@PostMapping("/rating/update/{id}")
	public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating, BindingResult result, Model model)
	{
		if (!result.hasErrors())
		{
			try
			{
				ratingService.getRatingById(id).orElseThrow(() -> new IllegalArgumentException());
				ratingService.updateRating(rating);
				model.addAttribute("ratings", ratingService.getRatings());
			}
			catch (IllegalArgumentException e)
			{
				Logger.error("Invalid Rating id : " + id + ", unable to update.");
			}
			return "redirect:/rating/list";
		}
		return "rating/update";
	}

	/**
	 * Called when an HTTP request POST is done on rating/update/{id}.
	 * @param id Id of the object to delete (from URL)
	 * @param model The data handled to the view
	 * @return The view of rating/list updated
	 */
	@GetMapping("/rating/delete/{id}")
	public String deleteRating(@PathVariable("id") Integer id, Model model)
	{
		try
		{
			Rating rating = ratingService.getRatingById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id:" + id));
			ratingService.deleteRating(rating);
			model.addAttribute("ratings", ratingService.getRatings());
		}
		catch (IllegalArgumentException e)
		{
			Logger.error("Invalid Rating id : " + id + ", unable to update.");
		}
		return "redirect:/rating/list";
	}
}
