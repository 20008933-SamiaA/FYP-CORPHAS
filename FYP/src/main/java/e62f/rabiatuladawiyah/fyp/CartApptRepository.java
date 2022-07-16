/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-Jan-24 6:55:16 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartApptRepository extends JpaRepository<CartAppt, Integer> {
	public List<CartAppt> findByCorpuserId(int id);

	public CartAppt findByCorpuserIdAndAppt_Apptid(int CorpuserId, String apptId);



}