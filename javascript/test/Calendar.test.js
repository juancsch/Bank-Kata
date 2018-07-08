const calendar = require('../lib/Calendar')

describe('Calendar behaviour', () => {

	test('should return formatter date for today', () => {

		calendar.today = () => new Date(2018, 0, 15)

		expect(calendar.dateAsString()).toEqual('15/01/2018')
	})
})
