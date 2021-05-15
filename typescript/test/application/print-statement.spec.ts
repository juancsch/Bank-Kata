/* eslint-disable no-magic-numbers */

import { PrintStatement } from '../../src/account/application/print-statement'

describe('Account - Should', function () {

	test('manage sequance actions', () => {

		const repositoryMock = {
			addTransaction: jest.fn(),
			getTransactions: jest.fn()
		}

		repositoryMock.getTransactions.mockReturnValueOnce([
			{ date: new Date(2014, 3, 1), amount: 1000 },
			{ date: new Date(2014, 3, 2), amount: -100 }
		])

		const viewMock = {
			print: jest.fn()
		}

		const printStatement = PrintStatement(repositoryMock, viewMock)

		printStatement()

		const expectedStatement = `
DATE       | AMOUNT  | BALANCE
02/04/2014 | -100.00 | 900.00
01/04/2014 | 1000.00 | 1000.00`

		expect(viewMock.print).toBeCalledWith(expectedStatement)
	})
})
