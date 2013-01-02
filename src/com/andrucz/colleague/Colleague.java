package com.andrucz.colleague;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class Colleague {
	
	private static void checkPosition(int position, int size) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Index: " + position + " Size: " + size);
        }
    }
	
	public static <E> E getElementAt(Collection<E> elements, int position, Predicate<E> finder) {
        checkPosition(position, elements.size());

        int count = 0;
        
        for (E element : elements) {
        	
        	if (!finder.accept(element)) {
        		continue;
        	}
        	
            if (count++ == position) {
                return element;
            }
        }
        return null;
    }
	
	/**
	 * 
	 * @param finder
	 * @param argument
	 * @param elements
	 * @param position
	 * @return
	 */
	public static <E, A> E getElementAt(Collection<E> elements, int position, ParameterizedPredicate<E, A> finder, A argument) {
        checkPosition(position, elements.size());

        int count = 0;
        for (E element : elements) {
        	
        	if (!finder.accept(element, argument)) {
        		continue;
        	}
        	
            if (count++ == position) {
                return element;
            }
        }
        return null;
    }
	
	/**
	 * 
	 * @param finder
	 * @param elements
	 * @return
	 */
	public static <E> List<E> getElements(Collection<E> elements, Predicate<E> finder) {
        List<E> ret = new ArrayList<E>();

        for (E element : elements) {
        	
            if (finder.accept(element)) {
                ret.add(element);
            }
        }

        return ret;
    }
	
	/**
	 * 
	 * @param finder
	 * @param argument
	 * @param elements
	 * @return
	 */
	public static <E, A> List<E> getElements(Collection<E> elements, ParameterizedPredicate<E, A> finder, A argument) {
        List<E> ret = new ArrayList<E>();

        for (E element : elements) {
        	
            if (finder.accept(element, argument)) {
                ret.add(element);
            }
        }

        return ret;
    }

	/**
	 * 
	 * @param elements
	 * @param operation
	 * @throws OperationException 
	 */
    public static <E> void each(Collection<E> elements, Operation<E> operation) throws OperationException {
        for (E element : elements) {
            operation.execute(element);
        }
    }

    /**
     * 
     * @param finder
     * @param elements
     * @param operation
     * @throws OperationException 
     */
    public static <E> void each(Predicate<E> finder, Collection<E> elements, Operation<E> operation) throws OperationException {
        for (E element : elements) {
        	
            if (finder.accept(element)) {
                operation.execute(element);
            }
        }
    }

    /**
     * 
     * @param finder
     * @param argument
     * @param elements
     * @param operation
     * @throws OperationException 
     */
    public static <E, A> void each(Collection<E> elements, ParameterizedPredicate<E, A> finder, A argument, Operation<E> operation) throws OperationException {
        for (E element : elements) {
        	
            if (finder.accept(element, argument)) {
                operation.execute(element);
            }
        }
    }

}
