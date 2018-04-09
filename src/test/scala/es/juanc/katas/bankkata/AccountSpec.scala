package es.juanc.katas.bankkata

import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}

class AccountSpec extends FlatSpec with Matchers with MockFactory {

	behavior of "Account"

	it must "store added deposit" in {

		val transactionRepository = mock[TransactionRepository]
		transactionRepository.addTransactionWith _ expects 200

		val account = Account(transactionRepository, mock[StatementPrinter])
		account.deposit(200)
	}

	it must "store withdrawal deposit" in {

		val transactionRepository = mock[TransactionRepository]
		transactionRepository.addTransactionWith _ expects -200

		val account = Account(transactionRepository, mock[StatementPrinter])
		account.withdraw(200)
	}

	it must "print statement with all transaction" in {

		val transactionRepository = stub[TransactionRepository]
		(transactionRepository.allTransactions _).when().returns(List(Transaction("", 0)))

		val statementPrinter = mock[StatementPrinter]
		statementPrinter.print _ expects List(Transaction("", 0))

		val account = Account(transactionRepository, statementPrinter)
		account.printStatement()
	}
}
