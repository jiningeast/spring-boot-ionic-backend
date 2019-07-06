package com.marcelocarvalho.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelocarvalho.cursomc.domain.enums.PaymentStatus;

@Entity
public class PaymentTicket extends Payment {

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date expirationDate;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date paymentDate;
	
	
	
	public PaymentTicket() {
		
	}

	public PaymentTicket(Integer id, PaymentStatus status, Request request, Date expirationDate, Date paymentDate ) {
		super(id, status, request);
		this.expirationDate = expirationDate;
		this.paymentDate = paymentDate;
				
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
	
	

}
