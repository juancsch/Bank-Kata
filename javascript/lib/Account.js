function Account ({transactionRepository}) {

	return {

		deposit (amount = 0) {
			transactionRepository.addTransactionWith(amount)
		},

		withdrawal (amount = 0) {
			transactionRepository.addTransactionWith(-amount)
		},

		printStatement () {

		}
	}
}

module.exports = Account
