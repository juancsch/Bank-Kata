function Account ({transactionRepository, statementPrinter}) {

	return {

		deposit (amount = 0) {
			transactionRepository.addTransactionWith(amount)
		},

		withdrawal (amount = 0) {
			transactionRepository.addTransactionWith(-amount)
		},

		printStatement () {
			statementPrinter.print(transactionRepository.allTransactions())
		}
	}
}

module.exports = Account
