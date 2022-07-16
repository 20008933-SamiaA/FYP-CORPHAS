/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-07 3:35:16 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;





/**
 * @author 20021900
 *
 */
public interface AppointmentRepository extends JpaRepository<Appointment,String>{
	public List<Appointment> findByPackages_Id(int id);

	  public List<Appointment> findByCorpuserId(int id); 
}
