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

@Entity
@Table(name = "card_type")
public class CardType {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	int duration;
	double passing_amount;
	int discount;
	

/*	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cardType")
	Set<Card> cardSet;*/

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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getPassing_amount() {
		return passing_amount;
	}

	public void setPassing_amount(double passing_amount) {
		this.passing_amount = passing_amount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

/*	public Set<Card> getCardSet() {
		return cardSet;
	}

	public void setCardSet(Set<Card> cardSet) {
		this.cardSet = cardSet;
	}*/

}
