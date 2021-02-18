package com.microfocus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

import static com.microfocus.FizzBuzz.*;

public class FizzBuzzTests {

    @Test
    public void test_01_fizzBuzz() throws IOException {
        String ls = System.lineSeparator();
        String expectedResult = "1" + ls + "2" + ls + "Fizz" + ls + "4" + ls + "Buzz" + ls + "Fizz" + ls + "7" + ls +
                "8" + ls + "Fizz" + ls + "Buzz" + ls + "11" + ls + "Fizz" + ls + "13" + ls + "14" + ls + "FizzBuzz" + ls;

        ByteArrayOutputStream ourFizzBuzzResultCharactersStream = new ByteArrayOutputStream();

        try {
            PrintStream ps = new PrintStream(ourFizzBuzzResultCharactersStream);

            int n = 15;

            System.out.println("Running FizzBuzz for N = " + n);

            FizzBuzz fizzBuzz = new FizzBuzz();
            fizzBuzz.run(n, ps);

            ps.flush();
            String result = ourFizzBuzzResultCharactersStream.toString();
            System.out.println("Output from FizzBuzz implementation:" + result);

            Assertions.assertEquals(expectedResult, result);
        } finally {
            ourFizzBuzzResultCharactersStream.close();
        }
    }

    @Test
    public void test_02_fizzBuzz() {
        Random random = new Random(System.currentTimeMillis());
        FizzBuzz fizzBuzz = new FizzBuzz();
        int n = random.nextInt(300);

        System.out.println("Running FizzBuzz for N = " + n);

        fizzBuzz.run(n, (i, output) -> {
            System.out.println(String.format("Received value from FizzBuzz i: %d, output: %s", i, output));

            if(i % 15 == 0) {
                Assertions.assertEquals(FIZZ_BUZZ, output);
            } else if(i % 5 == 0) {
                Assertions.assertEquals(BUZZ, output);
            } else if(i % 3 == 0) {
                Assertions.assertEquals(FIZZ, output);
            } else {
                Assertions.assertEquals(String.valueOf(i), output);
            }
        });
    }
}
