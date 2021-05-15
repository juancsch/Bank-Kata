/* eslint-disable no-magic-numbers */

import { Account } from '../src/account/index'

describe('Banking - Should', function () {

	test('manage sequance actions', () => {

		const calendarStub = {
			now: () => new Date(2021, 3, 1)
		}

		const viewMock = {
			print: jest.fn()
		}

		const account = Account(calendarStub, viewMock)
		account.deposit(1000)
		account.withdrawal(100)
		account.deposit(500)
		account.printStatement()

		const expectedStatement = `
DATE       | AMOUNT  | BALANCE
01/04/2021 |  500.00 | 1400.00
01/04/2021 | -100.00 | 900.00
01/04/2021 | 1000.00 | 1000.00`

		expect(viewMock.print).toBeCalledWith(expectedStatement)
	})
})
