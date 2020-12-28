package es.juanc.katas.banking.domain;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(staticName = "of")
@EqualsAndHashCode
@ToString
public class Transaction {
	public final Amount amount;
	public final TransactionType transactionType;
	public final LocalDate date;

	public enum TransactionType {
		DEPOSIT("+"),
		WITHDRAWAL("-");
		public final String printValue;
		TransactionType(String printValue) {
			this.printValue = printValue;
		}
	}
}
