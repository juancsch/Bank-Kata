const StatementPrinter = require('../lib/StatementPrinter')

describe('StatementPrinter behaviour', () => {

	test('should print the header always', () => {

		const viewMock = {
			printLine: jest.fn()
		}

		const statementPrinter = StatementPrinter({view: viewMock})

		statementPrinter.print([])

		expect(viewMock.printLine).toHaveBeenCalledWith('DATE | AMOUNT | BALANCE')
	})

	test('should print in the reverse order that were introduced', () => {

		const viewMock = {
			printLine: jest.fn()
		}

		const statementPrinter = StatementPrinter({view: viewMock})

		statementPrinter.print([
			{date: '01/04/2014', amount: 1000},
			{date: '02/04/2014', amount: -100},
			{date: '10/04/2014', amount: 500}
		])

		expect(viewMock.printLine).toHaveBeenCalledWith('DATE | AMOUNT | BALANCE')
		expect(viewMock.printLine.mock.calls[1][0]).toBe('10/04/2014 | 500.00 | 1400.00')
		expect(viewMock.printLine.mock.calls[2][0]).toBe('02/04/2014 | -100.00 | 900.00')
		expect(viewMock.printLine.mock.calls[3][0]).toBe('01/04/2014 | 1000.00 | 1000.00')
	})
})
