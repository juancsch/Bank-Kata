import { Calendar } from '../domain/Calendar'
import { Transaction } from '../domain/Transaction'
import { TransactionRepository } from '../domain/TransactionsRepository'

export function Deposit (transactionRepository: TransactionRepository, calendar: Calendar) {

	return (amount: number) => {
		transactionRepository.addTransaction(
			new Transaction(amount, calendar.now())
		)
	}
}
