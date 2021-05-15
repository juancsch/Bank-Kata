/* eslint-disable no-magic-numbers */

import { Withdrawal } from '../../src/account/application/withdrawal'

describe('Deposit - Should', function () {

	test('withdrawl amount', () => {

		const repositoryMock = {
			addTransaction: jest.fn(),
			getTransactions: jest.fn()
		}

		const calendarStub = {
			now: jest.fn()
		}
		const dateExpected = new Date(2021, 4, 1)
		calendarStub.now.mockReturnValueOnce(dateExpected)

		const withdrawal = Withdrawal(repositoryMock, calendarStub)

		withdrawal(1000)

		expect(repositoryMock.addTransaction).toBeCalledWith({
			date: dateExpected,
			amount: -1000
		})
	})
})
