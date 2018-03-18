package es.juanc.katas.bankkata.acceptance

import es.juanc.katas.bankkata.{Account, View}
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}

class StatementPrintFeature extends FlatSpec with Matchers with MockFactory {

	"Account" must "print statement containing all transaction" in {

		val view = mock[View]
		inSequence {
			view printLine "DATE | AMOUNT | BALANCE"
			view printLine "10/04/2014 | 500.00 | 1400.00"
			view printLine "02/04/2014 | -100.00 | 900.00"
			view printLine "01/04/2014 | 1000.00 | 1000.00"
		}

		val account = new Account

		account deposit 1000
		account withdraw 100
		account deposit 500

		account.printStatement
	}
}
