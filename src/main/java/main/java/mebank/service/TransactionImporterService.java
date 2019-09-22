package main.java.mebank.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import main.java.mebank.model.Transaction;
import main.java.utility.TransactionDateUtility;

public class TransactionImporterService {

	public static List<Transaction> transformFromCSV(List<String> lineItems) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		lineItems.forEach((lineItem) -> {
			String[] lineItemSplit = lineItem.split(",");
			Transaction transaction = new Transaction();
			
			
			transaction.setTransactionId(lineItemSplit[0].trim());
			transaction.setFromAccountId(lineItemSplit[1].trim());
			transaction.setToAccountId(lineItemSplit[2].trim());
			try {
				transaction.setCreatedAt(TransactionDateUtility.getDateFromString(lineItemSplit[3].trim()));
			} catch (ParseException e) {
				System.err.println("Unable to parse date from csv file");
				e.printStackTrace();
			}
			transaction.setAmount(lineItemSplit[4].trim());
			transaction.setTransactionType(lineItemSplit[5].trim());
			if (lineItemSplit.length == 7) {
				transaction.setRelatedTransaction(lineItemSplit[6].trim());
			}
			transactions.add(transaction);
		});
		return transactions;
	}
}
