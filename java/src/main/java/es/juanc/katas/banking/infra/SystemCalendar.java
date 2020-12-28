package es.juanc.katas.banking.infra;

import java.time.LocalDate;

import es.juanc.katas.banking.domain.Calendar;

public class SystemCalendar implements Calendar {
	@Override
	public LocalDate now() {
		return LocalDate.now();
	}
}
