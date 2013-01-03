package com.andrucz.colleague.predicate.string;

import com.andrucz.colleague.predicate.ParameterizedPredicate;

public final class ContainsPredicate extends ParameterizedPredicate<String, String> {

	public ContainsPredicate(String arg) {
		super(arg);
	}

	@Override
	public boolean accept(String element) {
		return element.contains(arg);
	}

}
