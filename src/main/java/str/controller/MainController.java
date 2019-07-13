package str.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import str.model.CreditOrg;
import str.model.Indicator;
import str.service.IService;

@Controller
public class MainController {

	private IService service;

	@Autowired
	public void setService(IService service) {
		this.service = service;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getMainMenu(Model model) {
		/*
		 * Indicator ind = new Indicator(2000); Bill bill = new Bill(2, "Российская");
		 * CreditOrg org = service.getAll().get(0); org.add(ind); service.save(bill);
		 */
		CreditOrg org = service.getAll().get(0);
		org.add(new Indicator(20000));
		service.update(org);
		// model.addAttribute("points", service.getAll());
		return "main";
	}
}