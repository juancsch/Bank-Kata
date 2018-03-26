package es.juanc.katas.bankkata

case class Account(transactionRepository: TransactionRepository, statementTransactions: StatementTransactions) {

	def deposit(amount: Int): Unit = transactionRepository.addDeposit(amount)

	def withdraw(amount: Int): Unit = transactionRepository.addWithdrawal(amount)

	def printStatement(): Unit = statementTransactions.print {
			transactionRepository.allTransactions
		}
}
