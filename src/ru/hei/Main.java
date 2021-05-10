package ru.hei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            String input = readInput();

            if (input.isEmpty()) {
                System.exit(0);
            }

            String dijkstraSortedInput = dijkstraSort(input);

            double result = calculateResult(dijkstraSortedInput);

            System.out.printf("%s%n%.2f%n", dijkstraSortedInput, result);
        }
    }

    private static String readInput() {
        System.out.println("Please enter expression and press 'Enter' or empty line for exit");
        return new Scanner(System.in).nextLine();
    }

    private static String dijkstraSort(String input) {
        return new Dijkstra(input).sort();
    }

    private static double calculateResult(String input) {
        return new Calculator(input).calculate();
    }
}
