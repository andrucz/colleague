package com.andrucz.colleague.predicate;

import static com.andrucz.colleague.util.Checks.checkNotNull;

public abstract class DelegatePredicate<E> extends Predicate<E> {
	
	protected final Predicate<E> delegate;
	
	protected DelegatePredicate(Predicate<E> delegate) {
		checkNotNull(delegate, "delegate");
		this.delegate = delegate;
	}

}
