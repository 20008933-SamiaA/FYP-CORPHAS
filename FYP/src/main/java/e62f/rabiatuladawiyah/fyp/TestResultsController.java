/**
 * I declare that this code was written by me, 20018528. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Matthew Ong
 * Student ID: 20018528
 * Class: C372-1D-E62F-A
 * Date created: 2022-6ŒŽ-02 1:41:07 

 */
package e62f.rabiatuladawiyah.fyp;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TestResultsController {
	
	@Autowired
	private CounterStaffRepository counterstaffRepo;
	
	@Autowired
	private PackageRepository packageRepo;

	@Autowired
	private TestResultsRepository TRRepo;

	@Autowired
	private CorpUserRepository corpuserRepo;

	@Autowired
	private AppointmentRepository apptRepo;
	
	@Autowired
	private ItemRepository ItemRepo;
	


	@GetMapping(path = "/testresults/appt/{id}") // Pitems in package 1
	public String viewtestresults(@PathVariable String id, Model model) {
    	//Appointment appointment= apptRepo.getById(id);
    	List<TestResults> trlist = TRRepo.findByAppointmentApptid(id);
    	
    	model.addAttribute("trList", trlist); // add it to the model
		return "view_testresults"; // view the package items	
	}

	
	
	@GetMapping("/testresults/add/{id}") // Add items in a specific Package
	public String addTestResult(@PathVariable String id, Model model) {

		model.addAttribute("test_results", new TestResults()); 
		model.addAttribute("appointment", new Appointment()); 
		
		Appointment lista = apptRepo.getById(id); // Get Package Id
		model.addAttribute("listA", lista);

		List<Item> listI = ItemRepo.findAll();
		model.addAttribute("listI", listI);

		return "add_testresults";
	}

	@PostMapping("/testresults/save")
	public String saveTestResult(TestResults test_results) {
		TestResults saved = TRRepo.save(test_results);
		return "redirect:/testresults/add/" +saved.getAppointment().getApptid();
	}
	
	
	@GetMapping("/testresults/edit/{id}") // Add items in a specific Package
	public String editTestResult(@PathVariable Integer id, Model model) {

		TestResults test_results = TRRepo.getById(id);
		model.addAttribute("test_results", test_results);
		
		List<Appointment> listA = apptRepo.findAll();
		model.addAttribute("listA", listA);
	
		List<Item> listI = ItemRepo.findAll();
		model.addAttribute("listI", listI);
		
		
		return "edit_testresults";
	}

	@PostMapping("/testresults/edit/{id}")
	public String saveUpdatedTestResult(@PathVariable Integer id,TestResults test_results) {

		TestResults saved = TRRepo.save(test_results);
		return "redirect:/testresults/appt/" + saved.getAppointment().getApptid();

	}


}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
