package com.andrucz.colleague;

import java.util.ArrayList;
import java.util.List;

import com.andrucz.colleague.conversion.ElementConverter;
import com.andrucz.colleague.operation.OperationException;
import com.andrucz.colleague.operation.PrintOperation;
import com.andrucz.colleague.predicate.NotPredicate;
import com.andrucz.colleague.predicate.Predicate;
import com.andrucz.colleague.predicate.string.StartsWithPredicate;

public final class ColleagueTest {

	public static void main(String[] args) throws OperationException {
		PrintOperation<String> operation = new PrintOperation<String>(System.out, "Members\r\n", "-------------\r\n", "> ", "!\r\n");
		
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
		
		
		ElementConverter<String, Integer> c = new ElementConverter<String, Integer>() {
			
			@Override
			public Integer convert(String element) {
				return Integer.valueOf(element.charAt(0));
			}
			
		};
		
		List<Integer> l = Colleague.convert(strs, c);
		Colleague.each(l, new PrintOperation<Integer>(System.out));
	}

}
