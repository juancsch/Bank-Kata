const calendar = require('../lib/Calendar')

describe('Calendar behaviour', () => {

	test('should return formatter date for today', () => {

		expect(calendar.dateAsString()).toEqual('08/07/2018')
	})
})
