/*
Given an array of integers nums and an integer target, find the smallest index (0 based indexing) where the target appears in the array. If the target is not found in the array, return -1

Examples:
Input: nums = [2, 3, 4, 5, 3], target = 3
Output: 1
Explanation: The first occurence of 3 in nums is at index 1

Input: nums = [2, -4, 4, 0, 10], target = 6
Output: -1
Explanation: The value 6 does not occur in the array, hence output is -1

*/


import java.util.*;
class Linear_Search {
// Linear Search Function
    public int linearSearch(int[] nums, int target) {
        // code here

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 4;

        // Create an instance of the Solution class
        Linear_Search sol = new Linear_Search();

         // Call the linearSearch method
        int result = sol.linearSearch(nums, target);
        
        System.out.println(result);
    }
}
