/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: FYP
 * Date created: 2022-May-04 02:33:06 
 * 
 */

package e62f.rabiatuladawiyah.fyp;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;






/**
 * @author 20008933
 *
 */
public interface PackageItem_Repository extends JpaRepository<PackageItem,Integer> {
	
	public List<PackageItem> findByPackages_Id(int id1);

	

	

}
