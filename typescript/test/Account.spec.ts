/* eslint-disable no-magic-numbers */

import { Account } from '../src/Account'

describe('Banking - Should', function () {

	test('manage sequance actions', () => {

		const repositoryMock = {
			addTransaction: jest.fn(),
			getTransactions: jest.fn()
		}

		repositoryMock.getTransactions.mockReturnValueOnce([
			{ date: new Date(2014, 3, 1), amount: 1000 },
			{ date: new Date(2014, 3, 2), amount: -100 },
			{ date: new Date(2014, 3, 10), amount: 500 }
		])

		const viewMock = {
			print: jest.fn()
		}

		const account = Account(repositoryMock, viewMock)
		account.deposit(1000)
		account.withdrawal(100)
		account.deposit(500)
		account.printStatement()

		const expectedStatement = `
DATE       | AMOUNT  | BALANCE
10/04/2014 |  500.00 | 1400.00
02/04/2014 | -100.00 | 900.00
01/04/2014 | 1000.00 | 1000.00`

		expect(repositoryMock.addTransaction).toBeCalledTimes(3)
		expect(repositoryMock.getTransactions).toBeCalledTimes(1)
		expect(viewMock.print).toBeCalledWith(expectedStatement)
	})
})
