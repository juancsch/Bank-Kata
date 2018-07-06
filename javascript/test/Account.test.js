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
})
