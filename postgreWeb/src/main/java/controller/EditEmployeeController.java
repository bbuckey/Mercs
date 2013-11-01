package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.EmployeeEntity;
import imanager.EmployeeManager;

@Controller
public class EditEmployeeController {
	
	    private EmployeeManager employeeManager;
   
	    @RequestMapping(value = "/postgreWeb", method = RequestMethod.GET)
	    public String listEmployees(ModelMap map)
	    {
	    	map.addAttribute("employee", new EmployeeEntity());
	        map.addAttribute("employeeList", employeeManager.getAllEmployees()!= null ? employeeManager.getAllEmployees() : null);
	 
	        return "editEmployeeList";
	    }
	    
  
	    @RequestMapping(value = "/add", method = RequestMethod.POST)
	    public String addEmployee(@ModelAttribute("employee") EmployeeEntity employee, BindingResult result)
	    {	
	        employeeManager.addEmployee(employee);
	        return "redirect:/postgreWeb";
	    }
	 
	    @RequestMapping("/delete/{employeeId}")
	    public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId)
	    {
	        employeeManager.deleteEmployee(employeeId);
	        return "redirect:/postgreWeb";
	    }
	 
	    @Autowired
	    public void setEmployeeManager(EmployeeManager employeeManager) {
	        this.employeeManager = employeeManager;
	    }
	    
	    public EmployeeManager getEmployeeManager(){
	    	return this.employeeManager;
	    }
}
