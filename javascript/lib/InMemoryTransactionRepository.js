function InMemoryTransactionRepository () {

	return {

		addTransactionWith (amount = 0) {
			throw new Error('not implement yet')
		},

		allTransactions () {
			throw new Error('not implement yet')
		}
	}
}

module.exports = InMemoryTransactionRepository
