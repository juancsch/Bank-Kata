const Account = require('../lib/Account')

describe('Account behaviour', () => {

	test('should store added deposit', () => {

		const transactionRepository = {
			addDeposit: jest.fn()
		}

		const account = Account(transactionRepository)
		account.deposit(100)

		expect(transactionRepository.addDeposit).toHaveBeenCalledWith(100)
	})

	test('should store withdrawal deposit', () => {

		const transactionRepository = {
			addWithdrawal: jest.fn()
		}

		const account = Account(transactionRepository)
		account.withdrawal(100)

		expect(transactionRepository.addWithdrawal).toHaveBeenCalledWith(100)
	})
})
