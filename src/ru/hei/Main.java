package ru.hei;

import java.util.Objects;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        String input = readInput();

        String dijkstraSortedInput = dijkstraSort( input );

        double result = calculateResult( dijkstraSortedInput );

        System.out.printf( "%s%n%.2f%n", dijkstraSortedInput, result );
    }

    private static String readInput()
    {
        System.out.println( "Please enter expression and press 'Enter'" );
        return new Scanner( System.in ).nextLine();
    }

    private static String dijkstraSort( String input )
    {
        return new Dijkstra( input ).sort();
    }

    private static double calculateResult( String input )
    {
        return new Calculator( input ).calculate();
    }
}

