package str.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import str.model.CreditOrg;
import str.service.Service;

@Controller
public class MainController {

	private Service service = new Service();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getMainMenu(Model model) {
		service.save(new CreditOrg(1, "Test"));
		// model.addAttribute("points", service.getAll());
		return "main";
	}
}