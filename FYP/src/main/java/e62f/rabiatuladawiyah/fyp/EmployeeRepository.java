/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-04 1:24:41 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * @author 20021900
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, String> {
	
	public Employee findByName(String name);


	 @Query("SELECT employee FROM Employee employee WHERE employee.name LIKE %?1%" 
	 + " OR employee.emptype.emptype LIKE %?1%" 
	 + " OR employee.nric LIKE %?1%" 
	 + " OR employee.id LIKE %?1%"
)

	 public List <Employee> findAll(String keyword);
}
