/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-25 11:15:44 am 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ManagerController {
	@Autowired
	private ManagerRepository managerRepo;
	

	@GetMapping("/managers")
	public String viewEmployee(Model model) {

		List<Managers> listManagers = managerRepo.findAll();
		model.addAttribute("listManagers", listManagers);
		return "view_managers";

	}

	// add
	@GetMapping("/managers/add")
	public String addManagers(Model model) {
		model.addAttribute("managers", new Managers());
		return "add_managers";
	}

	@PostMapping("/managers/save")
	public String saveCategory(Managers managers) {

		managerRepo.save(managers);
		return "redirect:/managers";
	}

	// edit

	@GetMapping("/managers/edit/{id}")
	public String editCategory(@PathVariable("id") String id, Model model) {

		Managers managers = managerRepo.getById(id);
		model.addAttribute("managers", managers);

		return "edit_managers";
	}

	@PostMapping("/managers/edit/{id}")
	public String saveUpdatedEmployee(@PathVariable("id") String id, Managers managers) {

		managerRepo.save(managers);
		return "redirect:/managers";
	}

	// delete

	@GetMapping("/managers/delete/{id}")
	public String deleteEmployee(@PathVariable("id") String id) {

		managerRepo.deleteById(id);

		return "redirect:/managers";
	}

}



