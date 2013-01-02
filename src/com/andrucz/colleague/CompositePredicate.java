package com.andrucz.colleague;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositePredicate<E> extends Predicate<E> {

	protected final List<Predicate<E>> predicates;
	
	public CompositePredicate(Predicate<E> first, Predicate<E>... predicates) {
		if (predicates.length == 0) {
			throw new IllegalArgumentException("predicates cannot be empty.");
		}
		
		this.predicates = new ArrayList<Predicate<E>>(predicates.length);

		addPredicate(first);
		
		for (Predicate<E> predicate : predicates) {
			addPredicate(predicate);
		}
	}

	public final void addPredicate(Predicate<E> predicate) {
		if (predicate == null) {
			throw new NullPointerException("predicate");
		}
		predicates.add(predicate);
	}
	
}
