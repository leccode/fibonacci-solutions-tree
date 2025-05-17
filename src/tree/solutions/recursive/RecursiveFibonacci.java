package tree.solutions.recursive;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * This computational approach
 * finds the given n by a user
 * of Fibonacci Sequence.
 * ** Recursive Caution ** --> If a big
 * value of n (e.g n = 50) is set
 * then the program will need time
 * to process it. Set wisely!
 *
 * @since 17/05/2025
 * @author Constantine Lekkos
 */
public class RecursiveFibonacci {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String userInput;
        BigInteger n;
        BigInteger outcome;

        try {
            System.out.print("Please, set an integer: ");

            while (!isInteger(userInput = getAnInput())) {
                System.out.print("Characters are not valid. Please, set an integer: ");
            }

            System.out.print("Loading. . . Please, wait!\n");

            n = new BigInteger(userInput);
            outcome = recursiveFibonacci(n);
            checkNegativeOutcome(outcome);
            System.out.printf("\nThe Fibonacci of %d is: %,d\n", n, outcome);
        } catch (StackOverflowError e) {
            System.err.println("\nError: " + e + ". Please, use a smaller number. .");
        }
    }

    /**
     * This method is the recursive form of FS
     * and takes an integer as input to perform the
     * calculations. This method breaks the procedures
     * into smaller problems solving them individually.
     *
     * @param n The given integer.
     * @return the calculated Fibonacci number.
     */
    public static BigInteger recursiveFibonacci(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) < 0) return BigInteger.ONE.negate();;
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) return n;
        return recursiveFibonacci(n.subtract(BigInteger.TWO))
                .add(recursiveFibonacci(n.subtract(BigInteger.ONE)));
    }

    /**
     * This helper method informs the user
     * if a negative value is set by the keyboard
     * and encourages to try a new one.
     *
     * @param outcome The result to be checked.
     */
    public static void checkNegativeOutcome(BigInteger outcome) {
        if (outcome.compareTo(BigInteger.ZERO) < 0)
            System.out.println("\nFibonacci cannot be solved with negative values. Please, try again!");
    }

    /**
     * This helper method sets
     * an input by the keyboard.
     *
     * @return the input.
     */
    public static String getAnInput() {
        return scanner.nextLine();
    }

    /**
     * This helper method takes a user string
     * and checks if it only contains numbers.
     *
     * @param inputString The actual string by the keyboard.
     * @return true if yes, otherwise, false.
     */
    public static boolean isInteger(String inputString) {
        return inputString.matches("-?\\d+");
    }
}
