package str.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import str.model.CreditOrg;
import str.model.Indicator;
import str.service.Service;

@Controller
public class MainController {

	private Service service = new Service();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getMainMenu(Model model) {
		/*
		 * CreditOrg org = new CreditOrg(1, "Test"); service.save(org); Indicator ind =
		 * new Indicator(100); ind.setCreditOrg(org); service.save(ind);
		 */
		Indicator ind = new Indicator(1000);
		CreditOrg org = service.getAll().get(0);
		org.add(ind);
		service.update(org);
		// model.addAttribute("points", service.getAll());
		return "main";
	}
}