const Account = require('./lib')

const account = Account({
	printLine: console.log
})

account.withdrawal(56)
account.deposit(545)
account.withdrawal(545)
account.deposit(474)
account.deposit(5458)
account.deposit(4)
account.deposit(545)
account.withdrawal(545)
account.withdrawal(45452)
account.deposit(545)
account.deposit(525445)
account.withdrawal(5)

account.printStatement()
