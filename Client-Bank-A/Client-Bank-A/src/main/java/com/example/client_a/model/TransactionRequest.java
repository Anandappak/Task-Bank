package com.example.client_a.model;

public class TransactionRequest {
	private Long customerId;
	private String fromAccount;
	private String toAccount;
	private Double amount;
	private String currency;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public TransactionRequest(Long customerId, String fromAccount, String toAccount, Double amount, String currency) {
		super();
		this.customerId = customerId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.currency = currency;
	}

	public TransactionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
