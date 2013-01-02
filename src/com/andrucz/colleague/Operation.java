package com.andrucz.colleague;

public abstract class Operation<E> {

	public abstract void execute(E element) throws OperationException;
	
}