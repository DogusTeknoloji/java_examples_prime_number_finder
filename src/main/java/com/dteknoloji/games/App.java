package com.dteknoloji.games;

import java.io.PrintStream;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Prime Number Finder");
        Scanner scanner = new Scanner(System.in);

        System.out.print("End Number = ");
        int endNumber = scanner.nextInt();

        Instant starts = Instant.now();
        int count = findPrimeNumber(endNumber, System.out);
        Instant ends = Instant.now();
        System.out.println();
        System.out.printf("Found %d items at %d milli-seconds.\n" , count, Duration.between(starts, ends).toMillis());
        System.out.println();

        starts = Instant.now();
        count = findPrimeNumber2(endNumber, System.out);
        ends = Instant.now();
        System.out.println();
        System.out.printf("Found %d items at %d milli-seconds.\n" , count, Duration.between(starts, ends).toMillis());
    }

    private static int findPrimeNumber(int endNumber, PrintStream out) {
        out.print("2");
        boolean found;
        int count = 1;
        for (int index = 3; index <= endNumber; index += 2) {
            found = false;
            for (int subIndex = index - 1; subIndex >= 2; subIndex--) {
                if (index % subIndex == 0) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                count++;
                out.print(", ");
                if (count % 20 == 0) out.println();
                out.print(index);
            }
        }
        return count;
    }


    private static int findPrimeNumber2(int endNumber, PrintStream out) {
        Set<Integer> primeNumbers = new HashSet<Integer>();
        primeNumbers.add(2);
        out.print("2");
        boolean found;
        for (int index = 3; index <= endNumber; index += 2) {
            found = false;
            for (int subIndex : primeNumbers) {
                if (index % subIndex == 0) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                primeNumbers.add(index);
                out.print(", ");
                if (primeNumbers.size() % 20 == 0) out.println();
                out.print(index);
            }
        }
        return primeNumbers.size();
    }
}
