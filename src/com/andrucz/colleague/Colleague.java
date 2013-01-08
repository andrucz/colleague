package com.andrucz.colleague;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.andrucz.commons.conversion.ElementConverter;
import com.andrucz.commons.operation.Operation;
import com.andrucz.commons.operation.OperationException;
import com.andrucz.predicate.AcceptAllPredicate;
import com.andrucz.predicate.Predicate;

import static com.andrucz.commons.check.Checks.checkNotNull;
import static com.andrucz.commons.check.Checks.checkPosition;

public final class Colleague {
	
	public static<E> E get(Collection<E> elements, int position, Predicate<E> predicate) {
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
	
	public static <E> List<E> list(Collection<E> elements, Predicate<E> predicate) {
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
	
	
	public static <E, R> List<R> convert(Collection<E> elements, Predicate<E> predicate, ElementConverter<E, R> converter) {
		checkNotNull(predicate, "predicate");
		checkNotNull(converter, "converter");
		
		List<R> result = new ArrayList<R>();
		
		for (E element : elements) {
			if (predicate.accept(element)) {
				R converted = converter.convert(element);
				result.add(converted);
			}
		}
		
		return result;
	}
	
	public static <E, R> List<R> convert(Collection<E> elements, ElementConverter<E, R> converter) {
		return convert(elements, new AcceptAllPredicate<E>(), converter);
	}
}
