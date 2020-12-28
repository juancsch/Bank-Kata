package es.juanc.katas.banking.application;

import es.juanc.katas.banking.domain.Amount;
import es.juanc.katas.banking.domain.Calendar;
import es.juanc.katas.banking.domain.StatementPrinter;
import es.juanc.katas.banking.domain.Transaction;
import es.juanc.katas.banking.domain.TransactionsRepository;

import static es.juanc.katas.banking.domain.Transaction.TransactionType.DEPOSIT;
import static es.juanc.katas.banking.domain.Transaction.TransactionType.WITHDRAWAL;

public class Account {

	private final TransactionsRepository transactionRepository;
	private final Calendar calendar;
	private final StatementPrinter statementPrinter;

	public Account(TransactionsRepository transactionRepository,
	               Calendar calendar,
	               StatementPrinter statementPrinter) {
		this.calendar = calendar;
		this.statementPrinter = statementPrinter;
		this.transactionRepository = transactionRepository;
	}

	public void deposit (Amount amount) {
		transactionRepository.add(
				Transaction.of(amount, DEPOSIT, calendar.now())
		);
	}

	public void withdrawal (Amount amount) {
		transactionRepository.add(
				Transaction.of(amount, WITHDRAWAL, calendar.now())
		);
	}

	public void printStatement() {
		statementPrinter.print(
				transactionRepository.findAll()
		);
	}
}
