
import java.util.*;

class Solution {
    // Function to find the second largest element
    public int secondLargestElement(int[] nums) {
        int n = nums.length;

        // Check if the array has less than 2 elements
        if (n < 2) {
            // Indicating no second largest element is possible
            return -1;
        }

        // Sort the array in ascending order
        Arrays.sort(nums);

        // Largest element will be at last index
        int largest = nums[n - 1];

        int secondLargest = -1;

        // Traverse the sorted array from right to left
        for (int i = n - 2; i >= 0; i--) {

            /*
             * If the current element is not
             * equal to the largest element
             */
            if (nums[i] != largest) {

                /*
                 * Assign the current element
                 * as the second largest and break
                 */
                secondLargest = nums[i];
                break;
            }
        }

        // Return the second largest element
        return secondLargest;
    }
}

class Second_Largest_Element {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 6, 7, 5 };

        // Create an instance of the Solution class
        Solution sol = new Solution();

        /*
         * Call the method to find
         * the second largest element
         */
        int ans = sol.secondLargestElement(nums);

        System.out.println("The second largest element is: " + ans);
    }
}