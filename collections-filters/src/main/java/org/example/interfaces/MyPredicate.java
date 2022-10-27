package org.example.interfaces;

@FunctionalInterface
public interface MyPredicate<T, V> {
    boolean test(T t, V v);
}
