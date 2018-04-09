package es.juanc.katas.bankkata

import java.text.DecimalFormat

case class StatementPrinter(view: View) {

	val STATEMENT_HEADER = "DATE | AMOUNT | BALANCE"
	val DECIMAL_FORMATTER = new DecimalFormat("#.00")

	def print(transactions: List[Transaction]): Unit = {
		printHeader
		printStatementLines(statementLinesFor(transactions))
	}

	private def printHeader: Unit = {
		view printLine STATEMENT_HEADER
	}

	private def statementLinesFor(transactions: List[Transaction]): List[String] = {
		var balance = 0
		transactions
						.map(transaction => {
							balance = balance + transaction.amount
							statementLineFor(transaction, balance)
						})
	}

	private def printStatementLines(statementLines: List[String]): Unit = {
		statementLines
						.reverse
						.foreach(statementLine => view printLine statementLine)
	}

	private def statementLineFor(transaction: Transaction, balance: Int) = {
		s"${transaction.date} | ${decimalFormatter(transaction.amount)} | ${decimalFormatter(balance)}"
	}

	private def decimalFormatter(amount: Int): String = {
			DECIMAL_FORMATTER.format(amount)
	}
}
