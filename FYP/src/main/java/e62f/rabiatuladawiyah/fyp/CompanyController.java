/**
 * 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Lorraine Lee
 * Student ID: 20023609
 * Class: E62F
 * Date created: 2021-Nov-16 3:47:26 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 20023609
 *
 */
@Controller
public class CompanyController {

	@Autowired
	private companyRepository comRepo;
	@Autowired
	private CompanyService comservice;


	@GetMapping("/ga")
	public String gaHomePage() {
		return "gaHomePage";
	}

	@GetMapping("/company")
	public String Company(Model model, @Param("keyword") String keyword) {
		List<company> listcompany = comservice.getAllCompany(keyword);
		model.addAttribute("listcompany", listcompany);
		model.addAttribute("keyword", keyword);

		return "company";
	}

	@GetMapping("/company/add")
	public String addCompany(Model model) {
		model.addAttribute("company", new company());
		return "add_company";
	}

	@PostMapping("/company/save")
	public String saveCompany(@Valid company company) {
		comRepo.save(company);
		return "redirect:/company";
	}

	@GetMapping("/company/edit/{id}")
	public String editCategory(@PathVariable("id") String id, Model model) {

		company company = comRepo.getById(id);
		model.addAttribute("company", company);

		return "edit_company";
	}

	@PostMapping("/company/edit/{id}")
	public String saveUpdatedCompany(@PathVariable("id") String id, company company) {

		comRepo.save(company);
		return "redirect:/company";
	}

	// delete

	@GetMapping("/company/delete/{id}")
	public String deleteCategory(@PathVariable("id") String id) {

		comRepo.deleteById(id);

		return "redirect:/company";
	}

}
