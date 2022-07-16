/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-04 1:55:38 pm 
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
@Table(name = "counter_staff")
@SQLDelete(sql = "UPDATE counter_staff SET deleted = true WHERE counterid=?")
@Where(clause = "deleted=false")
public class CounterStaff {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence_count")
	@GenericGenerator(name = "hibernate_sequence_count", strategy = "e62f.rabiatuladawiyah.fyp.CounterIdGenerator", parameters = {
			@Parameter(name = CounterIdGenerator.VALUE_PREFIX_PARAMETER, value = "COUNT"),
			@Parameter(name = CounterIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String counterid;
	private int counterNo;
	private String details;
	private boolean deleted = Boolean.FALSE;
	public String getCounterid() {
		return counterid;
	}

	public void setCounterid(String counterid) {
		this.counterid = counterid;
	}
	

	public int getCounterNo() {
		return counterNo;
	}


	public void setCounterNo(int counterNo) {
		this.counterNo = counterNo;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
