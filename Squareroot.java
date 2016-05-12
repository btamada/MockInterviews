/**
 * Implement the squareroot function
 *
 * Followup: Use binary search to find the optimal answer
 */
public class Squareroot {

    public static void main(String[] args) {
        System.out.println(squareRoot(16.5));
    }

    /**
     *
     * Algorithm Design
     *
     * Handles floating point numbers as well
     * Round up to nearest integer (Math.ceil) for uneven squares
     *
     * sqrt(16) -> 4
     * 15 -> 3
     * 12 -> 3
     * 11 -> 3
     * 10 -> 3
     * 9 -> 3
     *
     * @param num - the number to find the square root of
     * @return - the square root result
     */
    public static int squareRoot(double num) {
        if(num < 0) throw new IllegalArgumentException("Invalid input");
        if(num == 0 || num == 1 || num > Float.MAX_VALUE) return (int) num;

        for(int i = (int) (num / 2); i >= 1; i--) {
            if(i * i <= (int) num) return i;
        }

        return -1;
    }

}
