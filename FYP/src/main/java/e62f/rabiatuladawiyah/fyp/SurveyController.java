/**
 * 
 * I declare that this code was written by me, 20023609. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Lorraine Lee
 * Student ID: 20023609
 * Class: E62F
 * Date created: 2022-Jul-13 12:29:30 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class SurveyController {
	@Autowired
	private SurveyRepository surveyRepo;

	@Autowired
	private CorpUserRepository corpuserRepo;

	/*
	 * // add
	 * 
	 * @GetMapping("/survey/add") public String addSurvey(Model model) {
	 * model.addAttribute("survey", new Survey()); return "add_survey"; }
	 * 
	 * @PostMapping("/survey/save") public String saveCategory(Survey survey) {
	 * 
	 * surveyRepo.save(survey); return "redirect:/survey"; }
	 */

	@GetMapping("/response")
	public String viewAllResponse(Model model) {

		List<Survey> listSurvey = surveyRepo.findAll();
		model.addAttribute("listSurvey", listSurvey);
		return "view_response";
	}

	@GetMapping("/survey/start")
    public String StartSurvey(Model model) {

        model.addAttribute("survey", new Survey());
        return "Survey";
    }

	@PostMapping("/survey/save")
	public String saveSurvey(Survey survey) {

		surveyRepo.save(survey);
		return "redirect:/response";
	}

	// View single Question
	@GetMapping("/survey/{id}")
	public String viewSingleSurvey(@PathVariable("id") Integer id, Model model) {

		Survey survey = surveyRepo.getById(id);
		model.addAttribute("survey", survey);

		return "view_single_survey";
	}

}
