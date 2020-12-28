package es.juanc.katas.banking

import java.time.LocalDate

import es.juanc.katas.banking.application.Account
import es.juanc.katas.banking.domain.Amount
import es.juanc.katas.banking.domain.Calendar
import es.juanc.katas.banking.domain.StatementPrinter
import es.juanc.katas.banking.infra.ConsoleView
import es.juanc.katas.banking.infra.InMemoryTransactionRepository

import org.junit.Rule
import org.junit.contrib.java.lang.system.SystemOutRule

import spock.lang.Specification

class PrintStatementFeature extends Specification {

    @Rule
    SystemOutRule systemOutRule = new SystemOutRule().enableLog()

    void 'should print statement after operations are done'() {

        given:
        def calendarStub = Stub(Calendar) {
                now() >>> [
                        LocalDate.of(2015, 12, 24),
                        LocalDate.of(2016, 8, 23)
                ]
        }
        def account = new Account(
                new InMemoryTransactionRepository(),
                calendarStub,
                new StatementPrinter(new ConsoleView())
        )

        when:
        account.deposit(Amount.of(500))
        account.withdrawal(Amount.of(100))
        account.printStatement()

        then:
        def reportExpected = '''Date         Amount  Balance
                               |24.12.2015     +500      500
                               |23.08.2016     -100      400
                               |'''.stripMargin()
        systemOutRule.getLog() == reportExpected
    }
}
