package com.andrucz.colleague;

import java.util.ArrayList;
import java.util.List;

import com.andrucz.colleague.operation.Operation;
import com.andrucz.colleague.operation.OperationException;
import com.andrucz.colleague.operation.PrintOperation;

public final class ColleagueTest {

	public static void main(String[] args) throws OperationException {
		Operation<String> operation = new PrintOperation<String>(System.out, "> ", "!\r\n");
		
		List<String> strs = new ArrayList<String>();
		strs.add("David");
		strs.add("Nick");
		strs.add("Richard");
		strs.add("Roger");
		
		Colleague.each(strs, operation);
	}

}
