package str.controller;

import java.util.Arrays;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import str.model.Bill;
import str.model.CreditOrg;
import str.model.Indicator;
import str.report.IReport;
import str.report.ReportFactory;
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
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		modelAndView.addObject("orgs", service.getAll(CreditOrg.class));
		modelAndView.addObject("bills", service.getAll(Bill.class));
		modelAndView.addObject("inds", Indicator.getNamesProperties());
		return modelAndView;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String createReport(@RequestParam(value = "orgs[]") String[] orgsId,
			@RequestParam(value = "bills[]") String[] billsId, @RequestParam(value = "inds[]") String[] indsNames,
			@RequestParam(value = "dirPath") String dirPath) {
		IReport rep = ReportFactory.getReport(dirPath + "\\отчет.xls");
		if (rep == null) {
			return "redirect:/";
		}

		LinkedList<CreditOrg> orgs = service.getById(CreditOrg.class,
				Arrays.stream(orgsId).mapToInt(Integer::parseInt).toArray());
		LinkedList<Bill> bills = service.getById(Bill.class,
				Arrays.stream(billsId).mapToInt(Integer::parseInt).toArray());
		LinkedList<Indicator> inds = service.getRetainIndicators(orgs, bills);
		String[] addProps = new String[] { "Организации", "Счета" };
		String[] total = new String[addProps.length + indsNames.length];
		System.arraycopy(addProps, 0, total, 0, addProps.length);
		System.arraycopy(indsNames, 0, total, addProps.length, indsNames.length);
		rep.addRow(total);
		for (Indicator ind : inds) {
			LinkedList<String> props = new LinkedList<String>();
			props.add(ind.getCreditOrg().getName());
			if (ind.getBill() == null) {
				props.add("Нет счета");
			} else {
				props.add(ind.getBill().getName());
			}
			for (String prop : indsNames) {
				props.add(ind.getProperty(prop).toString());
			}
			rep.addRow(props.toArray(new String[props.size()]));
		}
		rep.write();

		return "redirect:/";
	}
}