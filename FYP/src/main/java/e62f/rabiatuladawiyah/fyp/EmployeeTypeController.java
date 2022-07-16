/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: FYP
 * Date created: 2022-May-02 01:16:59 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 20008933
 *
 */


@Controller
public class EmployeeTypeController {

	@Autowired
	private EmployeeTypeRepository emptypeRepo;
	
	@GetMapping("/emptype")
	public String viewPackage(Model model) {
		
		
		List<EmployeeType> listEmptype = emptypeRepo.findAll();
		
		model.addAttribute("listEmptype", listEmptype);
		return "view_emptype";
		}
	
	
		
//		@GetMapping("/packages/add")
//		
//		public String addPackage(Model model) {
//			model.addAttribute("package", new Package());
//			return "add_package";
//		}
//		
//		@PostMapping("/packages/save")
//		public String savePackage(Package packages) {
//			packageRepo.save(packages);
//			
//			return "redirect:/packages";
			
		}
		
		

	

