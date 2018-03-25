package es.juanc.katas.bankkata

class Account(val transactionRepository: TransactionRepository) {

	def deposit(amount: Int): Unit = transactionRepository.addDeposit(amount)

	def withdraw(amount: Int): Unit = transactionRepository.addWithdrawal(amount)

	def printStatement : Unit = ???
}
