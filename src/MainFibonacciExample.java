/**
 * This is an example that shows
 * how the Fibonacci Sequence works
 * and how it can be implemented by
 * different methods that exist in
 * branches of this repo.
 *
 * @since 16/05/2025
 * @author Constantine Lekkos
 */
public class MainFibonacciExample {
    public static void main(String[] args) {
        // Actual Fibonacci Sequence (FS) of 9 elements
        int[] testArray = new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21 };

        // Each element of the FS is the sum of the 2 elements that precede it
        System.out.print("Actual FS: ");
        for (var num : testArray) {
            System.out.print(num + " ");
        }

        System.out.println("\nIn example, the number 5 with index 5 must be equal with " +
                "the sum of the 2 elements that precede it. So, with numbers 2 and 3.\n");

        // For-loop to check every condition. For n = 0 => FS = 0 and for n = 1 => FS = 1
        for (int i = 2; i < testArray.length; i++) {
            System.out.printf("%d = %d + %d\n", testArray[i], testArray[i - 2], testArray[i - 1]);
        }

        System.out.println("\nWhich is validated above.");
    }
}
