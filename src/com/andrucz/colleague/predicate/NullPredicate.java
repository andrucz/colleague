package com.andrucz.colleague.predicate;

public final class NullPredicate<E> extends Predicate<E> {

	@Override
	public boolean accept(E element) {
		return element == null;
	}

}
