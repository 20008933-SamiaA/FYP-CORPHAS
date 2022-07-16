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
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 20008933
 *
 */


@Controller
public class PackageController {

	@Autowired
	private PackageRepository packageRepo;
	
	@Autowired
	private PackageService packageService;
	
	
	//only made changes to this method
	@GetMapping("/packages")
	public String viewPackage(Model model, @Param("keyword") String keyword) {
		
		List<Package> listPackages = packageService.getAllPackages(keyword);
		
		model.addAttribute("listPackages", listPackages);
		model.addAttribute("keyword", keyword);
		return "view_packages";
		}
	
	
		
		@GetMapping("/packages/add")
		
		public String addPackage(Model model) {
			model.addAttribute("package", new Package());
			return "add_package";
		}
		
		@PostMapping("/packages/save")
		public String savePackage(Package packages) {
			packageRepo.save(packages);
			
			return "redirect:/packages";
			
		}
		
		@GetMapping("/packages/edit/{id}")
		public String editCategory(@PathVariable("id") Integer id, Model model) {

			Package packages = packageRepo.getById(id);
			model.addAttribute("package", packages);

			return "edit_packages";
		}

		@PostMapping("/packages/edit/{id}")
		public String saveUpdatedCategory(@PathVariable("id") Integer id, Package packages) {

			packageRepo.save(packages);
			return "redirect:/packages";
		}

		@GetMapping("/packages/delete/{id}")
		public String deletePackage(@PathVariable("id") Integer id) {
			packageRepo.deleteById(id);
			return "redirect:/packages";
		}
		

	
		
		

	
}
