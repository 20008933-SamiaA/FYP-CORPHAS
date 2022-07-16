/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: FYP
 * Date created: 2022-May-02 01:09:23 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author 20008933
 *
 */
public interface PackageRepository extends JpaRepository<Package, Integer> {

	List<Package> findByid(Integer id);
	
	List<Package> findByPnameContaining(String pname);
	 
	 
	 @Query("SELECT package FROM Package package WHERE package.pname LIKE %?1%" 
	 + " OR package.type LIKE %?1%"
	 + " OR package.cost LIKE %?1%"
	 + " OR package.information LIKE %?1%")
	 public List <Package> findAll(String keyword);
	 
	 
	 
	 

}
