package es.juanc.katas.bankkata

case class Account(transactionRepository: TransactionRepository, statementTransactions: StatementPrinter) {

	def deposit(amount: Int): Unit = transactionRepository.addTransactionWith(amount)

	def withdraw(amount: Int): Unit = transactionRepository.addTransactionWith(-amount)

	def printStatement(): Unit = statementTransactions.print {
			transactionRepository.allTransactions
		}
}
