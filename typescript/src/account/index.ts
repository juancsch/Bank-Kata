import { Deposit } from './application/deposit'
import { Withdrawal } from './application/withdrawal'
import { PrintStatement } from './application/print-statement'
import { TransactionRepositoryInMemory } from './infra/TrasactionsRepositoryInMemeory'
import { View } from './domain/View'
import { Calendar } from './domain/Calendar'

const transactionRepositoryInMemory = TransactionRepositoryInMemory()

export function Account (calendar: Calendar, view: View) {

	const deposit = Deposit(transactionRepositoryInMemory, calendar)
	const withdrawal = Withdrawal(transactionRepositoryInMemory, calendar)
	const printStatement = PrintStatement(transactionRepositoryInMemory, view)

	return {
		deposit,
		withdrawal,
		printStatement
	}
}
