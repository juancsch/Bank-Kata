package es.juanc.katas.banking.domain

import java.time.LocalDate

import spock.lang.Specification

import static es.juanc.katas.banking.domain.StatementPrinter.REPORT_HEADER
import static es.juanc.katas.banking.domain.Transaction.TransactionType.DEPOSIT
import static es.juanc.katas.banking.domain.Transaction.TransactionType.WITHDRAWAL

class StatementPrinterShould extends Specification {

    void 'print header in view abstraction' () {
        given:
        def viewMock = Mock(View)
        def statement = new StatementPrinter(viewMock)

        when:
        statement.print([])

        then:
        1 * viewMock.write("$REPORT_HEADER\n")
    }

    void 'print one transaction' () {
        given:
        def viewMock = Mock(View)
        def statement = new StatementPrinter(viewMock)

        when:
        statement.print([
                Transaction.of(
                        Amount.of(100),
                        DEPOSIT,
                        LocalDate.of(2020, 12, 23)
                )
        ])

        then:
        1 * viewMock.write("""$REPORT_HEADER
                              |23.12.2020     +100      100
                              |""".stripMargin())
    }

    void 'print transactions unsorted' () {
        given:
        def viewMock = Mock(View)
        def statement = new StatementPrinter(viewMock)

        when:
        statement.print([
                Transaction.of(
                        Amount.of(100),
                        WITHDRAWAL,
                        LocalDate.of(2020, 12, 23)
                ),
                Transaction.of(
                        Amount.of(100),
                        DEPOSIT,
                        LocalDate.of(2020, 3, 1)
                )
        ])

        then:
        1 * viewMock.write("""$REPORT_HEADER
                              |01.03.2020     +100      100
                              |23.12.2020     -100        0
                              |""".stripMargin())
    }

    void 'print transactions unsorted with negative balance' () {
        given:
        def viewMock = Mock(View)
        def statement = new StatementPrinter(viewMock)

        when:
        statement.print([
                Transaction.of(
                        Amount.of(100),
                        WITHDRAWAL,
                        LocalDate.of(2020, 12, 30)
                ),
                Transaction.of(
                        Amount.of(100),
                        WITHDRAWAL,
                        LocalDate.of(2020, 12, 23)
                ),
                Transaction.of(
                        Amount.of(100),
                        DEPOSIT,
                        LocalDate.of(2020, 3, 1)
                )
        ])

        then:
        1 * viewMock.write("""$REPORT_HEADER
                              |01.03.2020     +100      100
                              |23.12.2020     -100        0
                              |30.12.2020     -100     -100
                              |""".stripMargin())
    }
}
