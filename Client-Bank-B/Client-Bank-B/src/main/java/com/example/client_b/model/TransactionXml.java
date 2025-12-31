package com.example.client_b.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "TransactionRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionXml {
	@XmlElement(name = "TrxId")
	private String trxId;
	@XmlElement(name = "BankId")
	private String bankId;
	@XmlElement(name = "CustomerId")
	private Long customerId;
	@XmlElement(name = "FromAccount")
	private String fromAccount;
	@XmlElement(name = "ToAccount")
	private String toAccount;
	@XmlElement(name = "Amount")
	private Double amount;
	@XmlElement(name = "Currency")
	private String currency;
	@XmlElement(name = "Timestamp")
	private String timestamp;

	public TransactionXml(String trxId, String bankId, Long customerId, String fromAccount, String toAccount,
			Double amount, String currency, String timestamp) {
		super();
		this.trxId = trxId;
		this.bankId = bankId;
		this.customerId = customerId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.currency = currency;
		this.timestamp = timestamp;
	}

	public TransactionXml() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTrxId() {
		return trxId;
	}

	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
