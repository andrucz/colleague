package com.andrucz.colleague.operation;

public abstract class Operation<E> {

	public abstract void execute(E element) throws OperationException;
	
}