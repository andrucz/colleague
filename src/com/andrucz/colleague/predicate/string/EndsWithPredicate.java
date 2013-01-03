package com.andrucz.colleague.predicate.string;

import com.andrucz.colleague.predicate.ParameterizedPredicate;

public final class EndsWithPredicate extends ParameterizedPredicate<String, String> {

	protected EndsWithPredicate(String arg) {
		super(arg);
	}

	@Override
	public boolean accept(String element) {
		return element.endsWith(arg);
	}

}
