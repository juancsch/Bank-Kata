package es.juanc.katas.bankkata

import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}

class StatementPrinterSpec extends FlatSpec with Matchers with MockFactory {

	behavior of "StatementPrinter"

	it must "print the header always" in {

		val view = mock[View]
		(view printLine _) expects "DATE | AMOUNT | BALANCE"

		val printer = StatementPrinter(view)

		printer.print(Nil)
	}

	it must "print in the reverse order that were introduced" in {

		val view = mock[View]
		inSequence {
			(view printLine _) expects "DATE | AMOUNT | BALANCE"
			(view printLine _) expects "10/04/2014 | 500.00 | 1400.00"
			(view printLine _) expects "02/04/2014 | -100.00 | 900.00"
			(view printLine _) expects "01/04/2014 | 1000.00 | 1000.00"
		}

		val printer = StatementPrinter(view)

		printer.print(
			transactions(
				deposit("01/04/2014", 1000),
				withdraw("02/04/2014", 100),
				deposit("10/04/2014", 500)
			)
		)
	}

	def transactions(transactions: Transaction*): List[Transaction] = {
		transactions.toList
	}

	def deposit(date: String, amount: Int): Transaction = {
		Transaction(date, amount)
	}

	def withdraw(date: String, amount: Int): Transaction = {
		Transaction(date, -amount)
	}
}
