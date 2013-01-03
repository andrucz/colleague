package com.andrucz.colleague.predicate;

public final class EqualsPredicate<E> extends ParameterizedPredicate<E, E> {

	protected EqualsPredicate(E arg) {
		super(arg);
	}

	@Override
	public boolean accept(E element) {
		
		if (element == null) {
			return arg == null;
		}

		return element.equals(arg);
	}

}
