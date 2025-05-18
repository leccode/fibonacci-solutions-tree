package tree.solutions.iterative;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * This computational approach
 * finds the Fibonacci number
 * of the Sequence using a for-loop.
 * User gives an input and then
 * the FS is calculated and saved
 * in an array, and returns
 * the element of the given n as an index.
 * Do not use large numbers.
 * The other approach is to return the
 * whole FS array. See comments.
 *
 * @since 17/05/2025
 * @author Constantine Lekkos
 */
public class IterativeFibonacci {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String userInput;
        BigInteger n;
        BigInteger[] outcome;

        try {
            System.out.print("Please, set an integer: ");

            while (!isInteger(userInput = getAnInput())) {
                System.out.print("Characters are not valid. Please, set an integer: ");
            }

            System.out.print("Loading. . . Please, wait!\n");

            n = new BigInteger(userInput);
            outcome = iterativeFibonacci(n);
            checkNegativeOutcome(outcome);
            System.out.printf("\nThe Fibonacci of %d is: %,d\n", n, outcome[0]);
//            System.out.print("\nFS: {");
//            for (var element : outcome) {
//                if (element.equals(BigInteger.ZERO)) System.out.print(" " + element);
//                System.out.print(", " + element);
//            }
//            System.out.print(" }");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * This method is the iterative form
     * of FS and creates an array of the given
     * n and then, calculates the Fibonacci Sequence
     * in a for-loop.
     *
     * @param n The user input.
     * @return the n as the index of the element.
     */
    public static BigInteger[] iterativeFibonacci(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) < 0) return new BigInteger[]{BigInteger.ONE.negate()};
        if (n.equals(BigInteger.ZERO)) return new BigInteger[]{BigInteger.ZERO};

        if (n.compareTo(BigInteger.valueOf(100_000)) > 0) {
            System.out.println("Warning: Switching to memory-efficient computation...");
            return computeWithoutArray(n);
        }

        int sizeOfFibonacciArray = n.intValue() + 1;
        BigInteger[] fibonacciSequence = new BigInteger[sizeOfFibonacciArray];
        fibonacciSequence[0] = BigInteger.ZERO;

        if (sizeOfFibonacciArray > 1) {
            fibonacciSequence[1] = BigInteger.ONE;

            for (int i = 2; i < sizeOfFibonacciArray; i++) {
                fibonacciSequence[i] = fibonacciSequence[i - 1].add(fibonacciSequence[i - 2]);
            }
        }
        //return fibonacciSequence; // This is used to return the whole FS array
        return new BigInteger[]{fibonacciSequence[n.intValue()]};
    }

    /**
     * This method takes place
     * when the n is larger than
     * the required (e.g. 100_000)
     * for optimized calculations.
     *
     * @param n The user input.
     * @return the calculated Fibonacci.
     */
    public static BigInteger[] computeWithoutArray(BigInteger n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        for (BigInteger i = BigInteger.ONE; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
            BigInteger next = a.add(b);
            a = b;
            b = next;
        }
        return new BigInteger[]{b};
    }

    /**
     * This helper method informs the user
     * if a negative value is set by the keyboard
     * and encourages to try a new one.
     *
     * @param outcome The result to be checked.
     */
    public static void checkNegativeOutcome(BigInteger[] outcome) {
        if (outcome != null && outcome.length > 0 && outcome[0].compareTo(BigInteger.ZERO) < 0)
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
