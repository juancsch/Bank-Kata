package es.juanc.katas.bankkata.acceptance

import es.juanc.katas.bankkata._
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}

class StatementPrintFeature extends FlatSpec with Matchers with MockFactory {

	"Account" must "print statement containing all transaction" in {

		val view = mock[View]
		inSequence {
			(view printLine _) expects "DATE | AMOUNT | BALANCE"
			(view printLine _) expects "10/04/2014 | 500.00 | 1400.00"
			(view printLine _) expects "02/04/2014 | -100.00 | 900.00"
			(view printLine _) expects "01/04/2014 | 1000.00 | 1000.00"
		}

		val clock = stub[Clock]
		(clock.dateAsString _).when().returns("01/04/2014").noMoreThanOnce
		(clock.dateAsString _).when().returns("02/04/2014").noMoreThanOnce
		(clock.dateAsString _).when().returns("10/04/2014").noMoreThanOnce

		val account = Account(TransactionRepository(clock), StatementPrinter(view))

		account deposit 1000
		account withdraw 100
		account deposit 500

		account.printStatement()
	}
}
