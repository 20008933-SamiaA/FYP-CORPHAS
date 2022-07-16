/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-Jul-07 3:35:42 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author 20021900
 *
 */
@Entity
public class TimeSchedule {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id; 
	private String time;
	
	@OneToMany(mappedBy="timesch")
	private Set<Appointment> appt;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

}
