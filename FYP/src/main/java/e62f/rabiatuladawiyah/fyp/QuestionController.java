/**
 * 
 * I declare that this code was written by me, 20023609. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Lorraine Lee
 * Student ID: 20023609
 * Class: E62F
 * Date created: 2022-Jun-03 11:23:17 am 
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
 * @author 20023609
 *
 */
@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository qRepo;

	@GetMapping("/questions")
	public String viewQuestions(Model model) {

		List<Question> listQuestions = qRepo.findAll();
		model.addAttribute("listQuestion", listQuestions);
		return "view_questions";
	}

	// add
	@GetMapping("/questions/add")
	public String addQuestion(Model model) {
		model.addAttribute("question", new Question());
		return "add_question";
	}

	@PostMapping("/questions/save")
	public String saveCategory(Question question) {

		qRepo.save(question);
		return "redirect:/questions";
	}

	// View single Question
	@GetMapping("/questions/{id}")
	public String viewSingleQuestions(@PathVariable("id") Integer id, Model model) {

		Question question = qRepo.getById(id);
		model.addAttribute("question", question);

		return "view_single_question";
	}

	@GetMapping("/questions/edit/{id}")
	public String editQuestion(@PathVariable("id") Integer id, Model model) {

		Question question = qRepo.getById(id);
		model.addAttribute("question", question);

		return "edit_question";
	}

	@PostMapping("/questions/edit/{id}")
	public String saveUpdatedQuestions(@PathVariable("id") Integer id, Question question) {

		qRepo.save(question);
		return "redirect:/questions";
	}

	// delete

	@GetMapping("/questions/delete/{id}")
	public String deleteQuestions(@PathVariable("id") int id) {

		qRepo.deleteById(id);

		return "redirect:/questions";
	}
}
