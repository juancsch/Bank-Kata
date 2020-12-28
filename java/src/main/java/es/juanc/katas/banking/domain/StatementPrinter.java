package es.juanc.katas.banking.domain;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

import static es.juanc.katas.banking.domain.Transaction.TransactionType.DEPOSIT;
import static es.juanc.katas.banking.domain.Transaction.TransactionType.WITHDRAWAL;
import static java.util.stream.Collectors.toList;

public class StatementPrinter {

	private static final DateTimeFormatter transactionDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	public static final String REPORT_HEADER = "Date         Amount  Balance";
	public static final String NEW_LINE = System.getProperty("line.separator");

	private final View view;

	public StatementPrinter(View view) {
		this.view = view;
	}

	public void print(final List<Transaction> transactions) {
		var transactionsSorted = transactions.stream()
				.sorted(transactionsByDate())
				.collect(toList());
		StringBuilder report = generateReportFrom(transactionsSorted);
		view.write(report + NEW_LINE);
	}

	private Comparator<Transaction> transactionsByDate() {
		return (t1, t2) -> {
			if (t1.date.isEqual(t2.date)) return 0;
			if (t2.date.isBefore(t1.date)) return 1;
			return -1;
		};
	}

	private StringBuilder generateReportFrom(List<Transaction> transactions) {
		StringBuilder report = new StringBuilder(REPORT_HEADER);
		var currentBalance = 0;
		for (Transaction transaction : transactions) {
			if (transaction.transactionType == DEPOSIT)	currentBalance += transaction.amount.value;
			if (transaction.transactionType == WITHDRAWAL) currentBalance -= transaction.amount.value;
			report.append(NEW_LINE).append(toString(transaction, currentBalance));
		}
		return report;
	}

	private String toString(Transaction transaction, int currentBalance) {
		return transaction.date.format(transactionDate) +
					String.format("%9s", transaction.transactionType.printValue + transaction.amount.value) +
					String.format("%9s", currentBalance);
	}
}
