package com.andrucz.colleague.predicate.string;

import com.andrucz.colleague.predicate.ParameterizedPredicate;

public final class StartsWithPredicate extends ParameterizedPredicate<String, String> {

	protected StartsWithPredicate(String arg) {
		super(arg);
	}

	@Override
	public boolean accept(String element) {
		return element.startsWith(arg);
	}

}
