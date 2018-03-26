package es.juanc.katas.bankkata

case class TransactionRepository() {

	def addDeposit(amount: Int): Unit = throw new UnsupportedOperationException

	def addWithdrawal(amount: Int): Unit = throw new UnsupportedOperationException

	def allTransactions: List[Transaction] = throw new UnsupportedOperationException
}
