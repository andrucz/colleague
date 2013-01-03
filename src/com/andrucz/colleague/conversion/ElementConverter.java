package com.andrucz.colleague.conversion;

public abstract class ElementConverter<E, R> {

	public abstract R convert(E element);
	
}
