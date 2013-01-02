package com.andrucz.colleague;

public final class OrPredicate<E> extends CompositePredicate<E> {

	public OrPredicate(Predicate<E> first, Predicate<E>... predicates) {
		super(first, predicates);
	}

	@Override
	public boolean accept(E element) {
		for (Predicate<E> predicate : predicates) {
			if (predicate.accept(element)) {
				return true;
			}
		}
		return false;
	}

	
	
}
