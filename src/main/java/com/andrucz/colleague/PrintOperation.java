package com.andrucz.colleague;

import static com.andrucz.colleague.Checks.checkNotNull;

import java.io.PrintStream;

public final class PrintOperation<E> extends Operation<E> {

	private PrintStream out;

	private String globalPreffix;
	private String globalSuffix;

	private String elementPreffix;
	private String elementSuffix;

	public PrintOperation(PrintStream out, String globalPreffix, String globalSuffix, String elementPreffix,
			String elementSuffix) {
		checkNotNull(out, "out");

		this.out = out;
		this.globalPreffix = globalPreffix;
		this.globalSuffix = globalSuffix;
		this.elementPreffix = elementPreffix;
		this.elementSuffix = elementSuffix;
	}

	public PrintOperation(PrintStream out) {
		this(out, null, null, null, null);
	}

	public PrintStream getOut() {
		return out;
	}

	public void setOut(PrintStream out) {
		this.out = out;
	}

	public String getGlobalPreffix() {
		return globalPreffix;
	}

	public void setGlobalPreffix(String globalPreffix) {
		this.globalPreffix = globalPreffix;
	}

	public String getGlobalSuffix() {
		return globalSuffix;
	}

	public void setGlobalSuffix(String globalSuffix) {
		this.globalSuffix = globalSuffix;
	}

	public String getElementPreffix() {
		return elementPreffix;
	}

	public void setElementPreffix(String elementPreffix) {
		this.elementPreffix = elementPreffix;
	}

	public String getElementSuffix() {
		return elementSuffix;
	}

	public void setElementSuffix(String elementSuffix) {
		this.elementSuffix = elementSuffix;
	}

	private void print(String str) {
		if (str != null) {
			out.print(str);
		}
	}

	@Override
	public void prepare() {
		print(globalPreffix);
	}

	@Override
	public void execute(E element) throws OperationException {
		print(elementPreffix);

		out.print(element);

		print(elementSuffix);
	}

	@Override
	public void finish() {
		print(globalSuffix);
	}

}