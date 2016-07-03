package net.myapp.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "good_order_id", nullable = true)
	Order order;

	@ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "good_id", nullable = true)
	Good good;
	int gcount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public int getGcount() {
		return gcount;
	}
	public void setGcount(int gcount) {
		this.gcount = gcount;
	}
	

}
