package com.exam.inmobiliario.paymentmanagement.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the payments database table.
 * 
 */
@Entity
@Table(name = "payments")
@NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private BigDecimal amount;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String message;

	// bi-directional many-to-one association to MethodPayment
	@ManyToOne
	@JoinColumn(name = "method_payment_id")
	private MethodPayment methodPayment;

	@Column(name = "order_id")
	private int orderId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	// bi-directional many-to-one association to PaymentStatus
	@ManyToOne
	@JoinColumn(name = "status_id")
	private PaymentStatus paymentStatus;

	public Payment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MethodPayment getMethodPayment() {
		return this.methodPayment;
	}

	public void setMethodPayment(MethodPayment methodPayment) {
		this.methodPayment = methodPayment;
	}

	public PaymentStatus getPaymentStatus() {
		return this.paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}