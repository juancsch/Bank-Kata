const TransactionRepository = require('../lib/InMemoryTransactionRepository')

describe('TransactionRepository behaviour', () => {

	test('should add a transaction with current date', () => {

		const TODAY = '09/07/2018'
		const calendarStub = {
			dateAsString: () => TODAY
		}

		const transactionRepository = TransactionRepository({calendar: calendarStub})

		transactionRepository.addTransactionWith(100)

		expect(
			transactionRepository.allTransactions()
		).toEqual(
			[{date: TODAY, amount: 100}]
		)
	})
})
