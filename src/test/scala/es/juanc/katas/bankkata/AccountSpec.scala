package es.juanc.katas.bankkata

import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}

class AccountSpec extends FlatSpec with Matchers with MockFactory {

	behavior of "Account"

	it must "store added deposit" in {

		val statementTransactions = mock[StatementTransactions]
		val transactionRepository = mock[TransactionRepository]
		transactionRepository.addDeposit _ expects 200

		val account = Account(transactionRepository, statementTransactions)
		account.deposit(200)
	}

	it must "store withdrawal deposit" in {

		val statementTransactions = mock[StatementTransactions]
		val transactionRepository = mock[TransactionRepository]
		transactionRepository.addWithdrawal _ expects 200

		val account = Account(transactionRepository, statementTransactions)
		account.withdraw(200)
	}

	it must "print statement with all transaction" in {

		val transactionRepository = stub[TransactionRepository]
		(transactionRepository.allTransactions _).when().returns(List(Transaction()))

		val statementTransactions = mock[StatementTransactions]
		statementTransactions.print _ expects List(Transaction())

		val account = Account(transactionRepository, statementTransactions)
		account.printStatement()
	}
}
