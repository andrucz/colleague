package com.andrucz.colleague.operation;

public abstract class Operation<E> {

	public void prepare() {
	}
	
	public abstract void execute(E element) throws OperationException;
	
	public void finish() {
	}
	
}