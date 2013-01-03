package com.andrucz.colleague.predicate.comparable;

import com.andrucz.colleague.predicate.ParameterizedPredicate;

public final class LessThanPredicate<E extends Comparable<E>> extends ParameterizedPredicate<E, E> {

	protected LessThanPredicate(E arg) {
		super(arg);
	}

	@Override
	public boolean accept(E element) {
		return element.compareTo(arg) < 0;
	}

}