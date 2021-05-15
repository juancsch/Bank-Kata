import { Transaction } from './Transaction'

export interface TransactionRepository {
	getTransactions (): Transaction[]
	addTransaction (transaction: Transaction): void
}
