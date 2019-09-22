import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

import main.java.mebank.model.Transaction;
import main.java.mebank.model.TransactionsSummary;
import main.java.mebank.service.TransactionAnalyserService;
import main.java.mebank.service.TransactionImporterService;
import main.java.utility.CSVFileReader;
import main.java.utility.TransactionDateUtility;

public class Application {

	public static void main(String args[]) throws IOException, URISyntaxException, ParseException {

		String fileName = "transactions.csv";
		String accountId = "ACC334455";
		String dateFrom = "20/10/2018 12:00:00";
		String dateTo = "20/10/2018 19:00:00";

		List<String> fileContent = CSVFileReader.read(fileName);
		List<Transaction> transactions = TransactionImporterService.transformFromCSV(fileContent);
		TransactionsSummary summary = TransactionAnalyserService.getBalanceByAccount(transactions, accountId, TransactionDateUtility.getDateFromString(dateFrom), TransactionDateUtility.getDateFromString(dateTo));
		System.out.println("Relative balance for the period is: " + summary.getTotalAmountAsCurrency());
		System.out.println("Number of transactions included is: " + summary.getNumberOfTransactions());
	}

}
