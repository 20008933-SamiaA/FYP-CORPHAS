/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 

 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-04 4:09:54 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author 20021900
 *
 */
@Entity
public class TestResults {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}



	@ManyToOne
	@JoinColumn(name = "appointment_apptid", nullable = false)
	private Appointment appointment;

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Item items;

	public Item getItems() {
		return items;
	}

	public void setItems(Item items) {
		this.items = items;
	}


}
