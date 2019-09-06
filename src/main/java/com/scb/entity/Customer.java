package com.scb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer custId;
	
	@NotNull
	@Size(max=65)
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Size(max=65)
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@Size(max=10)
	@Column(name = "pan_id")
	private String panId;
	
	@Column(name="dob")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	@Column(name = "phone_number")
	@Size(max=15)
	private String phoneNumber;
	
	@NotNull
	@Email
	@Column(unique = true)
	@Size(max = 100)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private Gender gender;
	
	
	
	public Customer() {
		super();
	}

    	
	public Customer(Integer custId, @NotNull @Size(max = 65) String firstName, @NotNull @Size(max = 65) String lastName,
			@NotNull @Size(max = 10) String panId, Date dob, @Size(max = 15) String phoneNumber,
			@NotNull @Email @Size(max = 100) String email, Gender gender) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.panId = panId;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.gender = gender;
		
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPanId() {
		return panId;
	}

	public void setPanId(String panId) {
		this.panId = panId;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

		public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
