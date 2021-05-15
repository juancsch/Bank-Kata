/* eslint-disable no-magic-numbers */

import { StatementPrinter } from '../../src/account/domain/StatementPrinter'

describe('StatementPrinter - Should', function () {

	test('print statement', () => {

		const viewMock = {
			print: jest.fn()
		}

		const statementPrinter = StatementPrinter(viewMock)

		statementPrinter.print([
			{ date: new Date(2014, 3, 1), amount: 1000 },
			{ date: new Date(2014, 3, 2), amount: -100 },
			{ date: new Date(2014, 3, 10), amount: 500 }
		])

		const expectedStatement = `
DATE       | AMOUNT  | BALANCE
10/04/2014 |  500.00 | 1400.00
02/04/2014 | -100.00 | 900.00
01/04/2014 | 1000.00 | 1000.00`

		expect(viewMock.print).toBeCalledWith(expectedStatement)
	})
})
