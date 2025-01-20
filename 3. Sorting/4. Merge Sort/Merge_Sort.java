import java.util.*;

class Solution {
    // Function to merge two sorted halves of the array
    public void merge(int[] arr, int low, int mid, int high) {
        // Temporary array to store merged elements
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        // Loop until subarrays are exhausted
        while (left <= mid && right <= high) {
            // Compare left and right elements
            if (arr[left] <= arr[right]) {
                // Add left element to temp
                temp.add(arr[left]);
                // Move left pointer
                left++;
            } else {
                // Add right element to temp
                temp.add(arr[right]);
                // Move right pointer
                right++;
            }
        }

        // Adding the remaining elements of left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Adding the remaining elements of right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Transferring the sorted elements to arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    // Helper function to perform merge sort from low to high
    public void mergeSortHelper(int[] arr, int low, int high) {
        // Base case: if the array has only one element
        if (low >= high)
            return;

        // Find the middle index
        int mid = (low + high) / 2;
        // Recursively sort the left half
        mergeSortHelper(arr, low, mid);
        // Recursively sort the right half
        mergeSortHelper(arr, mid + 1, high);
        // Merge the sorted halves
        merge(arr, low, mid, high);
    }

    // Function to perform merge sort on the given array
    public int[] mergeSort(int[] nums) {
        int n = nums.length; // Size of array
        
        // Perform Merge sort on the whole array
        mergeSortHelper(nums, 0, n - 1);
        
        // Return the sorted array
        return nums;
    }
}

public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 6, 3, 1, 5};
        int n = arr.length;

        System.out.println("Before Sorting Array: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        // Create an instance of the Solution class
        Solution sol = new Solution();
        // Function call to sort the array
        int[] sortedArr = sol.mergeSort(arr);

        System.out.println("After Sorting Array: ");
        for (int i = 0; i < n; i++)
            System.out.print(sortedArr[i] + " ");
        System.out.println();
    }
}