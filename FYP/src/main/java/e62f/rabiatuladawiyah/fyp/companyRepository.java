/**
 * 
 * I declare that this code was written by me, 20023609. 

 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Lorraine Lee
 * Student ID: 20023609
 * Class: E62F
 * Date created: 2022-Apr-27 10:42:11 am 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author 20023609
 *
 */
public interface companyRepository extends JpaRepository<company, String> {
	List<company> findBynameContaining(String name);

	@Query("SELECT company FROM company company WHERE company.name LIKE %?1%" + " OR company.hr_name LIKE %?1%"
			+ " OR company.num LIKE %?1%" + " OR company.email LIKE %?1%")
	public List<company> findAll(String keyword);
}
