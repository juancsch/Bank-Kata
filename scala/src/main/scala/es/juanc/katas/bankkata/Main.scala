package es.juanc.katas.bankkata

object Console extends View {
	override def printLine(message: String): Unit = println(message)
}

object BankKataApp extends App {

	val account = Account(
		TransactionRepository(new Clock),
		StatementPrinter(Console)
	)

	account deposit 1000
	account withdraw 100
	account deposit 500

	account printStatement()
}
