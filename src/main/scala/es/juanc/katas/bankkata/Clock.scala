package es.juanc.katas.bankkata

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Clock {

	private val DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy")

	def dateAsString: String = {
		today.format(DATE_FORMAT)
	}

	protected def today: LocalDate = LocalDate.now()
}
