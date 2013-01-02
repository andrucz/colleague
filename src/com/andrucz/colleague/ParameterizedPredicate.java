package com.andrucz.colleague;

public abstract class ParameterizedPredicate<E, A> {

	public abstract boolean accept(E element, A arg);
	
}
