package e62f.rabiatuladawiyah.fyp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "HomePage";
	}
	@GetMapping("/home")
	public String index() {
		return "index";
	}
	@GetMapping("/contactus")
	public String ContactUs() {
		return "contactus";
	}
	@GetMapping("/aboutus")
	public String AboutUs() {
		return "aboutus";
	}
	
	}


