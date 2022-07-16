/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-Jan-24 6:53:18 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

/**
 * @author 20021900
 *
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class CartAppt {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  @ManyToOne
  @JoinColumn(name = "corpuser_id")
  private CorpUser corpuser;

  @ManyToOne
  @JoinColumn(name = "package_id")
  private Package packages;

  @ManyToOne
  @JoinColumn(name = "appt_id")
  private Appointment appt;

  private int quantity;

  @Transient
  private double subtotal;

  

public CorpUser getCorpuser() {
	return corpuser;
}


public void setCorpuser(CorpUser corpuser) {
	this.corpuser = corpuser;
}

public Package getPackages() {
	return packages;
}


public void setPackages(Package packages) {
	this.packages = packages;
}



public Appointment getAppt() {
	return appt;
}



public void setAppt(Appointment appt) {
	this.appt = appt;
}


public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

public double getSubtotal() {
	return subtotal;
}


public void setSubtotal(double subtotal) {
    this.subtotal = subtotal;
  }

  public int getId() {
    return id;
  }
}