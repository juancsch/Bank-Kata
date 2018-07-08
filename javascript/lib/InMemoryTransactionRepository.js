const Transaction = require('./Transaction')

function InMemoryTransactionRepository ({calendar}) {

	const transactions = []

	return {

		addTransactionWith (amount = 0) {
			transactions.push(
				Transaction(calendar.dateAsString(), amount)
			)
		},

		allTransactions: () => [...transactions]
	}
}

module.exports = InMemoryTransactionRepository
