const TransactionRepository = require('../lib/InMemoryTransactionRepository')

describe('TransactionRepository behaviour', () => {

	test('should add a transaction with current date', () => {

		const TODAY = '09/07/2018'
		const clock = {
			dateAsString: TODAY
		}

		const transactionRepository = TransactionRepository(clock)

		transactionRepository.addTransactionWith(100)

		expect(
			transactionRepository.allTransactions()
		).toBe(
			[{date: TODAY, amount: 100}]
		)
	})
})
