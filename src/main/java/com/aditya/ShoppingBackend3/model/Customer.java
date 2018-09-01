package com.aditya.ShoppingBackend3.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@Entity
@Table(name="Customer")
@Component
public class Customer implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customerId")
	private int customerId;
	private String firstName;
	private String password;
	private String emailId;
	
	/*FOR CASCADE TYPE
	 * @OneToOne(fetch=FetchType.EAGER)
	ShippingAddress shippingAddress;*/
	
	/*FOR REMOVAL
	 * @OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	ShippingAddress shippingAddress;*/ 
	
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="shippingId")
	ShippingAddress shippingAddress; 
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
