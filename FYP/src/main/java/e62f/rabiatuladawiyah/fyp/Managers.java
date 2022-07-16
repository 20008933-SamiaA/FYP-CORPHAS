/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-25 2:56:06 am 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * @author 20021900
 *
 */
@Entity
@Table(name = "manager")
@SQLDelete(sql = "UPDATE manager SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Managers {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
	@GenericGenerator(name = "hibernate_sequence", strategy = "e62f.rabiatuladawiyah.fyp.ManagerIdGenerator", parameters = {
			@Parameter(name = CompanyIdGenerator.VALUE_PREFIX_PARAMETER, value = "MAN"),
			@Parameter(name = CompanyIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	
	private String id; 
	private String name;
	private String department;
	 private boolean deleted = Boolean.FALSE;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	

}
