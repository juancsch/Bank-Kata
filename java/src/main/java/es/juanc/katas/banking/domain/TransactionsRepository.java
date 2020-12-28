package es.juanc.katas.banking.domain;

import java.util.List;

public interface TransactionsRepository {

	void add(Transaction transaction);
	List<Transaction> findAll();
}
