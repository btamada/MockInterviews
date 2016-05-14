/**
 * Create a func that sorts an array in constant time
 */
public class DuplicateArrConst {

    public static void main(String[] args) {
        int[] nums = {3, 4, 0, 2, 5, 1};
        System.out.println(dupElemArr(nums));
    }

    /**
     * Algorithm Design
     *
     * Constraints: O(1) space
     *
     * Approach: Use a swapping sort algorithm to find any duplicate elements
     *
     * Assumptions:
     * - Non-negative integers
     * - No integers exceed length of the array
     *
     * [0, 1, 2, 3, 4, 2]
     *
     * (0, 3)
     * (1, 4)
     * (2, 0)
     * (3, 2)
     * (4, 1)
     *
     * Time: O(n), where n is the length of the nums array
     * Space: O(1), where we are using a swapping method to sort the elements
     *
     */
    public static boolean dupElemArr(int[] nums) {
        if(nums == null || nums.length == 0) return false;

        // sort elements using array indices to find their appropriate location
        // O(n) - Iterate through the entire nums array and swap elements
        for(int i = 0; i < nums.length; i++) {

            // if not in the correct location
            if(nums[i] != i) {

                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;

            }
        }

        // O(n) - Iterate through nums array to find duplicates
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) return true;
        }

        return false;
    }

}
