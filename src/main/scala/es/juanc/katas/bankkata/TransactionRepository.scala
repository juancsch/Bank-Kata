package es.juanc.katas.bankkata

case class TransactionRepository(clock: Clock) {

	private var transactions: List[Transaction] = Nil

	def addTransactionWith(amount: Int): Unit = {
		transactions = Transaction(clock.dateAsString, amount) :: transactions
	}

	def allTransactions: List[Transaction] = transactions
}
