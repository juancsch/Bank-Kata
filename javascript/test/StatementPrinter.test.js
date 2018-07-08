const StatementPrinter = require('../lib/StatementPrinter')

describe('StatementPrinter behaviour', () => {

	test('should print the header always', () => {

		const viewMock = {
			printLine: jest.fn()
		}

		const statementPrinter = StatementPrinter()

		statementPrinter.print([])

		expect(viewMock.printLine).toHaveBeenCalledWith('DATE | AMOUNT | BALANCE')
	})
})
