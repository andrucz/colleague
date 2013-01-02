package com.andrucz.colleague;

public final class AndPredicate<E> extends CompositePredicate<E> {

	public AndPredicate(Predicate<E> first, Predicate<E>... predicates) {
		super(first, predicates);
	}

	@Override
	public boolean accept(E element) {
		for (Predicate<E> predicate : predicates) {
			if (!predicate.accept(element)) {
				return false;
			}
		}
		return true;
	}

}
