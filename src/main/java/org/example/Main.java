package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 500;
        List<String> result = sequence(n);
        System.out.println(result);
    }

    public static List<String> sequence(int n) {
        if (n <= 0)
            return null;

        List<String> sequence = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                if (i % 7 == 0)
                    sequence.add("fizzbuzz");
                else
                    sequence.add("fizz");
            } else if (i % 7 == 0) {
                sequence.add("buzz");
            } else
                sequence.add(String.valueOf(i));
        }

        return sequence;
    }
}