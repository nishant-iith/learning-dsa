# Understanding Strings and Characters in Programming Languages

## Fundamental Concepts of Strings

### Definition
A string is a sequence of characters used to represent text. It is a fundamental data type in almost every programming language, providing an efficient mechanism to store and manipulate text.

### String Support in Different Languages
Strings are supported through:
- Standard libraries
- Built-in types

#### Language-Specific String Definitions
- **Java**: Uses `java.lang.String` class
- **C++**: Utilizes `std::string` class from Standard Template Library (STL)
- **Python**: Includes strings as a fundamental built-in type
- **JavaScript**: Provides strings as primitive types with native methods

### String Declaration Examples
```java
// Java
String str = "Hello";

// C++
std::string str = "Hello";

// Python
str = "Hello"

// JavaScript
let str = "Hello";
```

### Mutability Differences
- **C++**: Strings are mutable (can be modified after creation)
  ```cpp
  std::string s = "taj";
  s = s + 'j'; // Results in "tajj"
  ```

- **Java**: Strings are immutable (create new string on modification)
  ```java
  String s = "raj";
  s = s + 'j'; // Creates a new string "rajj"
  ```

### Accessing Characters
Accessing individual characters is typically done via indexing:
- **Java**: `charAt()` method
  ```java
  String s = "raj";
  char c = s.charAt(1); // 'a'
  ```
- **C++**: Subscript operator `[]`
  ```cpp
  std::string s = "raj";
  char c = s[1]; // 'a'
  ```

### Character vs String
- **String**: Enclosed in double quotes `" "`
- **Character**: Enclosed in single quotes `' '`
  ```java
  String s = "Hello";  // String
  char c = 'H';        // Character
  ```

### String Traversal
Common approach using a for loop:
```java
for (int i = 0; i < s.length(); i++) {
    char c = s.charAt(i);
    // Process each character
}
```

### Character Data Type
- Represents individual letters, digits, or symbols
- Associated with ASCII values
  - A-Z: ASCII values 65-90
  - a-z: ASCII values 97-122

### Substrings
Extraction varies by language:
- **C++**:
  ```cpp
  std::string s = "string";
  std::string sub = s.substr(2, 3); // "rin"
  ```
- **Java**:
  ```java
  String s = "string";
  String sub = s.substring(2, 4); // "ri"
  ```

# String Manipulation Problems in Java

## 1. Reverse a String

### Brute Force Approach
```java
public void reverseString(Vector<Character> s) {
    Stack<Character> stack = new Stack<>();

    // Push characters onto the stack
    for (char c : s) {
        stack.push(c);
    }

    // Pop characters from the stack to reverse the string
    for (int i = 0; i < s.size(); ++i) {
        s.set(i, stack.pop());
    }
}
```
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)
- **Explanation**: 
  * Uses a stack to store and then retrieve characters in reverse order
  * Requires additional space to store all characters
  * Two-pass algorithm (one to push, one to pop)

### Optimal Approach
```java
public void reverseString(Vector<Character> s) {
    int start = 0, end = s.size() - 1;

    while (start < end) {
        // Swap the characters at start and end
        char ch = s.get(start);
        s.set(start, s.get(end));
        s.set(end, ch);

        // Move the pointers towards the center
        start++;
        end--;
    }
}
```
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Explanation**: 
  * Uses two-pointer technique
  * Swaps characters in-place
  * No extra space required
  * Single-pass algorithm

## 2. Palindrome Check
```java
public boolean palindromeCheck(String s) {
    int left = 0;               
    int right = s.length() - 1; 

    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;   
        right--;  
    }
    return true; 
}
```
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Explanation**:
  * Uses two-pointer technique
  * Compares characters from both ends
  * Moves pointers towards center
  * Returns false if any mismatch found

## 3. Largest Odd Number in String
```java
public String largeOddNum(String s) {
    int ind = -1;
    
    // Find the rightmost odd digit
    for (int i = s.length() - 1; i >= 0; i--) {
        if ((s.charAt(i) - '0') % 2 == 1) {
            ind = i;
            break;
        }
    }
    
    // If no odd number found, return empty string
    if (ind == -1) return "";
    
    // Skip leading zeros
    int i = 0;
    while(i <= ind && s.charAt(i) == '0') i++;
    
    // Return largest odd number substring
    return s.substring(i, ind + 1);
}
```
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Explanation**:
  * Searches from right to find first odd digit
  * Handles leading zeros
  * Returns substring of largest odd number

## 4. Longest Common Prefix
```java
public String longestCommonPrefix(String[] v) {
    StringBuilder ans = new StringBuilder();
    
    // Sort the array to get lexicographically extreme strings
    Arrays.sort(v);
    String first = v[0]; 
    String last = v[v.length - 1];
    
    // Compare first and last strings
    for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
        if (first.charAt(i) != last.charAt(i)) {
            return ans.toString();
        }
        ans.append(first.charAt(i));
    }
    
    return ans.toString();
}
```
- **Time Complexity**: O(n log n + m)
  * n: number of strings
  * m: length of shortest string
- **Space Complexity**: O(1)
- **Explanation**:
  * Sort strings to bring lexicographically similar strings together
  * Compare first and last strings
  * Build common prefix efficiently

## 5. Isomorphic Strings
```java
public boolean isomorphicString(String s, String t) {
    int[] m1 = new int[256], m2 = new int[256];
    
    int n = s.length();
    
    for (int i = 0; i < n; ++i) {
        if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
        
        m1[s.charAt(i)] = i + 1;
        m2[t.charAt(i)] = i + 1;
    }
    
    return true;
}
```
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Explanation**:
  * Uses two mapping arrays to track character positions
  * Ensures consistent mapping between characters
  * One-pass solution

## 6. Rotate String

### Brute Force Approach
```java
public boolean rotateString(String s, String goal) {
    if (s.length() != goal.length()) {
        return false; 
    }
    
    for (int i = 0; i < s.length(); i++) {
        String rotated = s.substring(i) + s.substring(0, i); 
        if (rotated.equals(goal)) {
            return true;
        }
    }
    return false;
}
```
- **Time Complexity**: O(n²)
- **Space Complexity**: O(n)
- **Explanation**:
  * Generates all possible rotations
  * Compares each rotation with goal string
  * Inefficient for large strings

### Optimal Approach
```java
public boolean rotateString(String s, String goal) {
    if (s.length() != goal.length()) {
        return false;  
    }
    String doubledS = s + s;
    return doubledS.contains(goal);
}
```
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)
- **Explanation**:
  * Concatenates string with itself
  * Checks if goal is a substring
  * Clever way to check all rotations

## 7. Valid Anagram

### Brute Force Approach
```java
public boolean anagramStrings(String s, String t) {
    if (s.length() != t.length()) return false;

    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();
    Arrays.sort(sArray);
    Arrays.sort(tArray);

    return Arrays.equals(sArray, tArray);
}
```
- **Time Complexity**: O(n log n)
- **Space Complexity**: O(n)
- **Explanation**:
  * Converts strings to char arrays
  * Sorts both arrays
  * Compares sorted arrays
  * Less efficient due to sorting

### Optimal Approach
```java
public boolean anagramStrings(String s, String t) {
    if (s.length() != t.length()) return false;

    int[] count = new int[26];

    for (char c : s.toCharArray()) count[c - 'a']++;
    for (char c : t.toCharArray()) count[c - 'a']--;

    for (int i : count) {
        if (i != 0) return false;
    }

    return true;
}
```
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Explanation**:
  * Uses character count array
  * Increments for first string
  * Decrements for second string
  * Checks if all counts are zero

## 8. Sort Characters by Frequency
```java
public List<Character> frequencySort(String s) {
    Pair[] freq = new Pair[26];
    for (int i = 0; i < 26; i++) {
        freq[i] = new Pair(0, (char)(i + 'a'));
    }

    for (char ch : s.toCharArray()) {
        freq[ch - 'a'].freq++;
    }

    Arrays.sort(freq, (p1, p2) -> {
        if (p1.freq != p2.freq) return p2.freq - p1.freq;
        return p1.ch - p2.ch;
    });

    List<Character> result = new ArrayList<>();
    for (Pair p : freq) {
        if (p.freq > 0) result.add(p.ch);
    }
    return result;
}

class Pair {
    int freq;
    char ch;
    Pair(int f, char c) {
        this.freq = f;
        this.ch = c;
    }
}
```
- **Time Complexity**: O(n + k log k)
  * n: string length
  * k: number of unique characters
- **Space Complexity**: O(k)
- **Explanation**:
  * Counts character frequencies
  * Sorts based on frequency and alphabetical order
  * Returns characters sorted by their frequency