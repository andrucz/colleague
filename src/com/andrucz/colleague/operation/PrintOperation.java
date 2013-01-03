package com.andrucz.colleague.operation;

import java.io.PrintStream;

import static com.andrucz.colleague.util.Checks.checkNotNull;

public final class PrintOperation<E> extends Operation<E> {

	private PrintStream out;
	
	private String preffix;
	private String suffix;
	
	public PrintOperation(PrintStream out, String preffix, String suffix) {
		checkNotNull(out, "out");
		
		this.out = out;
		this.preffix = preffix;
		this.suffix = suffix;
	}
	
	public PrintOperation(PrintStream out) {
		this(out, null, null);
	}
	
	public PrintStream getOut() {
		return out;
	}

	public void setOut(PrintStream out) {
		this.out = out;
	}

	public String getPreffix() {
		return preffix;
	}

	public void setPreffix(String preffix) {
		this.preffix = preffix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public void execute(E element) throws OperationException {
		if (preffix != null) {
			out.print(preffix);
		}
		
		out.print(element);
		
		if (suffix != null) {
			out.print(suffix);
		}
	}

}