package com.dteknoloji.games;

import java.io.PrintStream;
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

        Instant start = Instant.now();
        findPrimeNumber(endNumber, System.out);
        System.out.println();
        findPrimeNumber2(endNumber, System.out);
    }

    private static void findPrimeNumber(int endNumber, PrintStream out) {
        out.print("2");
        boolean found;
        for (int index = 3; index <= endNumber; index += 2) {
            found = false;
            for (int subIndex = index - 1; subIndex >= 2; subIndex--) {
                if (index % subIndex == 0) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                out.print(", ");
                out.print(index);
            }
        }
    }


    private static void findPrimeNumber2(int endNumber, PrintStream out) {
        Set<Integer> primeNumbers = new HashSet<Integer>();
        primeNumbers.add(2);
        out.print("2");
        boolean found;
        for (int index = 3; index <= endNumber; index += 2) {
            found = false;
            for(int subIndex : primeNumbers){
                if (index % subIndex == 0) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                primeNumbers.add(index);
                out.print(", ");
                out.print(index);
            }
        }
    }
}
