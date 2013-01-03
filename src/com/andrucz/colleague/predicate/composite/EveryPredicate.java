package com.andrucz.colleague.predicate.composite;

import com.andrucz.colleague.predicate.Predicate;

public final class EveryPredicate<E> extends CompositePredicate<E> {

	public EveryPredicate(Predicate<E> first, Predicate<E>... predicates) {
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
