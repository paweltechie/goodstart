package com.motivecloud.shop.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
   private String id;
   private String firstName;
   private String lastName;
   private String street;
   private String city;
   private String state;
   private String zip;
   private String country;
   private String email;

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

   public String getStreet() {
      return street;
   }

   public void setStreet(String street) {
      this.street = street;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getZip() {
      return zip;
   }

   public void setZip(String zip) {
      this.zip = zip;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }
   
   
   public String getEmail() {
	return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
   public String toString() {
	   return getId() + " - " + getFirstName() + " - " + getLastName() + " - " + getStreet() + " - " + getCity()+ " - " +getState()+ " - " +getZip()+ " - " +getCountry()+ " - " +getEmail();
   }
}
