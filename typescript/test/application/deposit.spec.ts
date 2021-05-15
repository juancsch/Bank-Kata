/* eslint-disable no-magic-numbers */

import { Deposit } from '../../src/account/application/deposit'

describe('Deposit - Should', function () {

	test('add amount', () => {

		const repositoryMock = {
			addTransaction: jest.fn(),
			getTransactions: jest.fn()
		}

		const calendarStub = {
			now: jest.fn()
		}
		const dateExpected = new Date(2021, 4, 1)
		calendarStub.now.mockReturnValueOnce(dateExpected)

		const deposit = Deposit(repositoryMock, calendarStub)

		deposit(1000)

		expect(repositoryMock.addTransaction).toBeCalledWith({
			date: dateExpected,
			amount: 1000
		})
	})
})
