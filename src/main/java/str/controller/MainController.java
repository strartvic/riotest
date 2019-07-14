package str.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		service.save("D:\\Work\\test.xls", "D:\\Work\\test2.xls", "D:\\Work\\test3.xls");

		// model.addAttribute("points", service.getAll());
		return "main";
	}
}