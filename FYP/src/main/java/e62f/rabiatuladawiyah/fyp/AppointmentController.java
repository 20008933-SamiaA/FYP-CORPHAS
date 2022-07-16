/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-07 2:46:29 pm 
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
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author 20021900
 *
 */
@Controller
public class AppointmentController {
	@Autowired
	private AppointmentRepository apptRepo;
	@Autowired
	private PackageRepository packageRepo;
	@Autowired
	private EmployeeTypeRepository emptypeRepo;
	@Autowired
	private TimeScheduleRepository timeschRepo;
	
	@Autowired
	private CorpUserRepository corpuserRepo;

    @GetMapping("/appt")
	public String viewAppointment(Model model) {
    	
    	//Retrieve all categories from db
		List <Appointment> apptList = apptRepo.findAll();
		//Add the categories to the model
		model.addAttribute("listAppointment",apptList);
		//return the response as view 
		return "view_appt";
	}
    @GetMapping("/appt2")
	public String viewAppointmentUser(Model model) {
    	
    	//Retrieve all categories from db
		List <Appointment> apptList = apptRepo.findAll();
		//Add the categories to the model
		model.addAttribute("listAppointment",apptList);
		//return the response as view 
		return "view_appt2";
	}
    @GetMapping("/appt/add")
    public String addAppt(Model model,  Principal principal) {
    	 CorpUserDetails loggedInMember = (CorpUserDetails) SecurityContextHolder.getContext().getAuthentication()
 	            .getPrincipal();
 	        int loggedInMemberId = loggedInMember.getUser().getId();
     
    	model.addAttribute("appointment", new Appointment());
		CorpUser user = corpuserRepo.getById(loggedInMemberId);
		model.addAttribute("",user);
    	
    	List <Package> packageList = packageRepo.findAll();
		//Add the package to the model
		model.addAttribute("listPackage",packageList);

		
		List <EmployeeType> emptypeList = emptypeRepo.findAll();
		//Add the categories to the model
		model.addAttribute("listEmptype",emptypeList);
		
		List <TimeSchedule> timeschList = timeschRepo.findAll();
		model.addAttribute("listTimeSchedule",timeschList);
		//return the response as view 
    	return "add_appt";
    }
    @PostMapping("/appt/save")
    public String saveAppt(Appointment appointment) {
    	 CorpUserDetails loggedInMember = (CorpUserDetails) SecurityContextHolder.getContext().getAuthentication()
  	            .getPrincipal();
  	        int loggedInMemberId = loggedInMember.getUser().getId();
      
    	CorpUser corpUser = corpuserRepo.getById(loggedInMemberId);
    	appointment.setCorpuser(corpUser);
    	apptRepo.save(appointment);
    	return"redirect:/screenadvisory";
    }
    @GetMapping("/appt/edit/{id}")
    public String editAppt(@PathVariable("id")String id, Model model) {
    	Appointment appointment= apptRepo.getById(id);
       	
    	List <Package> packageList = packageRepo.findAll();
		//Add the package to the model
		model.addAttribute("listPackage",packageList);
		//return the response as view 
		
		List <EmployeeType> emptypeList = emptypeRepo.findAll();
		model.addAttribute("listEmptype",emptypeList);
		List <TimeSchedule> timeschList = timeschRepo.findAll();
		model.addAttribute("listTimeSchedule",timeschList);
		//Add the categories to the model
	

    	model.addAttribute("appointment",appointment);
    	return "edit_appt";
    }
    @PostMapping("/appt/edit/{id}")
    public String saveUpdatedAppt(@PathVariable("id") String id , Appointment appointment) {
   apptRepo.save(appointment);
    return"redirect:/appt";
}
    @GetMapping("/appt/reschedule/{id}")
    public String rsAppt(@PathVariable("id")String id, Model model) {
    	Appointment appointment= apptRepo.getById(id);
       	
    	List <Package> packageList = packageRepo.findAll();
		//Add the package to the model
		model.addAttribute("listPackage",packageList);
		//return the response as view 
		
		List <EmployeeType> emptypeList = emptypeRepo.findAll();
		model.addAttribute("listEmptype",emptypeList);
		List <TimeSchedule> timeschList = timeschRepo.findAll();
		model.addAttribute("listTimeSchedule",timeschList);
		//Add the categories to the model
	

    	model.addAttribute("appointment",appointment);
    	return "resedule_appt";
    }

@PostMapping("/appt/reschedule/{id}")
public String saveReschedule(@PathVariable("id") String id , Appointment appointment) {
apptRepo.save(appointment);
return"redirect:/appt";
}
 @GetMapping("/appt/delete/{id}")
 public String deleteCategory(@PathVariable("id") String id ){
	 apptRepo.deleteById(id);
	 return"redirect:/appt";
 }
	@GetMapping("/screenadvisory")
	public String screenadvisory() {
		return "screenadvisory";
	}
	@GetMapping("/appt/{id}")
	public String viewSingleAppt(@PathVariable("id")String id, Model model) {
		Appointment appt = apptRepo.getById(id);
		model.addAttribute("appt",appt);
		return "view_single_appt";
		
	}
	  @GetMapping("/viewappt/user")
	  public String viewBookedAppointmentUser(Model model) {
		  // Get currently logged in user
		    CorpUserDetails loggedInMember = (CorpUserDetails) SecurityContextHolder.getContext().getAuthentication()
			        .getPrincipal();
			    int loggedInMemberId = loggedInMember.getUser().getId();
			    // Get order items purchased by this user
			    List<Appointment> orderItemList= apptRepo.findByCorpuserId(loggedInMemberId);
			    // Add the order items to the model model.addAttribute
				  model.addAttribute("orderItemList",orderItemList);
				  System.out.println("size" + orderItemList.size());
				  return"orderhistorycustomer" ;
	  }



}


