const Account = require('../lib/Account')

describe('Account behaviour', () => {

	test('should store added deposit', () => {

		const transactionRepository = {
			addTransactionWith: jest.fn()
		}

		const account = Account({transactionRepository})
		account.deposit(100)

		expect(transactionRepository.addTransactionWith).toHaveBeenCalledWith(100)
	})

	test('should store withdrawal deposit', () => {

		const transactionRepository = {
			addTransactionWith: jest.fn()
		}

		const account = Account({transactionRepository})
		account.withdrawal(100)

		expect(transactionRepository.addTransactionWith).toHaveBeenCalledWith(-100)
	})

	test('should print statement with all transaction', () => {

		const statementPrinterMock = {
			print: jest.fn()
		}

		const transactions = [{data: '', amount: 0}]
		const transactionRepositoryMock = {}

		const account = Account({
			transactionRepository: transactionRepositoryMock
		})

		account.printStatement()

		expect(statementPrinterMock.print).toHaveBeenCalledWith(transactions)
	})
})
