package str.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import str.model.CreditOrg;
import str.model.ReportX;
import str.service.IService;

@Controller
public class MainController {

	private IService service;

	@Autowired
	public void setService(IService service) {
		this.service = service;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getMainMenu() {
		// service.save("D:\\Work\\test.xls", "D:\\Work\\test2.xls",
		// "D:\\Work\\test3.xls");
		try {
			new ReportX("D:\\Work\\test.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		modelAndView.addObject("name", "Главная страница");
		modelAndView.addObject("bill", service.getById(CreditOrg.class, 1));
		return modelAndView;
	}
}