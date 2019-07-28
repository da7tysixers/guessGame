package com.Orubele;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /* This game was a remake of the game I learned from "Java ALL-IN-ONE by Doug Lowe".
        Reference:
        Learning made easy, Java ALL-IN-ONE, by Doug Lowe 5th Edition.

 */

    public static Scanner sc = new Scanner(System.in);
    public static int guess, number;
    public static String answer;
    public static boolean validInput;

    public static void main(String[] args) {


        System.out.println("Hello lets play a guessing game.");

        do {

            guessCheck();


        } while (askPlayAgain());
        System.out.println("Hurray thank you for playing.");

    }


    // Guess game body that evaluates to values and return void.
    public static void guessCheck() {
        try {
            number = roundNum();
            System.out.println("\n I`m thinking of a number between 1 and 10." + " Guess what number it is");
            guess = getInput();

            if (guess == number) {
                System.out.println("Great job you guessed the number right");
                System.out.println("  _______ ");
                System.out.println(" | o   o | ");
                System.out.println(" |   u   | ");
                System.out.println(" |_______| ");
            } else
                System.out.println("Wrong you are dead wrong. The number was: " + number);
        } catch (InputMismatchException e) {
             getInput();
             roundNum();
            System.out.println("Oops! you did not enter an integer.");
        }
    }


    // calculate random number
    public static int roundNum() {
        return (int) (Math.random() * 10) + 1;
    }


    public static int getInput() {
        while (true) {
            try {
                int guess = sc.nextInt();
                if ((guess < 1) || (guess > 10)) {
                    System.out.println("Invalid response. Please enter a number between 1 and 10");
                } else
                    return guess;
            } catch (InputMismatchException e) {
                sc.nextInt();
                System.out.println("Oops! That is not an integer.");
            }
        }
    }




    // Asks user if he/she wants to continue playing.
    public static boolean askPlayAgain() {
        // Asks user if they want to play again.

        while (true) {
                System.out.println("Do you want to play again? (Y / N).");
                answer = sc.next();
                if (answer.equalsIgnoreCase("Y"))
                    return true;
                else if (answer.equalsIgnoreCase("N"))
                    return false;

            }
        }

    }


