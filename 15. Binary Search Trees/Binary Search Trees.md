# Binary Search Trees

- A. [About BST](#introduction-bst)
- B. [Problems Practice](#problems-to-practice)

## Introduction BST
- A binary search tree is a binary tree with ordering property
- For each node, all left subtree values are less than node's value
- For each node, all right subtree values are greater than node's value
- Efficient for searching, insertion, and deletion operations

## Basic Properties
- **Ordered Structure**: Left < Node < Right
- **No Duplicates**: Typically, BST doesn't allow duplicate values
- **Balance Factor**: Affects performance significantly
- **Height**: Minimum log₂(n+1), Maximum n-1

## Types of BST
1. **AVL Trees**
    - Self-balancing BST
    - Balance factor of -1, 0, or 1
    
2. **Red-Black Trees**
    - Self-balancing BST
    - Guarantees O(log n) operations

## Operations & Time Complexity
| Operation | Average Case | Worst Case |
|-----------|--------------|------------|
| Insert    | O(log n)    | O(n)       |
| Delete    | O(log n)    | O(n)       |
| Search    | O(log n)    | O(n)       |

## Implementation (Basic Structure)
```java
class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
```

## Common Operations
- Insert value
- Delete value
- Search value
- Find min/max
- Successor/Predecessor
- Validate BST

## Applications
- Database indexing
- Priority queues
- Symbol tables
- Memory allocation

## Space Complexity
- Best Case: O(n)
- Average Case: O(n)
- Worst Case: O(n)

## Common Interview Questions
1. Validate BST
2. Find kth smallest element
3. Convert sorted array to BST
4. Find LCA in BST
5. Delete node in BST

## Problems to practice

1. Leetcode Problems

    - [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)
    - [230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)
    - [700. Search in a Binary Search Tree](https://leetcode.com/problems/search-in-a-binary-search-tree/)
    - [701. Insert into a Binary Search Tree](https://leetcode.com/problems/insert-into-a-binary-search-tree/)
    - [450. Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-binary-search-tree/)
    - [235. Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
    - [108. Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)