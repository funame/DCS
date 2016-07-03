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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.org.apache.xpath.internal.operations.Or;

import net.myapp.model.Groups;
import net.myapp.model.Teacher;

@Entity
@Table(name = "user_card")
public class UserCard {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
	User user;
	int status;
	Date valid_from;
	Date valid_to;
	double balance;
	double discount;
	
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = true)
	SecureUser seller;

 
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "card_id")
	Card card;
	@OneToMany(fetch = FetchType.LAZY,mappedBy="userCard")
	Set<Order>  orderSet;
   
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getValid_from() {
		return valid_from;
	}

	public void setValid_from(Date valid_from) {
		this.valid_from = valid_from;
	}

	public Date getValid_to() {
		return valid_to;
	}

	public void setValid_to(Date valid_to) {
		this.valid_to = valid_to;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public SecureUser getSeller() {
		return seller;
	}

	public void setSeller(SecureUser seller) {
		this.seller = seller;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Set<Order> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}

}
