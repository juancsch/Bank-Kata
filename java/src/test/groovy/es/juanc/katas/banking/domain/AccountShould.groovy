package es.juanc.katas.banking.domain

import java.time.LocalDate

import es.juanc.katas.banking.application.Account
import spock.lang.Specification
import static es.juanc.katas.banking.domain.Transaction.TransactionType.*

class AccountShould extends Specification {

    void 'store a deposit transaction' () {
        given:
        def repositoryMock = Mock(TransactionsRepository)
        def calendarStub = Stub(Calendar) { now() >> LocalDate.of(2020, 12, 1) }
        def account = new Account(repositoryMock, calendarStub, null)

        when:
        account.deposit(Amount.of(100))

        then:
        1 * repositoryMock.add(
                Transaction.of(
                        Amount.of(100),
                        DEPOSIT,
                        LocalDate.of(2020, 12, 1)
                )
        )
    }

    void 'store a withdrawal transaction' () {
        given:
        def repositoryMock = Mock(TransactionsRepository)
        def calendarStub = Stub(Calendar) { now() >> LocalDate.of(2020, 12, 1) }
        def account = new Account(repositoryMock, calendarStub, null)

        when:
        def amount = Amount.of(100)
        account.withdrawal(amount)

        then:
        1 * repositoryMock.add(
                Transaction.of(
                        Amount.of(100),
                        WITHDRAWAL,
                        LocalDate.of(2020, 12, 1)
                )
        )
    }

    void 'find all transaction' () {
        given:
        def repositoryMock = Mock(TransactionsRepository)
        def account = new Account(
                repositoryMock,
                null,
                new StatementPrinter(Mock(View))
        )

        when:
        account.printStatement()

        then:
        1 * repositoryMock.findAll() >> []
    }
}
