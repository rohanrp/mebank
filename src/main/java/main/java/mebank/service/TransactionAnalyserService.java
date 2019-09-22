package main.java.mebank.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import main.java.mebank.model.Transaction;
import main.java.mebank.model.TransactionsSummary;

public class TransactionAnalyserService {

	public static TransactionsSummary getBalanceByAccount(List<Transaction> transactions, String accountId, Date startDate, Date endDate) {
		List<Transaction> reversalFreeTransactions = TransactionAnalyserService.getReversalFreeTransactions(transactions);
		List<Transaction> transactionsWithinDateRange = TransactionAnalyserService.getTransactionsInDateRange(reversalFreeTransactions, startDate, endDate);
		List<Transaction> debitTransactions = TransactionAnalyserService.getDebitTransactions(transactionsWithinDateRange, accountId);
		List<Transaction> creditTransactions =  TransactionAnalyserService.getCreditTransactions(transactionsWithinDateRange, accountId);
		BigDecimal balance = TransactionAnalyserService.getTotalTransactionValue(creditTransactions).subtract(TransactionAnalyserService.getTotalTransactionValue(debitTransactions));
		TransactionsSummary summary = new TransactionsSummary(accountId, debitTransactions.size() + creditTransactions.size(), balance);
		return summary;
	}
	
	
	public static List<Transaction> getDebitTransactions(List<Transaction> transactions, String accountId) {
		return transactions.stream() 
                .filter(transaction -> transaction.getFromAccountId().equals(accountId))
                .collect(Collectors.toList());
	}
	
	public static List<Transaction> getCreditTransactions(List<Transaction> transactions, String accountId) {
		return transactions.stream() 
                .filter(transaction -> transaction.getToAccountId().equals(accountId))
                .collect(Collectors.toList());
	}
	
	public static List<Transaction> getReversalFreeTransactions(List<Transaction> transactions) {
		List<String> reversals = transactions.stream() 
                .filter(transaction -> transaction.isReversal())
                .map(transaction -> transaction.getRelatedTransaction())
                .collect(Collectors.toList());
		return transactions.stream() 
                .filter(transaction -> transaction.isPayment() && !reversals.contains(transaction.getTransactionId()))
                .collect(Collectors.toList());
	}
	
	
	public static List<Transaction> getTransactionsInDateRange(List<Transaction> transactions, Date startDate, Date endDate) {
		return transactions.stream() 
                .filter(transaction -> (startDate == null || transaction.getCreatedAt().getTime() >= startDate.getTime()) &&
                		(endDate == null || transaction.getCreatedAt().getTime() <= endDate.getTime()))
                .collect(Collectors.toList());
	}
	
	public static BigDecimal getTotalTransactionValue(List<Transaction> transactions) {
		return transactions.stream()
				.map((t) -> t.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
