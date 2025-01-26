# Binary Trees

- A. [About Binar Trees](#introduction)
- B. [Problems Practice](#problems-to-practice)

## Introduction
- A binary tree is a hierarchical data structure where each node has at most two children
- Nodes are connected by edges, forming a tree-like structure
- First node is called the root node

## Basic Terms
- **Root**: Top node of the tree
- **Node**: Contains data and references to children
- **Leaf**: Node with no children
- **Height**: Length of path from root to deepest node
- **Depth**: Length of path from root to specific node

## Types of Binary Trees
1. **Full Binary Tree**
    - Each node has 0 or 2 children
    
2. **Complete Binary Tree**
    - All levels filled except possibly last level
    - Last level filled from left to right

3. **Perfect Binary Tree**
    - All internal nodes have 2 children
    - All leaves at same level

## Basic Operations & Time Complexity
| Operation | Average Case | Worst Case |
|-----------|--------------|------------|
| Insertion | O(logn) | O(n) |
| Deletion  | O(logn) | O(n) |
| Search    | O(logn) | O(n) |

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

## Tree Traversals
1. **In-order (Left, Root, Right)**
    - Time Complexity: O(n)
    ```java
    inorder(node):
      if node != null:
         inorder(node.left)
         print(node.data)
         inorder(node.right)
    ```

2. **Pre-order (Root, Left, Right)**
    - Time Complexity: O(n)

3. **Post-order (Left, Right, Root)**
    - Time Complexity: O(n)

## Common Operations
- Insert node
- Delete node
- Find height
- Find depth
- Count nodes
- Check if balanced

## Applications
- Expression trees
- Binary Search Trees
- Heap implementation
- Huffman coding
- Priority Queues

## Space Complexity
- Best Case: O(n)
- Average Case: O(n)
- Worst Case: O(n)

## Common Interview Questions
1. Find maximum depth
2. Check if tree is balanced
3. Convert to mirror image
4. Level order traversal
5. Lowest common ancestor

## Problems to practice

1. Leetcode Problems

    - [94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)
    - [144. Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/)
    - [145. Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/)
    - [104. Binary Tree Maximum Depth](https://leetcode.com/problems/binary-tree-maximum-depth/)
    - [110. Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)
    - [543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)
    - [124. Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
    - [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)


