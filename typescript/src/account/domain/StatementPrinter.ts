import dateformat from 'dateformat'

import { View } from './View'
import { Transaction } from './Transaction'

const HEADER = '\nDATE       | AMOUNT  | BALANCE'

export function StatementPrinter (view: View) {

	return {
		print (transactions: Transaction[]) {
			const statement = statementFrom(transactions)
			view.print(statement)
		}
	}
}

function statementFrom (transactions: Transaction[]) {

	let balance = 0
	const balances = transactions
		.map(transaction => {
			balance += transaction.amount
			return `${formatDate(transaction.date)} | ${formatAmount(transaction.amount)} | ${formatNumber(balance)}`
		})
		.reverse()

	return [HEADER, ...balances].join('\n')
}

function formatDate (value: Date) {
	return dateformat(value, 'dd/mm/yyyy')
}

function formatAmount (value: number) {
	// eslint-disable-next-line no-magic-numbers
	return formatNumber(value).padStart(7, ' ')
}

function formatNumber (value: number) {
	return `${value}.00`
}
