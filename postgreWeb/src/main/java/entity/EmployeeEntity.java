package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BASE.EMPLOYEE")
public class EmployeeEntity {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private int id;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TELEPHONE")
	private String telephone;
	
	
	public void setId(int _id){
		this.id = _id;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName ;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setEmail(String email){
		this.email = email ;
	}
	
	public void setTelephone(String telephone){
		this.telephone = telephone;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getTelephone(){
		return this.telephone;
	}
	
}
