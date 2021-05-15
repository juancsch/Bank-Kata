import { Calendar } from '../domain/Calendar'
import { Transaction } from '../domain/Transaction'
import { TransactionRepository } from '../domain/TransactionsRepository'

export function Withdrawal (transactionRepository: TransactionRepository, calendar: Calendar) {

	return (amount: number) => {
		transactionRepository.addTransaction(
			new Transaction(amount * -1, calendar.now()) // eslint-disable-line no-magic-numbers
		)
	}
}
