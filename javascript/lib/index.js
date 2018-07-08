const Account = require('../lib/Account')
const TransactionsRepository = require('../lib/InMemoryTransactionRepository')
const StatementPrinter = require('../lib/StatementPrinter')
const calendar = require('../lib/Calendar')

module.exports = view => Account({
	transactionRepository: TransactionsRepository({calendar}),
	statementPrinter: StatementPrinter({view})
})
