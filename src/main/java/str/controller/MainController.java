package str.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import str.model.Report;
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

		/*
		 * CreditOrg org = service.getAll().get(0); org.add(new Indicator(20000));
		 * service.update(org);
		 */
		File file = new File("D:\\Work\\test.xls");
		try {
			List<String[]> rows = new Report(file).getRows();
		} catch (IOException e) {
			e.printStackTrace();
		}

		File archive = new File("D:\\Work\\тестовое задание по JAVA.RAR");

		// model.addAttribute("points", service.getAll());
		return "main";
	}
}