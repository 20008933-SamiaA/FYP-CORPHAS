/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: FYP
 * Date created: 2022-May-01 17:15:50 
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
 * @author 20008933
 *
 */

@Entity
public class Package {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String pname;
	private String type;
	private double cost;
	private String information;
	private String description;
	
	@OneToMany(mappedBy="packages")
	private Set<Appointment> appt;
	
	@OneToMany(mappedBy="packages")
	private Set<PackageItem> pitems;
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getPname() {
		return pname;
	}
	

	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
