# Number Manipulation and Analysis Problems

## Problem List
1. [Count All Digits of a Number](#1-count-all-digits-of-a-number)
2. [Count Number of Odd Digits](#2-count-number-of-odd-digits)
3. [Reverse a Number](#3-reverse-a-number)
4. [Palindrome Number](#4-palindrome-number)
5. [Largest Digit in Number](#5-largest-digit-in-number)
6. [Factorial of a Number](#6-factorial-of-a-number)
7. [Armstrong Number](#7-armstrong-number)
8. [Perfect Number](#8-perfect-number)
9. [Prime Number](#9-prime-number)
10. [Count Prime Numbers Till N](#10-count-prime-numbers-till-n)
11. [GCD of Two Numbers](#11-gcd-of-two-numbers)
12. [LCM of Two Numbers](#12-lcm-of-two-numbers)
13. [Divisors of a Number](#13-divisors-of-a-number)

## Introduction
This comprehensive guide covers various number manipulation and analysis problems in Java. Each problem is solved using multiple approaches, demonstrating different algorithmic strategies and optimization techniques. The solutions focus on:
- Efficient problem-solving
- Time and space complexity optimization
- Handling edge cases
- Demonstrating different computational approaches

### Key Problem-Solving Strategies
- **Iterative Approaches**: Breaking down problems into step-by-step solutions
- **Mathematical Optimizations**: Using mathematical properties to reduce computational complexity
- **Edge Case Handling**: Addressing special input scenarios
- **Complexity Reduction**: Improving time and space efficiency

## 1. Count All Digits of a Number

### Approach 1: Iterative Method
```java
public int countDigit(int n) {
    if (n == 0) return 1;
    int cnt = 0;
    while (n > 0) {
        int lastDigit = n % 10;
        cnt = cnt + 1;
        n = n / 10;
    }
    return cnt;
}
```

#### Complexity Analysis
- **Time Complexity**: O(log n) - Number of iterations is proportional to the number of digits
- **Space Complexity**: O(1) - Uses constant extra space

#### Key Points
- Handles edge case of 0
- Extracts digits by repeatedly dividing by 10
- Counts number of digits by incrementing a counter

### Approach 2: Logarithmic Method
```java
public int countDigit(int n) {
    if (n == 0) return 1;
    return (int)(Math.log10(n) + 1);
}
```

#### Complexity Analysis
- **Time Complexity**: O(1) - Constant time using logarithm
- **Space Complexity**: O(1) - Uses constant extra space

#### Key Points
- Uses mathematical logarithm to count digits
- More concise and efficient for larger numbers
- Handles edge case of 0

## 2. Count Number of Odd Digits

```java
public int countOddDigit(int n) {
    int oddDigits = 0;
    while (n > 0) {
        int lastDigit = n % 10;
        if (lastDigit % 2 != 0) {
            oddDigits = oddDigits + 1;
        }
        n = n / 10;
    }
    return oddDigits;
}
```

#### Complexity Analysis
- **Time Complexity**: O(log n) - Iterates through each digit
- **Space Complexity**: O(1) - Uses constant extra space

#### Key Points
- Extracts each digit using modulo operation
- Checks oddness by checking remainder when divided by 2
- Increments counter for odd digits

## 3. Reverse a Number

```java
public int reverseNumber(int n) {
    int revNum = 0;
    while (n > 0) {
        int lastDigit = n % 10;
        revNum = (revNum * 10) + lastDigit;
        n = n / 10;
    }
    return revNum;
}
```

#### Complexity Analysis
- **Time Complexity**: O(log n) - Number of iterations is proportional to number of digits
- **Space Complexity**: O(1) - Uses constant extra space

#### Key Points
- Builds reversed number by extracting last digit
- Multiplies current reversed number by 10 to shift digits
- Adds extracted last digit to reversed number

## 4. Palindrome Number

```java
public boolean isPalindrome(int n) {
    int copy = n;
    int revNum = 0;
    while (n > 0) {
        int lastDigit = n % 10;
        revNum = (revNum * 10) + lastDigit;
        n = n / 10;
    }
    return revNum == copy;
}
```

#### Complexity Analysis
- **Time Complexity**: O(log n) - Number of iterations is proportional to number of digits
- **Space Complexity**: O(1) - Uses constant extra space

#### Key Points
- Creates a copy of original number
- Reverses the number
- Compares reversed number with original number
- Returns true if they are equal

## 5. Largest Digit in Number

```java
public int largestDigit(int n) {
    int largestDigit = 0;
    while (n > 0) {
        int lastDigit = n % 10;
        if (lastDigit > largestDigit) {
            largestDigit = lastDigit;
        }
        n = n / 10;
    }
    return largestDigit;
}
```

#### Complexity Analysis
- **Time Complexity**: O(log n) - Iterates through each digit
- **Space Complexity**: O(1) - Uses constant extra space

#### Key Points
- Extracts each digit
- Keeps track of maximum digit encountered
- Updates largest digit if current digit is larger

## 6. Factorial of a Number

```java
public int factorial(int n) {
    int fact = 1;
    for(int i = 1; i <= n; i++) {
        fact = fact * i;
    }
    return fact;
}
```

#### Complexity Analysis
- **Time Complexity**: O(n) - Iterates from 1 to n
- **Space Complexity**: O(1) - Uses constant extra space

#### Key Points
- Initializes factorial as 1
- Multiplies current number with running factorial
- Handles factorial calculation iteratively

## 7. Armstrong Number

```java
public boolean isArmstrong(int n) {
    int count = (int)(Math.log10(n) + 1);
    int sum = 0;
    int copy = n;
    
    while (n > 0) {
        int lastDigit = n % 10;
        sum += Math.pow(lastDigit, count);
        n = n / 10;
    }
    
    return sum == copy;
}
```

#### Complexity Analysis
- **Time Complexity**: O(log n) - Iterates through digits
- **Space Complexity**: O(1) - Uses constant extra space

#### Key Points
- Counts number of digits
- Calculates sum of digits raised to power of digit count
- Compares sum with original number

## 8. Perfect Number

```java
public boolean isPerfect(int n) {
    int sum = 0;
    for(int i = 1; i < n; ++i) {
        if(n % i == 0){
            sum = sum + i;
        }
    }
    return sum == n;
}
```

#### Complexity Analysis
- **Time Complexity**: O(n) - Iterates from 1 to n-1
- **Space Complexity**: O(1) - Uses constant extra space

#### Key Points
- Finds all proper divisors
- Calculates sum of proper divisors
- Checks if sum equals original number

## 9. Prime Number

### Brute Force Approach
```java
public boolean isPrime(int n) {
    if(n < 2) return false;
    int count = 0;
    for (int i = 1; i <= n; ++i) {
        if (n % i == 0) {
            count = count + 1;
        }
    }
    return count == 2;
}
```

### Optimized Approach
```java
public boolean isPrime(int n) {
    if(n < 2) return false;
    for(int i = 2; i <= Math.sqrt(n); ++i) {
        if(n % i == 0) return false;
    }
    return true;
}
```

#### Complexity Analysis
- **Brute Force**:
  - Time Complexity: O(n)
  - Space Complexity: O(1)
- **Optimized**:
  - Time Complexity: O(√n)
  - Space Complexity: O(1)

#### Key Points
- Brute force checks all divisors
- Optimized approach checks only up to square root
- Handles edge cases like numbers less than 2

## 10. Count Prime Numbers Till N

### Brute Force Approach
```java
public int primeUptoN(int n) {
    int count = 0;
    for (int i = 2; i <= n; i++) {
        if (isPrime(i)) count++;
    }
    return count;
}
```

### Optimized Approach (Sieve of Eratosthenes)
```java
public int primeUptoN(int n) {
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;
    
    for (int i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }
    
    int count = 0;
    for (int i = 2; i <= n; i++) {
        if (isPrime[i]) count++;
    }
    return count;
}
```

#### Complexity Analysis
- **Brute Force**:
  - Time Complexity: O(n * √n)
  - Space Complexity: O(1)
- **Sieve of Eratosthenes**:
  - Time Complexity: O(n log log n)
  - Space Complexity: O(n)

#### Key Points
- Brute force checks primality of each number
- Sieve marks non-prime numbers efficiently
- Optimized approach reduces computational complexity

## 11. GCD of Two Numbers

### Brute Force Approach
```java
public int GCD(int n1, int n2) {
    int gcd = 1;
    for(int i = 1; i <= Math.min(n1, n2); i++) {
        if(n1 % i == 0 && n2 % i == 0) {
            gcd = i;
        }
    }
    return gcd;
}
```

### Optimized Approach (Euclidean Algorithm)
```java
public int GCD(int n1, int n2) {
    while (n1 > 0 && n2 > 0) {
        if (n1 > n2) {
            n1 = n1 % n2;
        } else {
            n2 = n2 % n1;
        }
    }
    return n1 == 0 ? n2 : n1;
}
```

#### Complexity Analysis
- **Brute Force**:
  - Time Complexity: O(min(n1, n2))
  - Space Complexity: O(1)
- **Euclidean Algorithm**:
  - Time Complexity: O(log(min(n1, n2)))
  - Space Complexity: O(1)

#### Key Points
- Brute force checks all possible divisors
- Euclidean algorithm uses modulo operation
- Significantly reduces computational complexity

## 12. LCM of Two Numbers

### Brute Force Approach
```java
public int LCM(int n1, int n2) {
    int n = Math.max(n1, n2);
    int i = 1;
    while (true) {
        int mul = n * i;
        if (mul % n1 == 0 && mul % n2 == 0) {
            return mul;
        }
        i++;
    }
}
```

### Optimized Approach
```java
public int LCM(int n1, int n2) {
    int gcd = GCD(n1, n2);
    return (n1 * n2) / gcd;
}
```

#### Complexity Analysis
- **Brute Force**:
  - Time Complexity: O(n1 * n2)
  - Space Complexity: O(1)
- **Optimized**:
  - Time Complexity: O(log(min(n1, n2)))
  - Space Complexity: O(1)

#### Key Points
- Brute force finds least common multiple by iteration
- Optimized approach uses GCD formula
- More efficient and mathematically elegant

## 13. Divisors of a Number

### Approach
```java
public int[] divisors(int n) {
    int[] temp = new int[n];
    int count = 0;
    for (int i = 1; i <= n; i++) {
        if (n % i == 0) {
            temp[count++] = i;
        }
    }
    return Arrays.copyOf(temp, count);
}
```

#### Complexity Analysis
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)

#### Key Points
- Finds all divisors by checking divisibility
- Uses temporary array to store divisors
- Copies array to exact size of divisors found