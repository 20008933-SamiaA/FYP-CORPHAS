/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-21 3:15:01 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "patient")
@SQLDelete(sql = "UPDATE patient SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
	@GenericGenerator(name = "hibernate_sequence", strategy = "e62f.rabiatuladawiyah.fyp.AppointmentIdGenerator", parameters = {
			@Parameter(name = AppointmentIdGenerator.VALUE_PREFIX_PARAMETER, value = "PATIENT"),
			@Parameter(name = AppointmentIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })

	private String id;
	private String firstName;
	private String lastName;
	private String DOB;
	private String sex;
	private int contactNo;
	private String email;
	private int econtactNo;
	private String rs;
	private String streetAddr;
	private int postalCode;
	private String medicalCondition;
	private String nric;
	private boolean deleted = Boolean.FALSE;
	@ManyToOne
	@JoinColumn(name = "maritalstatus_id", nullable = false)
	private MaritalStatus ms;
	
	


	public MaritalStatus getMs() {
		return ms;
	}

	
	public void setMs(MaritalStatus ms) {
		this.ms = ms;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEcontactNo() {
		return econtactNo;
	}

	public void setEcontactNo(int econtactNo) {
		this.econtactNo = econtactNo;
	}

	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	public String getStreetAddr() {
		return streetAddr;
	}

	public void setStreetAddr(String streetAddr) {
		this.streetAddr = streetAddr;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}


	public String getMedicalCondition() {
		return medicalCondition;
	}

	public void setMedicalCondition(String medicalCondition) {
		this.medicalCondition = medicalCondition;
	}


	public String getNric() {
		return nric;
	}


	public void setNric(String nric) {
		this.nric = nric;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}



}
