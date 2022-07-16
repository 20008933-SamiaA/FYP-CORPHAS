/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-04 1:56:15 pm 
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
public class CounterStaffController {
		@Autowired
		private CounterStaffRepository counterstaffRepository;
		private TestResultsRepository testresultsRepository;

		@GetMapping("/counterstaff")
		public String viewEmployee(Model model) {

			List<CounterStaff> listCounterStaff = counterstaffRepository.findAll();
			model.addAttribute("listCounterStaff", listCounterStaff);
			return "view_counterstaff";

		}

		// add
		@GetMapping("/counterstaff/add")
		public String addCounterStaff(Model model) {
			model.addAttribute("counterstaff", new CounterStaff());
			return "add_counterstaff";
		}

		@PostMapping("/counterstaff/save")
		public String saveCategory(CounterStaff counterstaff) {

			counterstaffRepository.save(counterstaff);
			return "redirect:/counterstaff";
		}

		// edit

		@GetMapping("/counterstaff/edit/{id}")
		public String editCategory(@PathVariable("id") String id, Model model) {

			CounterStaff counterstaff = counterstaffRepository.getById(id);
			model.addAttribute("counterstaff", counterstaff);

			return "edit_counterstaff";
		}

		@PostMapping("/counterstaff/edit/{id}")
		public String saveUpdatedCounterStaff(@PathVariable("id") String id, CounterStaff counterstaff) {

			counterstaffRepository.save(counterstaff);
			return "redirect:/counterstaff";
		}

		// delete

		@GetMapping("/counterstaff/delete/{id}")
		public String deleteEmployee(@PathVariable("id") String id) {

			counterstaffRepository.deleteById(id);

			return "redirect:/counterstaff";
		}

		}

	
