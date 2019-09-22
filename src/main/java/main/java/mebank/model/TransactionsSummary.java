package main.java.mebank.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class TransactionsSummary {
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public long getNumberOfTransactions() {
		return numberOfTransactions;
	}

	public void setNumberOfTransactions(long numberOfTransactions) {
		this.numberOfTransactions = numberOfTransactions;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	
	public String getTotalAmountAsCurrency() {
		DecimalFormat df = new DecimalFormat("$#,##0.00;-$#,##0.00");
	    return df.format(totalAmount);
	}
	
	

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public TransactionsSummary(String accountId, long numberOfTransactions, BigDecimal totalAmount) {
		this.accountId = accountId;
		this.numberOfTransactions = numberOfTransactions;
		this.totalAmount = totalAmount;
	}

	String accountId;
	
	long numberOfTransactions;
	
	BigDecimal totalAmount;
}