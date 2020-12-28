package es.juanc.katas.banking;

import es.juanc.katas.banking.application.Account;
import es.juanc.katas.banking.domain.Amount;
import es.juanc.katas.banking.domain.StatementPrinter;
import es.juanc.katas.banking.infra.ConsoleView;
import es.juanc.katas.banking.infra.InMemoryTransactionRepository;
import es.juanc.katas.banking.infra.SystemCalendar;
import lombok.extern.java.Log;

@Log
public class App {

    public static void main(String[] args) {

        var account = new Account(
                new InMemoryTransactionRepository(),
                new SystemCalendar(),
                new StatementPrinter(new ConsoleView())
        );

        account.deposit(Amount.of(500));
        account.withdrawal(Amount.of(100));
        account.withdrawal(Amount.of(200));

        account.printStatement();
    }
}
