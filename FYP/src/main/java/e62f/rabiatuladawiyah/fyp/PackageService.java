/**
 * I declare that this code was written by me, 20018528. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Matthew Ong
 * Student ID: 20018528
 * Class: C372-1D-E62F-A
 * Date created: 2022-6ŒŽ-01 15:01:07 

 */
package e62f.rabiatuladawiyah.fyp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 20018528
 *
 */

@Service
public class PackageService {
	 @Autowired
	 private PackageRepository packageRepo;

	 public List<Package> getAllPackages(String keyword){
		 if(keyword != null) {
			 return packageRepo.findAll(keyword); //List<Package> list =  (List<Package>)repository.findAll();
		 }

		  return packageRepo.findAll();
		 }
		 
}
