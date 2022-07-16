/**
 * 
 * I declare that this code was written by me, 20023609. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Lorraine Lee
 * Student ID: 20023609
 * Class: E62F
 * Date created: 2022-Jun-07 5:27:46 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 20023609
 *
 */
@Service
public class CompanyService {
	 @Autowired
	 private companyRepository companyRepo;

	 public List<company> getAllCompany(String keyword){
		 if(keyword != null) {
			 return companyRepo.findAll(keyword); //List<Package> list =  (List<Package>)repository.findAll();
		 }

		  return companyRepo.findAll();
		 }
}
