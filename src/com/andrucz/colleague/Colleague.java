package com.andrucz.colleague;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.andrucz.colleague.operation.Operation;
import com.andrucz.colleague.operation.OperationException;
import com.andrucz.colleague.predicate.ParameterizedPredicate;
import com.andrucz.colleague.predicate.Predicate;

public final class Colleague {
	
	private static void checkPosition(int position, int size) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Index: " + position + " Size: " + size);
        }
    }
	
	private static abstract class Checker<E> {

		protected abstract boolean check(E element);
		
	}
	
	private static final class AcceptAllChecker<E> extends Checker<E> {

		@Override
		protected boolean check(E element) {
			return true;
		}
		
	}
	
	private static class PredicateChecker<E> extends Checker<E> {

		private final Predicate<E> predicate;
		
		private PredicateChecker(Predicate<E> predicate) {
			this.predicate = predicate;
		}
		
		@Override
		protected boolean check(E element) {
			return predicate.accept(element);
		}
		
	}
	
	private static class ParameterizedPredicateChecker<E, A> extends Checker<E> {

		private final ParameterizedPredicate<E, A> predicate;
		private final A arg;
		
		public ParameterizedPredicateChecker(ParameterizedPredicate<E, A> predicate, A arg) {
			this.predicate = predicate;
			this.arg = arg;
		}
		
		@Override
		protected boolean check(E element) {
			return predicate.accept(element, arg);
		}
		
	}
	
	private static<E> E getElementAt(Collection<E> elements, int position, Checker<E> checker) {
		checkPosition(position, elements.size());

        int offset = elements.size() - position;
        int error = 0;
        int hits = 0;
        
        for (E element : elements) {
        	
        	if (!checker.check(element)) {
        		if (error++ == offset) {
        			break;
        		}
        		continue;
        	}
        	
            if (hits++ == position) {
                return element;
            }
        }
        throw new IndexOutOfBoundsException("index: " + position);
	}
	
	private static <E> List<E> getElements(Collection<E> elements, Checker<E> checker) {
		List<E> ret = new ArrayList<E>();

        for (E element : elements) {
        	
            if (checker.check(element)) {
                ret.add(element);
            }
        }

        return ret;
	}
	
	private static <E> void each(Collection<E> elements, Checker<E> checker, Operation<E> operation) throws OperationException {
        for (E element : elements) {
        	
            if (checker.check(element)) {
                operation.execute(element);
            }
        }
    }
	
	/**
	 * 
	 * @param elements
	 * @param position
	 * @param finder
	 * @return
	 */
	public static <E> E getElementAt(Collection<E> elements, int position, Predicate<E> finder) {
		Checker<E> checker = new PredicateChecker<E>(finder);
		return getElementAt(elements, position, checker);
    }
	
	/**
	 * 
	 * @param elements
	 * @param position
	 * @param finder
	 * @param arg
	 * @return
	 */
	public static <E, A> E getElementAt(Collection<E> elements, int position, ParameterizedPredicate<E, A> finder, A arg) {
		Checker<E> checker = new ParameterizedPredicateChecker<E, A>(finder, arg);
		return getElementAt(elements, position, checker);
	}
	
	/**
	 * 
	 * @param elements
	 * @param finder
	 * @return
	 */
	public static <E> List<E> getElements(Collection<E> elements, Predicate<E> finder) {
		Checker<E> checker = new PredicateChecker<E>(finder);
		return getElements(elements, checker);
    }
	
	/**
	 * 
	 * @param elements
	 * @param finder
	 * @param arg
	 * @return
	 */
	public static <E, A> List<E> getElements(Collection<E> elements, ParameterizedPredicate<E, A> finder, A arg) {
		Checker<E> checker = new ParameterizedPredicateChecker<E, A>(finder, arg);
		return getElements(elements, checker);
    }

	/**
	 * 
	 * @param elements
	 * @param operation
	 * @throws OperationException
	 */
    public static <E> void each(Collection<E> elements, Operation<E> operation) throws OperationException {
    	each(elements, new AcceptAllChecker<E>(), operation);
    }

    /**
     * 
     * @param elements
     * @param finder
     * @param operation
     * @throws OperationException
     */
    public static <E> void each(Collection<E> elements, Predicate<E> finder, Operation<E> operation) throws OperationException {
    	Checker<E> checker = new PredicateChecker<E>(finder);
    	each(elements, checker, operation);
    }

    /**
     * 
     * @param elements
     * @param finder
     * @param arg
     * @param operation
     * @throws OperationException
     */
    public static <E, A> void each(Collection<E> elements, ParameterizedPredicate<E, A> finder, A arg, Operation<E> operation) throws OperationException {
    	Checker<E> checker = new ParameterizedPredicateChecker<E, A>(finder, arg);
    	each(elements, checker, operation);
    }

}
