package com.andrucz.colleague.util;

import java.util.Collection;

public final class Checks {

	private Checks() {
	}
	
	public static void checkPosition(int position, int size) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Index: " + position + " Size: " + size);
        }
    }
	
	public static void checkNotNull(Object o, String message) {
		if (o == null) {
			throw new NullPointerException(message);
		}
	}
	
	public static void checkNotEmpty(Collection<?> c, String collectionName) {
		if (c.isEmpty()) {
			throw new IllegalArgumentException(collectionName + " cannot be empty.");
		}
	}
	
	public static void checkNotEmpty(Object[] array, String arrayName) {
		if (array.length == 0) {
			throw new IllegalArgumentException(arrayName + " cannot be empty.");
		}
	}
	
}
