package com.andrucz.colleague.predicate;

public abstract class ParameterizedPredicate<E, A> {

	public abstract boolean accept(E element, A arg);
	
}
