/**
 * Implement the squareroot function
 *
 * Followup: Use binary search to find the optimal answer
 */
public class Squareroot {

    public static void main(String[] args) {
        System.out.println(sqrt(16));
    }

    /**
     * Algorithm Design
     *
     * Use binary search to find the square of a value
     *
     * if the square of the value is equal to the target number, return the value
     * If the square of the value is greater than the target number, search left
     * If the square of the value is less than the target number, search right
     */
    public static int sqrt(int num) {
        return sqrtHelper(num, 1, num);
    }

    public static int sqrtHelper(int num, int min, int max) {
        if(max < min) return -1;
        int val = (min + max) / 2;
        if(val * val == num)  return val;
        else if(val * val < num) return sqrtHelper(num, val + 1, max);
        else return sqrtHelper(num, min, val - 1);
    }

}
