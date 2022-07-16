/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-04 4:15:56 pm 
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
public interface TestResultsRepository extends JpaRepository<TestResults, Integer>  {

	//public List<TestResults> findByCorpuserId(int id);

	//public TestResults findByCorpuserIdAndItemId(int loggedInCorpUserId, int itemId);
	
	
	//public TestResults findByCorpuserIdAndPackageId(int loggedInCorpUserId, int packageId);

	/**
	 * @param id
	 * @return
	 */
	public List<TestResults> findByAppointmentApptid(String apptId);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
