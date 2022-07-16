/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-Jul-16 12:06:12 am 
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
public class MaritalStatus {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id; 
private String ms;


 @OneToMany(mappedBy="ms")
 private Set<Patient> patient;
 

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getMs() {
	return ms;
}

public void setMs(String ms) {
	this.ms = ms;
}

}
