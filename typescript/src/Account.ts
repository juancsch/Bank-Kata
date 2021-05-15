import dateformat from 'dateformat'

class Transaction {
	public readonly date: Date
	constructor (public readonly amount: number) {
		this.date = new Date()
	}
}

interface View {
	print (statement: string): void
}

interface TransactionRepository {
	getTransactions (): Transaction[]
	addTransaction (transaction: Transaction): void
}

export function Account (
	transactionRepository: TransactionRepository,
	view: View
) {

	return {

		deposit (amount: number): void {
			transactionRepository.addTransaction(
				new Transaction(amount)
			)
		},
		withdrawal (amount: number): void {
			transactionRepository.addTransaction(
				new Transaction(amount * -1) // eslint-disable-line no-magic-numbers
			)
		},
		printStatement (): void {
			const transactions = transactionRepository.getTransactions()
			view.print(statementFrom(transactions))
		}
	}
}

const HEADER = '\nDATE       | AMOUNT  | BALANCE'

function statementFrom (transactions: Transaction[]) {

	let balance = 0
	const balances = transactions
		.map(transaction => {
			balance += transaction.amount
			return `${formatDate(transaction.date)} | ${formatAmount(transaction.amount)} | ${formatBalance(balance)}`
		})
		.reverse()

	return [HEADER, ...balances].join('\n')

	function formatDate (value: Date) {
		return dateformat(value, 'dd/mm/yyyy')
	}

	function formatAmount (value: number) {
		// eslint-disable-next-line no-magic-numbers
		return `${value}.00`.padStart(7, ' ')
	}

	function formatBalance (value: number) {
		return `${value}.00`
	}
}
