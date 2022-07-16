/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-21 3:17:01 pm 
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
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private MaritalStatusRepository msRepo;

	@GetMapping("/patients")
	public String viewEmployee(Model model) {

		List<Patient> listPatient =  patientRepository.findAll();
		model.addAttribute("listPatient", listPatient);
		return "view_patients";

	}

	// add
	@GetMapping("/patients/add")
	public String addEmployee(Model model) {
		model.addAttribute("patient", new Patient());
		
		
		  List <MaritalStatus> msList = msRepo.findAll();
		  model.addAttribute("listms",msList);
		 
		return "add_patient";
	}

	@PostMapping("/patients/save")
	public String saveCategory(Patient patient) {

		patientRepository.save(patient);
		return "redirect:/patients";
	}

	// edit

	@GetMapping("/patients/edit/{id}")
	public String editCategory(@PathVariable("id") String id, Model model) {

		Patient patient = patientRepository.getById(id);
		  List <MaritalStatus> msList = msRepo.findAll(); //Add the package to the model 
		  model.addAttribute("listms",msList);
		model.addAttribute("patient",patient);

		return "edit_patients";
	}

	@PostMapping("/patients/edit/{id}")
	public String saveUpdatedEmployee(@PathVariable("id") String  id, Patient patient) {
		patientRepository.save(patient);
		return "redirect:/patients";
	}

	// delete

	@GetMapping("/patients/delete/{id}")
	public String deleteEmployee(@PathVariable("id") String  id) {

		patientRepository.deleteById(id);

		return "redirect:/patients";
	}

}


