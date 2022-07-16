/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-04 1:18:34 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 20021900
 *
 */
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeTypeRepository emptypeRepo;
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public String viewEmployee(Model model, @Param("keyword") String keyword) {

		List<Employee> listEmployee = employeeService.getAllPackages(keyword);
		model.addAttribute("listEmployee", listEmployee);
		model.addAttribute("keyword", keyword);
		return "view_employee";

	}

	// add
	@GetMapping("/employee/add")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		List <EmployeeType> emptypeList = emptypeRepo.findAll();
		//Add the categories to the model
		model.addAttribute("listEmptype",emptypeList);
		return "add_employee";
	}

	@PostMapping("/employee/save")
	public String saveCategory(Employee employee) {

		employeeRepository.save(employee);
		return "redirect:/employee";
	}

	// edit

	@GetMapping("/employee/edit/{id}")
	public String editCategory(@PathVariable("id") String id, Model model) {

		Employee employee = employeeRepository.getById(id);
		List <EmployeeType> emptypeList = emptypeRepo.findAll();
		model.addAttribute("listEmptype",emptypeList);
		model.addAttribute("employee", employee);

		return "edit_employee";
	}

	@PostMapping("/employee/edit/{id}")
	public String saveUpdatedEmployee(@PathVariable("id") String  id, Employee employee) {
		employeeRepository.save(employee);
		return "redirect:/employee";
	}

	// delete

	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(@PathVariable("id") String  id) {

		employeeRepository.deleteById(id);

		return "redirect:/employee";
	}

}
