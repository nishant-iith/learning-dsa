/*
Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.


Examples:
Input: nums = [8, 8, 7, 6, 5]
Output: 7
Explanation: The largest value in nums is 8, the second largest is 7

Input: nums = [10, 10, 10, 10, 10]
Output: -1
Explanation: The only value in nums is 10, so there is no second largest value, thus -1 is returned
 */

import java.util.*;

class Solution {
    // Function to find the second largest element
    public int secondLargestElement(int[] nums) {
        // code here
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