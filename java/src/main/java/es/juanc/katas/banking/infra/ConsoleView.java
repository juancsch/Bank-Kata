package es.juanc.katas.banking.infra;

import es.juanc.katas.banking.domain.View;

import static java.lang.System.out;

public class ConsoleView implements View {

	@Override
	public void write(String report) {
		out.print(report);
	}
}
