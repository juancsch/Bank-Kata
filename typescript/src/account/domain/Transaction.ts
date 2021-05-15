/* eslint-disable no-useless-constructor */

export class Transaction {
	constructor (
		public readonly amount: number,
		public readonly date: Date
	) {}
}
