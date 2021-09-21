package com.employee.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.entities.Employee;
import com.employee.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-employees", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("employees", employeeService.getTodosByUser(name));
		// model.put("employees", service.retrieveTodos(name));
		return "list-employees";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@RequestMapping(value = "/add-employee", method = RequestMethod.GET)
	public String showAddEmployeePage(ModelMap model) {
		model.addAttribute("employee", new Employee());
		return "employee";
	}

	@RequestMapping(value = "/delete-employee", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam long id) {
		employeeService.deleteEmployee(id);
		// service.deleteTodo(id);
		return "redirect:/list-employees";
	}

	@RequestMapping(value = "/update-employee", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
		Employee employee = employeeService.getEmployeeById(id).get();
		model.put("employee", employee);
		return "employee";
	}

	@RequestMapping(value = "/update-employee", method = RequestMethod.POST)
	public String updateEmployee(ModelMap model, @Valid Employee employee, BindingResult result) {

		if (result.hasErrors()) {
			return "employee";
		}

		employee.setUserName(getLoggedInUserName(model));
		employeeService.updateEmployee(employee);
		return "redirect:/list-employees";
	}

	@RequestMapping(value = "/add-employee", method = RequestMethod.POST)
	public String addEmployee(ModelMap model, @Valid Employee employee, BindingResult result) {

		if (result.hasErrors()) {
			return "employee";
		}

		employee.setUserName(getLoggedInUserName(model));
		employeeService.saveEmployee(employee);
		return "redirect:/list-employees";
	}
}
