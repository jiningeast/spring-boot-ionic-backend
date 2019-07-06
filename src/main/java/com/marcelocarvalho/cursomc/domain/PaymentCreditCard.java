package com.marcelocarvalho.cursomc.domain;

import javax.persistence.Entity;

import com.marcelocarvalho.cursomc.domain.enums.PaymentStatus;

@Entity
public class PaymentCreditCard extends Payment {
	
	private static final long serialVersionUID = 1L;

	private Integer numberOfInstallments;
	
	public PaymentCreditCard() {
		
	}

	public PaymentCreditCard(Integer id, PaymentStatus status, Request request, Integer numberOfInstallments) {
		super(id, status, request);
		this.numberOfInstallments = numberOfInstallments;
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}

	
	
}
