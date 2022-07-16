/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-Jan-11 12:46:44 am 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 20021900
 *
 */
@Controller
public class LoginController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/403")
	public String error(){
	return "403";

	}
}
