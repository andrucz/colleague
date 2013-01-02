package com.andrucz.colleague.predicate;

public final class EqualsPredicate<E> extends ParameterizedPredicate<E, E> {

	@Override
	public boolean accept(E element, E arg) {
		
		if (element == null) {
			return arg == null;
		}

		return element.equals(arg);
	}

}
