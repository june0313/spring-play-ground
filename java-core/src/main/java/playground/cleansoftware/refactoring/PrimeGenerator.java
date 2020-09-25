/**
 * This class Generates prime numbers up to a user specified maximum.
 * the algorithm used is the Sieve of Eratosthenes.
 * <p>
 * Eratosthenes of Cyrene, b. c. 276 BC, Cyrene, Libya --
 * d. c. 194, Alexandria.  The first man to calculate the circumference
 * of the Earth.  Also known for working on calendars with leap
 * years and ran the library at Alexandria.
 * <p>
 * The algorithm is quite simple.  Given an array of integers starting
 * at 2.  Cross out all multiples of 2.  Find the next uncrossed
 * integer, and cross out all of its multiples.  Repeat until
 * you have passed the square root of the maximum value.
 *
 * @author Robert C. Martin
 * @version 9 Dec 1999 rcm
 */
package playground.cleansoftware.refactoring;

/**
 * Class declaration
 *
 *
 * @author Robert C. Martin
 * @version %I%, %G%
 */
public class PrimeGenerator {
    private static boolean[] crossedOut;
    private static int[] result;

    /**
     * @param maxValue is the generation limit.
     */
    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2) {
            return new int[0]; // return null array if bad input.
        } else {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;  // return the primes
        }
    }

    private static void uncrossIntegersUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];

        for (int i = 2; i < crossedOut.length; i++) {
            crossedOut[i] = false;
        }
    }

    private static void crossOutMultiples() {
        int limit = determineIterationLimit();
        for (int i = 2; i <= limit; i++) {
            if (notCrossed(i)) {
                crossOutMultiplesOf(i);
            }
        }
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i; multiple < crossedOut.length; multiple += i) {
            crossedOut[multiple] = true;
        }
    }

    private static boolean notCrossed(int i) {
        return !crossedOut[i];
    }

    private static int determineIterationLimit() {
        return (int) Math.sqrt(crossedOut.length);
    }

    private static void putUncrossedIntegersIntoResult() {
        result = new int[numberOfUncrossedIntegers()];
        for (int j = 0, i = 2; i < crossedOut.length; i++) {
            if(notCrossed(i)) {
                result[j++] = i;
            }
        }
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;

        for (int i = 2; i < crossedOut.length; i++) {
            if (notCrossed(i)) {
                count++;
            }
        }

        return count;
    }
}

