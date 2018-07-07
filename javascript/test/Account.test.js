const Account = require('../lib/Account')

describe('Account behaviour', () => {

	test('should store added deposit', () => {

		const transactionRepositoryMock = {
			addTransactionWith: jest.fn()
		}

		const account = Account({
			transactionRepository: transactionRepositoryMock
		})

		account.deposit(100)

		expect(transactionRepositoryMock.addTransactionWith).toHaveBeenCalledWith(100)
	})

	test('should store withdrawal deposit', () => {

		const transactionRepositoryMock = {
			addTransactionWith: jest.fn()
		}

		const account = Account({
			transactionRepository: transactionRepositoryMock
		})

		account.withdrawal(100)

		expect(transactionRepositoryMock.addTransactionWith).toHaveBeenCalledWith(-100)
	})

	test('should print statement with all transaction', () => {

		const statementPrinterMock = {
			print: jest.fn()
		}

		const transactions = [{data: '', amount: 0}]
		const transactionRepositoryMock = {
			allTransactions: () => transactions
		}

		const account = Account({
			transactionRepository: transactionRepositoryMock,
			statementPrinter: statementPrinterMock
		})

		account.printStatement()

		expect(statementPrinterMock.print).toHaveBeenCalledWith(transactions)
	})
})
