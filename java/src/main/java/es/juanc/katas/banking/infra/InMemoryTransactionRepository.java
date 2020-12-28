package es.juanc.katas.banking.infra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.juanc.katas.banking.domain.Transaction;
import es.juanc.katas.banking.domain.TransactionsRepository;

public class InMemoryTransactionRepository implements TransactionsRepository {

	private final List<Transaction> transactions = new ArrayList<>();

	@Override
	public void add(Transaction transaction) {
		transactions.add(transaction);
	}

	@Override
	public List<Transaction> findAll() {
		return Collections.unmodifiableList(transactions);
	}
}
