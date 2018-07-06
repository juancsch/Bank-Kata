const Account = require('../lib/Account')

describe('Account behaviour', () => {

	test('should store added deposit', () => {

		const transactionRepository = {
			addDeposit: jest.fn()
		}

		const account = Account()
		account.deposit(100)

		expect(transactionRepository.addDeposit).toHaveBeenCalledWith(100)
	})
})
