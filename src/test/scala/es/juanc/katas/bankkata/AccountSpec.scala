package es.juanc.katas.bankkata

import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}

class AccountSpec extends FlatSpec with Matchers with MockFactory {

	behavior of "Account"

	it must "store added deposit" in {

		val transactionRepository = mock[TransactionRepository]
		transactionRepository.addDeposit _ expects 200

		val account = Account(transactionRepository)
		account.deposit(200)
	}

	it must "store withdrawal deposit" in {

		val transactionRepository = mock[TransactionRepository]
		transactionRepository.addWithdrawal _ expects 200

		val account = Account(transactionRepository)
		account.withdraw(200)
	}
}
