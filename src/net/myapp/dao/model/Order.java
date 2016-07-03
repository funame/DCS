package net.myapp.dao.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "good_order")
public class Order {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;
Date otime;
Date odate;
double total_amount;
double total_discount;
@ManyToOne (fetch = FetchType.LAZY)
@JoinColumn(name = "seller_id", nullable = true)
SecureUser secureUser;


@ManyToOne (fetch = FetchType.LAZY)
@JoinColumn(name = "user_card_id", nullable = true)
UserCard userCard;

@OneToMany(fetch = FetchType.LAZY,mappedBy="order")
Set<OrderDetail> orderDetailSet;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getOtime() {
	return otime;
}
public void setOtime(Date otime) {
	this.otime = otime;
}
public Date getOdate() {
	return odate;
}
public void setOdate(Date odate) {
	this.odate = odate;
}
public double getTotal_amount() {
	return total_amount;
}
public void setTotal_amount(double total_amount) {
	this.total_amount = total_amount;
}
public double getTotal_discount() {
	return total_discount;
}
public void setTotal_discount(double total_discount) {
	this.total_discount = total_discount;
}
public SecureUser getSecureUser() {
	return secureUser;
}
public void setSecureUser(SecureUser secureUser) {
	this.secureUser = secureUser;
}
public UserCard getUserCard() {
	return userCard;
}
public void setUserCard(UserCard userCard) {
	this.userCard = userCard;
}


}
