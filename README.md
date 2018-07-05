# Bank account kata

Outside-In TDD with acceptance tests kata based on [github - sandro mancuso](https://github.com/sandromancuso/bank-kata-outsidein-screencast)


## Objective

Learn and practice the double loop of TDD Test application from outside, identifying side effects  
Problem description - Bank kata

Create a simple bank application with the following features:

 - Deposit into Account
 - Withdraw from an Account
 - Print a bank statement to the console


## Acceptance criteria

Statement should have transactions in the following format:

  DATE       | AMOUNT  | BALANCE
  10/04/2014 | 500.00  | 1400.00
  02/04/2014 | -100.00 | 900.00
  01/04/2014 | 1000.00 | 1000.00


## Starting point and constraints

Start with a class/module the following structure:

```
class Account {

    deposit(amount: int): void

    withdrawal(amount: int): void

    printStatement(): void
}
```

You are not allowed to add any other public method to this class.

NOTE: In order to keep the exercise simple, use Int for money and String for dates. Also, you can ignore the formatting of the statement (spaces between pipes and words, etc).
