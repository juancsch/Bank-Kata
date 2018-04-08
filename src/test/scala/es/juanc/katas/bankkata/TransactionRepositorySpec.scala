package es.juanc.katas.bankkata

import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}

class TransactionRepositorySpec extends FlatSpec with Matchers with MockFactory {

	behavior of "transaction repository"

	val TODAY = "08/04/2018"

	it must "add a transaction with current date" in {

		val clock = stub[Clock]
		(clock.dateAsString _).when().returns(TODAY)

		val transactionRepository = TransactionRepository(clock)

		transactionRepository.addTransactionWith(100)

		transactionRepository.allTransactions shouldBe List(Transaction(TODAY, 100))
	}
}
