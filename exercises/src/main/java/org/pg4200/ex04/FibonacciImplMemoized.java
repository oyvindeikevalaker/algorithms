package org.pg4200.ex04;

public class FibonacciImplMemoized implements Fibonacci {

    private final Integer[] cache = new Integer[100];

    @Override
    public int compute(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        if (n == 0 || n == 1) {
            return n;
        }

        if (n < cache.length && cache[n] != null) {
            return cache[n];
        }

        int sum = (compute(n - 1) + compute(n - 2));

        if (n < cache.length) {
            cache[n] = sum;
        }

        return sum;
    }
}
