class Solution {
    // Function to recursively heapify the array downwards
    private void heapifyDown(int[] arr, int last, int ind) {
        // Index of largest element
        int largestInd = ind; 

        // Indices of the left and right children
        int leftChildInd = 2 * ind + 1, rightChildInd = 2 * ind + 2;
        
        // If the left child holds larger value, update the largest index
        if(leftChildInd <= last && arr[leftChildInd] > arr[largestInd]) {
            largestInd = leftChildInd;
        }

        // If the right child holds larger value, update the largest index
        if(rightChildInd <= last && arr[rightChildInd] > arr[largestInd]) {
            largestInd = rightChildInd;
        }

        // If the largest element index is updated
        if(largestInd != ind) {
            // Swap the largest element with the current index
            int temp = arr[largestInd];
            arr[largestInd] = arr[ind];
            arr[ind] = temp;

            // Recursively heapify the lower subtree
            heapifyDown(arr, last, largestInd);
        }
        return; 
    }

    // Function to build Max-heap from the given array
    private void buildMaxHeap(int[] nums) {
        int n = nums.length;
        
        // Iterate backwards on the non-leaf nodes
        for(int i = n / 2 - 1; i >= 0; i--) {
            // Heapify each node downwards
            heapifyDown(nums, n - 1, i);
        }
        return;
    }

    // Function to sort the array using heap-sort
    public void heapSort(int[] nums) {
        
        // Function call to build a max-heap from the given array
        buildMaxHeap(nums);
        
        // To store the last Index
        int last = nums.length - 1; 
        
        // Until there are elements left to sort in the array
        while(last > 0) {
            // Swap the greatest element to the current last index
            int temp = nums[0];
            nums[0] = nums[last];
            nums[last] = temp;

            last--; // Decrement the last index
            
            if(last > 0) {
                // Heapify down the root
                heapifyDown(nums, last, 0);
            }
        }
        
        return;
    }
}

// Driver code in a separate Main class
class Heap_Sort {
    public static void main(String[] args) {
        int[] nums = {60, 30, 40, 20, 10, 50};
        
        System.out.print("Input Array: ");
        for(int x : nums) {
            System.out.print(x + " ");
        }
        
        // Creating an object of Solution class
        Solution sol = new Solution();
        
        // Function call to sort the array using heap-sort
        sol.heapSort(nums);
        
        System.out.print("\nSorted Array: ");
        for(int x : nums) {
            System.out.print(x + " ");
        }
    }
}
