package com.andrucz.colleague;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.andrucz.colleague.operation.Operation;
import com.andrucz.colleague.operation.OperationException;
import com.andrucz.colleague.predicate.AcceptAllPredicate;
import com.andrucz.colleague.predicate.Predicate;

import static com.andrucz.colleague.util.Checks.checkNotNull;
import static com.andrucz.colleague.util.Checks.checkPosition;

public final class Colleague {
	
	public static<E> E getElementAt(Collection<E> elements, int position, Predicate<E> predicate) {
		checkNotNull(predicate, "predicate");
		checkPosition(position, elements.size());

        int offset = elements.size() - position;
        int error = 0;
        int hits = 0;
        
        for (E element : elements) {
        	
        	if (!predicate.accept(element)) {
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
	
	public static <E> List<E> getElements(Collection<E> elements, Predicate<E> predicate) {
		checkNotNull(elements, "elements");
		checkNotNull(predicate, "predicate");
		
		List<E> ret = new ArrayList<E>();

        for (E element : elements) {
        	
            if (predicate.accept(element)) {
                ret.add(element);
            }
        }

        return ret;
	}
	
	public static <E> void each(Collection<E> elements, Predicate<E> predicate, Operation<E> operation) throws OperationException {
		checkNotNull(predicate, "predicate");
		checkNotNull(operation, "operation");
		
		operation.prepare();
		
        for (E element : elements) {
        	
            if (predicate.accept(element)) {
                operation.execute(element);
            }
        }
        operation.finish();
    }
	
	public static <E> void each(Collection<E> elements, Operation<E> operation) throws OperationException {
		each(elements, new AcceptAllPredicate<E>(), operation);
	}
	
	public static <E> boolean remove(Collection<E> elements, Predicate<E> predicate) {
		checkNotNull(predicate, "predicate");
		
		Iterator<E> iterator = elements.iterator();
		boolean result = false;
		
		while (iterator.hasNext()) {
			E element = iterator.next();
			
			if (predicate.accept(element)) {
				iterator.remove();
				result = true;
			}
		}
		
		return result;
	}

	public static <E> boolean add(Collection<E> target, Collection<E> source, Predicate<E> predicate) {
		checkNotNull(target, "target");
		checkNotNull(predicate, "predicate");
		
		boolean result = false;
		
		for (E element : source) {
			if (predicate.accept(element)) {
				result |= target.add(element);
			}
		}
		
		return result;
	}
	
	public static <E> int count(Collection<E> elements, Predicate<E> predicate) {
		checkNotNull(predicate, "predicate");
		
		int n = 0;
		
		for (E element : elements) {
			if (predicate.accept(element)) {
				n++;
			}
		}
		
		return n;
	}
	
	public static <E> boolean contains(Collection<E> elements, Predicate<E> predicate) {
		checkNotNull(predicate, "predicate");
		
		for (E element : elements) {
			if (predicate.accept(element)) {
				return true;
			}
		}
		
		return false;
	}
	
}
