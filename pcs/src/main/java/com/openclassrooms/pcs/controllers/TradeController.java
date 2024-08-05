package com.openclassrooms.pcs.controllers;

import com.openclassrooms.pcs.domain.Trade;
import com.openclassrooms.pcs.service.ITradeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for handling HTTP request concerning Trades.
 */
@Controller
public class TradeController {

    ITradeService tradeService;

    /**
     * Constructor, used only for testing.
     * @param tradeService injection of dependency ITradeService
     */
    public TradeController(ITradeService tradeService)
    {
        this.tradeService = tradeService;
    }

    /**
     * Called when an HTTP request GET is done on trade/list.
     * @param model The data handled to the view
     * @return The view of trade/list
     */
    @RequestMapping("/trade/list")
    public String home(Model model)
    {
        model.addAttribute("trades", tradeService.getTrades());
        return "trade/list";
    }

    /**
     * Called when an HTTP request GET is done on trade/add.
     * @return The view of trade/add
     */
    @GetMapping("/trade/add")
    public String addUser(Trade bid) {
        return "trade/add";
    }

    /**
     * Called when an HTTP request POST is done on trade/validate.
     * @param trade The trade object constructed from the form
     * @param result The eventual errors that returns to the view
     * @param model The data handled to the view
     * @return Either the trade/list page updated or the trade/add page with errors
     */
    @Transactional
    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        if (!result.hasErrors())
        {
            tradeService.createTrade(trade);
            model.addAttribute("trades", tradeService.getTrades());
            return "redirect:/trade/list";
        }
        return "trade/add";
    }

    /**
     * Called when an HTTP request GET is done on trade/update/{id}.
     * @param id Id of the object to update (from URL)
     * @param model The data handled to the view
     * @return The view of trade/update
     */
    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Trade trade = tradeService.getTradeById(id).orElseThrow(() -> new IllegalArgumentException("Invalid trade Id:" + id));
        model.addAttribute("trade", trade);
        return "trade/update";
    }

    /**
     * Called when an HTTP request POST is done on trade/update/{id}.
     * @param id Id of the object to update (from URL)
     * @param trade The trade object constructed from the form
     * @param result The eventual errors that returns to the view
     * @param model The data handled to the view
     * @return Either the trade/list page updated or the trade/update page with errors
     */
    @Transactional
    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model) {
        if (!result.hasErrors())
        {
            tradeService.updateTrade(trade);
            model.addAttribute("trades", tradeService.getTrades());
            return "redirect:/trade/list";
        }

        return "trade/update";
    }

    /**
     * Called when an HTTP request POST is done on trade/update/{id}.
     * @param id Id of the object to delete (from URL)
     * @param model The data handled to the view
     * @return The view of trade/list updated
     */
    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        Trade trade = tradeService.getTradeById(id).orElseThrow(() -> new IllegalArgumentException("Invalid trade Id:" + id));
        tradeService.deleteTrade(trade);
        model.addAttribute("trades", tradeService.getTrades());
        return "redirect:/trade/list";
    }
}
