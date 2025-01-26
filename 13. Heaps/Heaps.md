# Heaps

- A. [About Heaps](#introduction)
- B. [Problems Practice](#problems-to-practice)

## Introduction

A heap is a specialized tree-based data structure that satisfies the heap property. There are two types:

### Max Heap
- Parent nodes are greater than or equal to their children
- Root node contains the maximum element

### Min Heap
- Parent nodes are less than or equal to their children
- Root node contains the minimum element

### Implementation
Heaps are typically implemented using arrays, where for an index i:
- Left child: 2i + 1
- Right child: 2i + 2
- Parent: (i - 1) / 2

### Operations & Time Complexity
1. **Insert** - O(log n)
    - Add element at end
    - Heapify up until heap property is restored

2. **Extract Max/Min** - O(log n)
    - Remove root element
    - Replace with last element
    - Heapify down until heap property is restored

3. **Peek** - O(1)
    - View root element without removal

4. **Build Heap** - O(n)
    - Convert array to heap structure

### Common Applications
- Priority Queues
- Heap Sort
- Graph algorithms (Dijkstra's)
- Memory management
- Event-driven simulation

### Key Properties
- Complete binary tree
- Height: O(log n)
- Space complexity: O(n)
### Implementation Examples

#### Direct Implementation (Max Heap)
```java
public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[maxSize];
    }

    private int parent(int pos) { return (pos - 1) / 2; }
    private int leftChild(int pos) { return (2 * pos) + 1; }
    private int rightChild(int pos) { return (2 * pos) + 2; }

    private void swap(int pos1, int pos2) {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    public void insert(int element) {
        if (size >= maxSize) return;
        
        heap[size] = element;
        int current = size;
        
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public int extractMax() {
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    private void heapifyDown(int pos) {
        int largest = pos;
        int left = leftChild(pos);
        int right = rightChild(pos);

        if (left < size && heap[left] > heap[largest])
            largest = left;
        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest != pos) {
            swap(pos, largest);
            heapifyDown(largest);
        }
    }
}
```

#### Using Java Collections
```java
// Max Heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

// Min Heap
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Basic operations
maxHeap.offer(element);    // Insert
maxHeap.poll();           // Extract max
maxHeap.peek();          // View max
maxHeap.size();          // Get size
maxHeap.isEmpty();       // Check if empty
```

### Comparison
- Direct implementation provides more control and understanding
- Collections API is more convenient and handles dynamic sizing
- Both maintain O(log n) time complexity for core operations

## Problems to practice

1. Leetcode Problems

    - [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/){:target="_blank"}
    - [23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/){:target="_blank"}
    - [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/){:target="_blank"}
    - [846. Hands of Straights](https://leetcode.com/problems/hands-of-straight/){:target="_blank"}
    - [355. Design Twitter](https://leetcode.com/problems/design-twitter/){:target="_blank"}
    - [703. Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/){:target="_blank"}
    - [295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/){:target="_blank"}
    - [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/){:target="_blank"}