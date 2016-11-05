package com.andrucz.colleague;

import static com.andrucz.predicate.Predicates.not;
import static com.andrucz.predicate.Predicates.startsWith;

import java.util.ArrayList;
import java.util.List;

import com.andrucz.predicate.NotPredicate;
import com.andrucz.predicate.Predicate;
import com.andrucz.predicate.string.StartsWithPredicate;

public final class ColleagueTest {

	public static void main(String[] args) throws OperationException {
		PrintOperation<String> operation = new PrintOperation<String>(System.out, "Members\r\n", "-------------\r\n",
				"> ", "!\r\n");

		List<String> strs = new ArrayList<String>();
		strs.add("David");
		strs.add("Nick");
		strs.add("Richard");
		strs.add("Roger");

		Colleague.each(strs, operation);

		operation.setGlobalPreffix("Members 2\r\n");
		operation.setElementPreffix("* ");

		Predicate<String> predicate = new NotPredicate<String>(new StartsWithPredicate("R"));
		Colleague.each(strs, predicate, operation);

		Colleague.each(strs, not(startsWith("D")), operation);
	}

}
