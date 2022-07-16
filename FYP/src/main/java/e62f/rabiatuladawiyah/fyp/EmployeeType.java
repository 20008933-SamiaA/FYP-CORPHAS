/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-11 11:06:25 am 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author 20021900
 *
 */
@Entity
public class EmployeeType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String emptype;
	
	@OneToMany(mappedBy="emptype")
	private Set<Appointment> appt;
	
	@OneToMany(mappedBy="emptype")
	private Set<Employee> emp;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmptype() {
		return emptype;
	}
	
	public void setEmptype(String emptype) {
		this.emptype = emptype;
	}
	

}
