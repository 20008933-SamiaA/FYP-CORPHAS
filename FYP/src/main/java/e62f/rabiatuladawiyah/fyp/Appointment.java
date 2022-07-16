/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-07 12:54:40 am 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * @author 20021900
 *
 */
@Entity
/*
 * @Table(name = "appointment")
 * 
 * @SQLDelete(sql = "UPDATE appointment SET deleted = true WHERE id=apptid")
 * 
 * @Where(clause = "deleted=false")
 */
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
	@GenericGenerator(name = "hibernate_sequence", strategy = "e62f.rabiatuladawiyah.fyp.AppointmentIdGenerator", parameters = {
			@Parameter(name = AppointmentIdGenerator.VALUE_PREFIX_PARAMETER, value = "APPT"),
			@Parameter(name = AppointmentIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	
	private String apptid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private LocalTime time;
	private String location;
	private String status;
	private String corporateid;
    private String employeeid;
	private String doctor;
	private String name;


	@ManyToOne
	@JoinColumn(name = "corpuser_id")
	private CorpUser corpuser;
	
	@ManyToOne
	@JoinColumn(name="package_id",nullable=false)
	private Package packages;
	
	@ManyToOne
	@JoinColumn(name="emptype_id",nullable=false)
	private EmployeeType emptype;
	
	@ManyToOne
	@JoinColumn(name="timeschedule_id",nullable=false)
	private TimeSchedule timesch;
	
	@OneToMany(mappedBy="appointment")
	private Set<TestResults> testresults;
	
	

	public TimeSchedule getTimesch() {
		return timesch;
	}


	public void setTimesch(TimeSchedule timesch) {
		this.timesch = timesch;
	}

	public EmployeeType getEmptype() {
		return emptype;
	}

	public void setEmptype(EmployeeType emptype) {
		this.emptype = emptype;
	}

	public Package getPackages() {
		return packages;
	}
	public void setPackages(Package packages) {
		this.packages = packages;
	}

	public String getApptid() {
		return apptid;
	}

	public void setApptid(String apptid) {
		this.apptid = apptid;
	}



	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getCorporateid() {
		return corporateid;
	}

	
	public void setCorporateid(String corporateid) {
		this.corporateid = corporateid;
	}


	public LocalDate getDate() {
		return date;
	}

	

	public void setDate(LocalDate date) {
		this.date = date;
	}


	public LocalTime getTime() {
		return time;
	}


	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	
	public String getEmployeeid() {
		return employeeid;
	}


	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
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
	 * @return the corpuser
	 */
	public CorpUser getCorpuser() {
		return corpuser;
	}

	/**
	 * @param corpuser the corpuser to set
	 */
	public void setCorpuser(CorpUser corpuser) {
		this.corpuser = corpuser;
	}
	
	
	
	

}
