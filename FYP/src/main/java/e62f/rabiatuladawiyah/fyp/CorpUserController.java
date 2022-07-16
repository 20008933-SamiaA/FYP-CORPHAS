/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-06 1:52:47 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author 20021900
 *
 */
@Controller
public class CorpUserController {
		@Autowired
		private CorpUserRepository corpuserRepository;
		@GetMapping("/users")
		public String viewMembers(Model model) {

			List<CorpUser> listUser= corpuserRepository.findAll();
			model.addAttribute("listUser", listUser);
			return "view_user";

		}
		// add
		@GetMapping("/users/add")
		public String addCategory(Model model) {
			model.addAttribute("user", new CorpUser());
			return "add_user";
		}
		@PostMapping("/users/save")
		public String saveUser(CorpUser user,RedirectAttributes redirectAttribute) {
			BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
			String encodedPassword=passwordEncoder.encode(user.getPassword());
			
			user.setPassword(encodedPassword);
			user.setRole("ROLE_USER");

			corpuserRepository.save(user);
			redirectAttribute.addFlashAttribute("success","User registered!");
			return "redirect:/home";
		}
		@GetMapping("/users/add/hr")
		public String addHR(Model model) {
			model.addAttribute("user", new CorpUser());
			return "add_hr";
		}
		@PostMapping("/hr/save")
		public String saveHR(CorpUser user,RedirectAttributes redirectAttribute) {
			BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
			String encodedPassword=passwordEncoder.encode(user.getPassword());
			
			user.setPassword(encodedPassword);
			user.setRole("ROLE_HR");

			corpuserRepository.save(user);
			redirectAttribute.addFlashAttribute("success","HR registered!");
			return "redirect:/home";
		}
		@GetMapping("/users/add/cs")
		public String addCS(Model model) {
			model.addAttribute("user", new CorpUser());
			return "add_cs";
		}
		@PostMapping("/cs/save")
		public String saveCS(CorpUser user,RedirectAttributes redirectAttribute) {
			BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
			String encodedPassword=passwordEncoder.encode(user.getPassword());
			
			user.setPassword(encodedPassword);
			user.setRole("ROLE_COUNTERSTAFF");

			corpuserRepository.save(user);
			redirectAttribute.addFlashAttribute("success","COUNTERSTAFF registered!");
			return "redirect:/home";
		}
		@GetMapping("/users/edit/{id}")
		public String editUser(@PathVariable("id") Integer id, Model model) {

			CorpUser user = corpuserRepository.getById(id);
			model.addAttribute("user", user);

			return "edit_user";
		}
		@PostMapping("/users/edit/{id}")
		public String saveUpdatedUser(@PathVariable("id") Integer id, CorpUser user,RedirectAttributes redirectAttribute) {
			BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
			String encodedPassword=passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			corpuserRepository.save(user);
			return "redirect:/users";
		}

		// delete

		@GetMapping("/users/delete/{id}")
		public String deleteMember(@PathVariable("id") Integer id) {

			corpuserRepository.deleteById(id);
		

			return "redirect:/users";
		}

	}

