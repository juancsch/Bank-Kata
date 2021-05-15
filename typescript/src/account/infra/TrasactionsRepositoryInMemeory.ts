import { Transaction } from '../domain/Transaction'
import { TransactionRepository } from '../domain/TransactionsRepository'

export function TransactionRepositoryInMemory (): TransactionRepository {

	const transactions: Transaction[] = []

	return {
		getTransactions () {
			return transactions
		},
		addTransaction (transaction) {
			transactions.push(transaction)
		}
	}
}
