package edu.mum.hbteam.sup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.hbteam.sup.domain.PurchaseRequest;
import edu.mum.hbteam.sup.domain.Status;
import edu.mum.hbteam.sup.service.PurchaseReqService;

@Controller
@RequestMapping("/requests")
public class PurchaseReqController {

	@Autowired
	private PurchaseReqService purchaseReqService;

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("requests", purchaseReqService.findAll());
		return "requests";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewItemForm(@ModelAttribute("newPurchase") PurchaseRequest newPurchase) {
		return "addPurchase";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewItemForm(@ModelAttribute("newPurchase") @Valid PurchaseRequest purchaseToBeAdded,
			BindingResult result) {
		if (result.hasErrors()) {
			return "addPurchase";
		}

		try {
			purchaseReqService.save(purchaseToBeAdded);
		} catch (Exception up) {
			System.out.println("Transaction Failed!!!");

		}

		return "redirect:/requests";
	}

	@RequestMapping(value = "/confirm/{id}", method = RequestMethod.POST)
	public String processConfirmRequest(@PathVariable("id") Long id) {

		purchaseReqService.update(id);
		return "redirect:/requests";
	}

}
