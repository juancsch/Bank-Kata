import { TransactionRepository } from '../domain/TransactionsRepository'
import { View } from '../domain/View'
import { StatementPrinter } from '../domain/StatementPrinter'

export function PrintStatement (transactionRepository: TransactionRepository, view: View) {

	const statementPrinter = StatementPrinter(view)

	return () => {
		const transactions = transactionRepository.getTransactions()
		statementPrinter.print(transactions)
	}
}
