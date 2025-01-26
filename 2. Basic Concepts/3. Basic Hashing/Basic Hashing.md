# Hashing and Array Frequency Analysis

## Understanding Hashing

### What is Hashing?
Hashing is a fundamental technique in computer science used to efficiently store, retrieve, and manage data. It involves:
- Converting input data into a fixed-size value (hash)
- Mapping data to specific locations in a data structure
- Enabling quick data retrieval and management

### Key Characteristics of Hashing
- **Efficient Data Retrieval**: Provides near-constant time access to data
- **Fixed-Size Output**: Transforms variable-length input to a fixed-size hash value
- **Collision Handling**: Manages scenarios where different inputs generate the same hash

### Common Hashing Applications
- Database indexing
- Password storage
- Caching
- Data validation
- Implementing hash tables and maps

### Hashing Methods
1. **Division Method**
   - Uses modulo operation to generate hash value
   - Divides key by a prime number
   - Returns remainder as hash index

2. **Folding Method**
   - Divides key into equal parts
   - Adds these parts to generate hash value

3. **Mid-Square Method**
   - Squares the key
   - Extracts middle digits as hash value

### Collision Resolution Techniques
1. **Chaining**
   - Uses linked lists at each hash table index
   - Allows multiple elements at same index
   - Manages collisions by creating lists

2. **Open Addressing**
   - Finds next available slot when collision occurs
   - Probing methods: linear, quadratic, double hashing

## Array Frequency Analysis Problems

## 1. Highest Occurring Element

### Brute Force Approach

```java
public int mostFrequentElement(int[] nums) {
    int n = nums.length;
    int maxFreq = 0; 
    int maxEle = 0;
    boolean[] visited = new boolean[n];
    
    for (int i = 0; i < n; i++) {
        if (visited[i]) continue;
        
        int freq = 0;
        
        for (int j = i; j < n; j++) {
            if (nums[i] == nums[j]) {
                freq++;
                visited[j] = true;
            }
        }
        
        if (freq > maxFreq) {
            maxFreq = freq;
            maxEle = nums[i];
        } else if (freq == maxFreq) {
            maxEle = Math.min(maxEle, nums[i]);
        }
    }
    
    return maxEle;
}
```

#### Brute Force Complexity
- **Time Complexity**: O(n²)
  - Nested loops to count frequencies
  - Each element is compared with all other elements
- **Space Complexity**: O(n)
  - Boolean visited array to track processed elements

#### Brute Force Explanation
- Uses nested loops to count element frequencies
- Tracks maximum frequency element
- Handles tie-breaking by selecting smaller element
- Uses visited array to avoid redundant counting

### Optimal Approach (HashMap)

```java
public int mostFrequentElement(int[] nums) {
    int n = nums.length;
    int maxFreq = 0; 
    int maxEle = 0;
    Map<Integer, Integer> mpp = new HashMap<>();
    
    for (int i = 0; i < n; i++) {
        mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
    }
        
    for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
        int ele = it.getKey();
        int freq = it.getValue();
        
        if (freq > maxFreq) {
            maxFreq = freq;
            maxEle = ele;
        } else if (freq == maxFreq) {
            maxEle = Math.min(maxEle, ele);
        }
    }
    
    return maxEle;
}
```

#### Optimal Approach Complexity
- **Time Complexity**: O(n)
  - Single pass to build frequency map
  - Single pass to find most frequent element
- **Space Complexity**: O(n)
  - HashMap to store element frequencies

#### Optimal Approach Explanation
- Uses HashMap to count element frequencies
- Eliminates need for nested loops
- Single iteration to build frequency map
- Another iteration to find most frequent element
- Handles tie-breaking by selecting smaller element

## 2. Second Highest Occurring Element

### Brute Force Approach

```java
public int secondMostFrequentElement(int[] nums) {
    int n = nums.length;
    int maxFreq = 0, secMaxFreq = 0;
    int maxEle = -1, secEle = -1;
    boolean[] visited = new boolean[n];
    
    for(int i = 0; i < n; i++) {
        if(visited[i]) continue;
        
        int freq = 0;
        
        for(int j = i; j < n; j++) {
            if(nums[i] == nums[j]) {
                freq++;
                visited[j] = true;
            }
        }
        
        if(freq > maxFreq) {
            secMaxFreq = maxFreq;
            maxFreq = freq;
            secEle = maxEle;
            maxEle = nums[i];
        } 
        else if(freq == maxFreq) {
            maxEle = Math.min(maxEle, nums[i]);
        }
        else if(freq > secMaxFreq) {
            secMaxFreq = freq;
            secEle = nums[i];
        }
        else if(freq == secMaxFreq) {
            secEle = Math.min(secEle, nums[i]);
        }
    }
    
    return secEle;
}
```

#### Brute Force Complexity
- **Time Complexity**: O(n²)
  - Nested loops to count frequencies
  - Complex logic to track first and second most frequent
- **Space Complexity**: O(n)
  - Boolean visited array to track processed elements

#### Brute Force Explanation
- Uses nested loops to count element frequencies
- Tracks both most and second most frequent elements
- Handles complex tie-breaking scenarios
- Uses visited array to avoid redundant counting

### Optimal Approach (HashMap)

```java
public int secondMostFrequentElement(int[] nums) {
    int n = nums.length;
    int maxFreq = 0, secMaxFreq = 0; 
    int maxEle = -1, secEle = -1;
    HashMap<Integer, Integer> mpp = new HashMap<>();
    
    for (int i = 0; i < n; i++) {
        mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
    }
        
    for(Map.Entry<Integer, Integer> it : mpp.entrySet()) {
        int ele = it.getKey();
        int freq = it.getValue();
        
        if(freq > maxFreq) {
            secMaxFreq = maxFreq;
            maxFreq = freq;
            secEle = maxEle;
            maxEle = ele;
        } 
        else if(freq == maxFreq) {
            maxEle = Math.min(maxEle, ele);
        }
        else if(freq > secMaxFreq) {
            secMaxFreq = freq;
            secEle = ele;
        }
        else if(freq == secMaxFreq) {
            secEle = Math.min(secEle, ele);
        }
    }
    
    return secEle;
}
```

#### Optimal Approach Complexity
- **Time Complexity**: O(n)
  - Single pass to build frequency map
  - Single pass to find second most frequent element
- **Space Complexity**: O(n)
  - HashMap to store element frequencies

#### Optimal Approach Explanation
- Uses HashMap to count element frequencies
- Eliminates nested loops
- Tracks most and second most frequent elements
- Handles tie-breaking scenarios efficiently
- Reduces time complexity significantly

## 3. Sum of Highest and Lowest Frequency

### Brute Force Approach

```java
public int sumHighestAndLowestFrequency(int[] nums) {
    int n = nums.length;
    int maxFreq = 0;
    int minFreq = n;
    boolean[] visited = new boolean[n];
    
    for (int i = 0; i < n; i++) {
        if (visited[i]) continue;
        
        int freq = 0;
        
        for (int j = i; j < n; j++) {
            if (nums[i] == nums[j]) {
                freq++;
                visited[j] = true;
            }
        }
        
        maxFreq = Math.max(maxFreq, freq);
        minFreq = Math.min(minFreq, freq);
    }
    
    return maxFreq + minFreq;
}
```

#### Brute Force Complexity
- **Time Complexity**: O(n²)
  - Nested loops to count frequencies
- **Space Complexity**: O(n)
  - Boolean visited array to track processed elements

#### Brute Force Explanation
- Uses nested loops to count element frequencies
- Tracks maximum and minimum frequencies
- Uses visited array to avoid redundant counting
- Adds maximum and minimum frequencies

### Optimal Approach (HashMap)

```java
public int sumHighestAndLowestFrequency(int[] nums) {
    int n = nums.length;
    int maxFreq = 0, minFreq = n; 
    HashMap<Integer, Integer> mpp = new HashMap<>();
    
    for (int i = 0; i < n; i++) {
        mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
    }
        
    for (int freq : mpp.values()) {
        maxFreq = Math.max(maxFreq, freq);
        minFreq = Math.min(minFreq, freq);
    }
    
    return maxFreq + minFreq;
}
```

#### Optimal Approach Complexity
- **Time Complexity**: O(n)
  - Single pass to build frequency map
  - Single pass to find max and min frequencies
- **Space Complexity**: O(n)
  - HashMap to store element frequencies

#### Optimal Approach Explanation
- Uses HashMap to count element frequencies
- Eliminates nested loops
- Single iteration to build frequency map
- Another iteration to find max and min frequencies
- Adds maximum and minimum frequencies