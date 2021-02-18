package com.microfocus;

import java.io.PrintStream;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static final String FIZZ_BUZZ = "FizzBuzz";
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public static final Function<Integer, Boolean> fizzBuzzValidator = (i -> i % 15 == 0);
    public static final Function<Integer, Boolean> buzzValidator = (i -> i % 5 == 0);
    public static final Function<Integer, Boolean> fizzValidator = (i -> i % 3 == 0);

    public void run(int n) {
        run(n, System.out);
    }

    public void run(int n, PrintStream printStream) {
        IntStream.range(1, n + 1).forEach((i) -> {
            if (fizzBuzzValidator.apply(i)) {
                printStream.println(FIZZ_BUZZ);
            } else if (buzzValidator.apply(i)) {
                printStream.println(BUZZ);
            } else if (fizzValidator.apply(i)) {
                printStream.println(FIZZ);
            } else {
                printStream.println(i);
            }
        });
    }

    public void run(int n, BiConsumer<Integer, String> consumer) {
        for (int i = 1; i <= n; i++) {
            if (fizzBuzzValidator.apply(i)) {
                consumer.accept(i, FIZZ_BUZZ);
            } else if (buzzValidator.apply(i)) {
                consumer.accept(i, BUZZ);
            } else if (fizzValidator.apply(i)) {
                consumer.accept(i, FIZZ);
            } else {
                consumer.accept(i, String.valueOf(i));
            }
        }
    }
}
