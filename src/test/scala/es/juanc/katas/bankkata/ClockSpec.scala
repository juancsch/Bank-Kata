package es.juanc.katas.bankkata

import java.time.LocalDate

import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}

class ClockSpec extends FlatSpec with Matchers with MockFactory {

	behavior of "Clock"

	it must "return formatter date for today" in {

		val clock = buildTestableClock

		clock.dateAsString shouldBe "08/04/2000"
	}

	private def buildTestableClock: Clock = {
		new Clock() {
			override protected def today: LocalDate = {
				LocalDate.of(2000, 4, 8)
			}
		}
	}
}
