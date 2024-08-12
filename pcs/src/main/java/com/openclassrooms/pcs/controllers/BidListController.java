package com.openclassrooms.pcs.controllers;

import com.openclassrooms.pcs.domain.BidList;
import com.openclassrooms.pcs.service.IBidListService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import org.tinylog.Logger;

/**
 * Controller for handling HTTP request concerning BidLists.
 */
@Controller
public class BidListController
{

	IBidListService bidListService;

	/**
	 * Constructor, used only for testing.
	 *
	 * @param bidListService injection of dependency IBidListService
	 */
	public BidListController(IBidListService bidListService)
	{
		this.bidListService = bidListService;
	}

	/**
	 * Called when an HTTP request GET is done on bidList/list.
	 *
	 * @param model The data handled to the view
	 * @return The view of bidList/list
	 */
	@RequestMapping("/bidList/list")
	public String home(Model model)
	{
		model.addAttribute("bidLists", bidListService.getBidLists());
		return "bidList/list";
	}

	/**
	 * Called when an HTTP request GET is done on bidList/add.
	 *
	 * @return The view of bidList/add
	 */
	@GetMapping("/bidList/add")
	public String addBidForm(BidList bid)
	{
		return "bidList/add";
	}

	/**
	 * Called when an HTTP request POST is done on bidList/validate.
	 *
	 * @param bidList The bidList object constructed from the form
	 * @param result  The eventual errors that returns to the view
	 * @param model   The data handled to the view
	 * @return Either the bidList/list page updated or the bidList/add page with errors
	 */
	@Transactional
	@PostMapping("/bidList/validate")
	public String validate(@Valid BidList bidList, BindingResult result, Model model)
	{
		if (!result.hasErrors())
		{
			bidListService.createBidList(bidList);
			model.addAttribute("bidLists", bidListService.getBidLists());
			return "redirect:/bidList/list";
		}
		return "bidList/add";
	}

	/**
	 * Called when an HTTP request GET is done on bidList/update/{id}.
	 *
	 * @param id    Id of the object to update (from URL)
	 * @param model The data handled to the view
	 * @return The view of bidList/update
	 */
	@GetMapping("/bidList/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model)
	{
		try
		{
			BidList bidList = bidListService.getBidListById(id).orElseThrow(() -> new IllegalArgumentException("Invalid bidList Id:" + id));
			model.addAttribute("bidList", bidList);
		}
		catch (IllegalArgumentException e)
		{
			Logger.error("Invalid bidList id : " + id + ", unable to update.");
			return "redirect:/bidList/list";
		}
		return "bidList/update";
	}

	/**
	 * Called when an HTTP request POST is done on bidList/update/{id}.
	 *
	 * @param id      Id of the object to update (from URL)
	 * @param bidList The bidList object constructed from the form
	 * @param result  The eventual errors that returns to the view
	 * @param model   The data handled to the view
	 * @return Either the bidList/list page updated or the bidList/update page with errors
	 */
	@Transactional
	@PostMapping("/bidList/update/{id}")
	public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList, BindingResult result, Model model)
	{
		if (!result.hasErrors())
		{
			try
			{
				bidListService.getBidListById(id).orElseThrow(() -> new IllegalArgumentException());
				bidListService.updateBidList(bidList);
				model.addAttribute("bidLists", bidListService.getBidLists());
			}
			catch (IllegalArgumentException e)
			{
				Logger.error("Invalid bidList id : " + id + ", unable to update.");
			}
			return "redirect:/bidList/list";
		}
		return "bidList/update";
	}

	/**
	 * Called when an HTTP request POST is done on bidList/update/{id}.
	 *
	 * @param id    Id of the object to delete (from URL)
	 * @param model The data handled to the view
	 * @return The view of bidList/list updated
	 */
	@GetMapping("/bidList/delete/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model)
	{
		try
		{
			BidList bidList = bidListService.getBidListById(id).orElseThrow(() -> new IllegalArgumentException("Invalid bidList Id:" + id));
			bidListService.deleteBidList(bidList);
			model.addAttribute("bidLists", bidListService.getBidLists());
		}
		catch (IllegalArgumentException e)
		{
			Logger.error("Invalid bidList id : " + id + ", unable to update.");
		}
		return "redirect:/bidList/list";
	}
}
