function Account (transactionRepository) {

	return {

		deposit (amount = 0) {
			transactionRepository.addDeposit(amount)
		},

		withdrawal (amount = 0) {

		},

		printStatement () {

		}
	}
}

module.exports = Account
