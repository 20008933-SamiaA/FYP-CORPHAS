/**
 * 
 * I declare that this code was written by me, 20023609. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Lorraine Lee
 * Student ID: 20023609
 * Class: E62F
 * Date created: 2022-Jul-13 12:04:53 pm 
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

/**
 * @author 20023609
 *
 */
@Entity
public class Survey {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int surveyId;
	private String employeeId;
	private String title;
	private String nric;
	private String age;
	private String gender;
	private String smoke;
	private String sleep;
	private String troubleSleeping;
	private String stress;
	private String CauseOfStress;

	/**
	 * @return the surveyId
	 */
	public int getSurveyId() {
		return surveyId;
	}

	/**
	 * @param surveyId the surveyId to set
	 */
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the nric
	 */
	public String getNric() {
		return nric;
	}

	/**
	 * @param nric the nric to set
	 */
	public void setNric(String nric) {
		this.nric = nric;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the smoke
	 */
	public String getSmoke() {
		return smoke;
	}

	/**
	 * @param smoke the smoke to set
	 */
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}

	/**
	 * @return the sleep
	 */
	public String getSleep() {
		return sleep;
	}

	/**
	 * @param sleep the sleep to set
	 */
	public void setSleep(String sleep) {
		this.sleep = sleep;
	}

	/**
	 * @return the troubleSleeping
	 */
	public String getTroubleSleeping() {
		return troubleSleeping;
	}

	/**
	 * @param troubleSleeping the troubleSleeping to set
	 */
	public void setTroubleSleeping(String troubleSleeping) {
		this.troubleSleeping = troubleSleeping;
	}

	/**
	 * @return the stress
	 */
	public String getStress() {
		return stress;
	}

	/**
	 * @param stress the stress to set
	 */
	public void setStress(String stress) {
		this.stress = stress;
	}

	/**
	 * @return the causeOfStress
	 */
	public String getCauseOfStress() {
		return CauseOfStress;
	}

	/**
	 * @param causeOfStress the causeOfStress to set
	 */
	public void setCauseOfStress(String causeOfStress) {
		CauseOfStress = causeOfStress;
	}

}
