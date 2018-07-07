const Account = require('../lib/Account')
const TransactionsRepository = require('../lib/InMemoryTransactionRepository')

describe('Statement print feature', () => {

	test('should print statement containing all transactions', () => {

		const view = {
			printLine: jest.fn()
		}

		const account = Account(
			{transactionRepository: TransactionsRepository()}
		)

		account.deposit(1000)
		account.withdrawal(100)
		account.deposit(500)

		account.printStatement()

		expect(view.printLine.mock.calls.length).toBe(4)
		expect(view.printLine.mock.calls[0][0]).toBe('DATE | AMOUNT | BALANCE')
		expect(view.printLine.mock.calls[1][0]).toBe('10/04/2014 | 500.00 | 1400.00')
		expect(view.printLine.mock.calls[2][0]).toBe('02/04/2014 | -100.00 | 900.00')
		expect(view.printLine.mock.calls[3][0]).toBe('01/04/2014 | 1000.00 | 1000.00')
	})
})
