package com.andrucz.colleague.predicate;

public final class GreaterThanPredicate<E extends Comparable<E>> extends ParameterizedPredicate<E, E> {

	@Override
	public boolean accept(E element, E arg) {
		return element.compareTo(arg) > 0;
	}

}
