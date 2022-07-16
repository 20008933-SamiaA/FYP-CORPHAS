/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-Jun-07 11:30:43 am 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 20021900
 *
 */
@Service
public class EmployeeService {
	 @Autowired
	 private EmployeeRepository employeeRepository;

	 public List<Employee> getAllPackages(String keyword){
		 if(keyword != null) {
			 return employeeRepository.findAll(keyword); //List<Package> list =  (List<Package>)repository.findAll();
		 }

		  return employeeRepository.findAll();
		 }
		 
}



