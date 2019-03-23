package utils;

/**
 * The type Within bounds.
 */
public class WithinBounds {
    /**
     * Array check boolean.
     *
     * @param index the index
     * @param bound the bound
     * @return the boolean
     */
    public static boolean arrayCheck(int index, int bound) {
        return (index >= 0 && index < bound);
    }

    /**
     * Check boolean.
     *
     * @param lowBound  the low bound
     * @param highBound the high bound
     * @param index     the index
     * @return the boolean
     */
    public static boolean check(int lowBound, int highBound, int index) {
        return (index >= lowBound && index < highBound);
    }
}
