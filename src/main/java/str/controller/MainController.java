package str.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import str.model.Bill;
import str.service.Service;

@Controller
public class MainController {

	private Service service = new Service();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getMainMenu(Model model) {
		/*
		 * Indicator ind = new Indicator(2000); Bill bill = new Bill(2, "Российская");
		 * CreditOrg org = service.getAll().get(0); org.add(ind); service.save(bill);
		 */
		service.save(new Bill(16, "sfdsfasdsasdfds"));
		// model.addAttribute("points", service.getAll());
		return "main";
	}
}