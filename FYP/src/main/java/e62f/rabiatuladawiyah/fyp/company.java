/**
 * 
 * I declare that this code was written by me, 20023609. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Lorraine Lee
 * Student ID: 20023609
 * Class: E62F
 * Date created: 2022-Apr-27 10:29:18 am 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author 20023609
 *
 */
@Entity
public class company {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
	@GenericGenerator(name = "hibernate_sequence", strategy = "e62f.rabiatuladawiyah.fyp.CompanyIdGenerator", parameters = {
			@Parameter(name = CompanyIdGenerator.VALUE_PREFIX_PARAMETER, value = "CORP"),
			@Parameter(name = CompanyIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })

	private String id;
	@NotEmpty(message = "name cannot be empty!")
	@Size(min = 3, max = 200, message = "name must be between 3 to 200 characters!")
	private String name;
	@NotEmpty(message = "name cannot be empty!")
	@Size(min = 3, max = 50, message = "HR name must be between 3 to 50 characters!")
	private String hr_name;
	/*
	 * @NotEmpty(message = "number cannot be empty!")
	 * 
	 * @Positive(message = "number must be positive!")
	 */
	private int num;
	@NotEmpty(message = "email cannot be empty!")
	private String email;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the hr_name
	 */
	public String getHr_name() {
		return hr_name;
	}

	/**
	 * @param hr_name the hr_name to set
	 */
	public void setHr_name(String hr_name) {
		this.hr_name = hr_name;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
