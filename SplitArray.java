import java.util.Arrays;

/**
 *
 * Take an array of integers and split them odd left and even right then sort them.
 *
 */
public class SplitArray {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 6, 9, 2, 6, 11};
        splitArray(nums);
    }

    static int[] splitArray(int[] nums) {
        if(nums == null || nums.length == 0) return null;

        int leftPointer = 0;
        int rightPointer = nums.length - 1;


        // Time: O(n)
        // break out of the loop when leftPointer and rightPointer are equal
        while(leftPointer < rightPointer) {

            // find the even number on the left half
            while(nums[leftPointer] % 2 != 0) {
                ++leftPointer;
            }

            // find the odd number on the right half
            while(nums[rightPointer] % 2 == 0) {
                --rightPointer;
            }

            // if leftPointer is even or rightPointer is odd then swap
            if(nums[leftPointer] % 2 == 0 || nums[rightPointer] % 2 != 0) {
                swap(nums, leftPointer, rightPointer);
                ++leftPointer;
                --rightPointer;
            }
        }

        // sort each side
        // Time: O(nlogn)
        int pivot = nums.length / 2;
        Arrays.sort(nums, 0, pivot - 1);
        Arrays.sort(nums, pivot, nums.length - 1);

        for(Integer n : nums) System.out.print(n + " ");

        return nums;
    }

    static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
