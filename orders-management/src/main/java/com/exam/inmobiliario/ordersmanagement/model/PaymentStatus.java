package com.exam.inmobiliario.ordersmanagement.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the payment_status database table.
 * 
 */
@Entity
@Table(name="payment_status")
@NamedQuery(name="PaymentStatus.findAll", query="SELECT p FROM PaymentStatus p")
public class PaymentStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String code;

	private String name;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="paymentStatus")
	private List<Payment> payments;

	public PaymentStatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setPaymentStatus(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setPaymentStatus(null);

		return payment;
	}

}