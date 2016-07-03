package net.myapp.dao.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.myapp.model.Groups;
@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name;
	String surname;
	String gender;
	String phone;
	String phonework;
	String specialty;
	String city;
	String pin;
	String email;
	String pass;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	Set<UserCard> userCardSet;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhonework() {
		return phonework;
	}
	public void setPhonework(String phonework) {
		this.phonework = phonework;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Set<UserCard> getUserCardSet() {
		return userCardSet;
	}
	public void setUserCardSet(Set<UserCard> userCardSet) {
		this.userCardSet = userCardSet;
	}

}
