package com.andrucz.colleague.util;

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
	
}
