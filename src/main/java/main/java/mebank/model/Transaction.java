package main.java.mebank.model;

import java.math.BigDecimal;
import java.util.Date;


public class Transaction {
	
    String transactionId;
    
    String fromAccountId;
    
    String toAccountId;
    
    Date createdAt;
    
    BigDecimal amount;
    
    String transactionType;
    
    String relatedTransaction;
    
    boolean isPayment;
    
    boolean isReversal;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public String getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = new BigDecimal(amount.trim());
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.isPayment = transactionType.equals(TransactionType.PAYMENT.getType());
		this.isReversal = transactionType.equals(TransactionType.REVERSAL.getType());
		this.transactionType = transactionType;
	}

	public boolean isPayment() {
		return isPayment;
	}

	public boolean isReversal() {
		return isReversal;
	}

	public String getRelatedTransaction() {
		return relatedTransaction;
	}

	public void setRelatedTransaction(String relatedTransaction) {
		this.relatedTransaction = relatedTransaction;
	}
}