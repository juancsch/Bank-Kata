function Account (transactionRepository) {

	return {

		deposit (amount = 0) {
			transactionRepository.addDeposit(amount)
		},

		withdrawal (amount = 0) {
			transactionRepository.addWithdrawal(amount)
		},

		printStatement () {

		}
	}
}

module.exports = Account
