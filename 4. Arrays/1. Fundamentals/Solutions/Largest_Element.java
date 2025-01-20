import java.util.*;

class Largest_Element {
    public static int largestElement(int[] nums) {
        // Sort array
        Arrays.sort(nums);  // Arrays.sort() sorts the array in ascending order - Java Collections Framework

        /*
         * Largest element will be at
         * the last index of the array.
         */
        int largest = nums[nums.length - 1];

        // Return the largest element in array.
        return largest;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 2 };
        int largest = largestElement(nums);

        // Print the largest element.
        System.out.print(largest);
    }
}