# Understanding Recursion in Data Structures and Algorithms

## Function Overview
A function is a reusable block of code designed to perform a specific task. It can:
- Take input (parameters)
- Return a result
- Break down complex problems into smaller, manageable pieces

## Recursion Fundamentals

### Definition
Recursion occurs when a function calls itself directly or indirectly to solve a problem. It's an elegant approach to handle problems that can be broken down into smaller, similar subproblems.

### Infinite Recursion
Infinite recursion happens when a function lacks a base condition to stop recursive calls, leading to indefinite function calls and potential stack overflow.

#### Example of Infinite Recursion
```java
class Main {
    static void infiniteRecursion() {
        System.out.println("Calling function");
        infiniteRecursion();
    }
}
```

### Base Case/Condition
The base case is a stopping condition in recursive functions that prevents infinite recursion. It defines the simplest problem instance solvable without further recursion.

### Recursive Stack Space
- Each recursive function call adds a new frame to the function call stack
- Tracks current function execution
- Unwinds when base condition is met, returning results in reverse order

### Program Flow in Recursion
1. Recursive function called creates a new function instance
2. Control passed to new instance
3. Continues until base case reached
4. Stack starts unwinding, returning results step by step

## Types of Recursion

### Head Recursion
Recursive call occurs before any other processing. Function waits for recursive call to return before proceeding.

```java
class Main {
    static void headRecursion(int n) {
        if (n > 0) {
            headRecursion(n - 1);  // Recursive call before processing
            System.out.print(n + " ");
        }
    }
}
```

### Tail Recursion
Recursive call is the last operation in the function. Compiler can optimize tail recursion as no state needs to be retained.

```java
class Main {
    static void tailRecursion(int n) {
        if (n == 0)
            return;
        System.out.print(n + " ");  // Processing before recursion
        tailRecursion(n - 1);       // Recursive call is last action
    }
}
```

## Complexity Analysis

### Time Complexity
- Generally based on number of recursive calls
- If one recursive call made, time complexity is O(n)
- n represents recursion depth

### Space Complexity
- Determined by maximum recursive call stack depth
- If maximum recursion depth is n, space complexity is O(n)

## Stack Overflow
- Occurs when too many recursive calls are made
- Happens without base case or when recursion depth exceeds system's call stack limit
- Causes program to crash due to insufficient stack space

## Recursion Tree
Visual representation showing:
- Problem division into subproblems
- Flow of recursive calls
- Difference between head and tail recursion structures

## Factorial Recursion Example

### Intuition
Factorial calculation involves multiplying a number by each smaller positive integer down to 1.

### Approach
1. Define factorial function
2. Base case: return 1 for 0 or 1
3. Recursive case: multiply number by factorial of (number - 1)

### Java Implementation
```java
class Solution {
    public long factorial(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n <= 1) return 1;
        
        // Recursive case: n * factorial of n-1
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int N = 5; // Example input
        System.out.println("Factorial of " + N + " is " + solution.factorial(N));
    }
}
```

### Complexity
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)

### Limitations
- Risk of stack overflow for large inputs
- Iterative solutions often preferred for large numbers