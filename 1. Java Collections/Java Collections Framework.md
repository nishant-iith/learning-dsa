# Java Collections Framework

The Java Collections Framework (JCF) is a set of classes and interfaces that implement commonly reusable data structures. It is similar to the Standard Template Library (STL) in C++. Let’s explore the various collections and utilities provided by Java in detail.

## 1. Custom classes
In Java, collections can store custom objects, allowing you to define your own classes and use them within collections such as List, Set, and Map. Let’s take a simple class Person as an example:

```
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
```

Now, you can store instances of this Person class in a collection like an ArrayList:
```
List<Person> people = new ArrayList<>();
people.add(new Person("John", 30));
people.add(new Person("Alice", 25));
System.out.println(people); // Output: [John (30), Alice (25)]
```

## 2. Collections

### a. List

A List is an ordered collection that allows duplicate elements. It provides positional access and is commonly used in scenarios where order matters.

1. <b>ArrayList</b> : 
An ArrayList is a resizable array implementation of the List interface. It offers fast random access but slower insertions and deletions as elements need to be shifted.
```
List<String> arrayList = new ArrayList<>();
arrayList.add("Apple");
arrayList.add("Banana");
System.out.println(arrayList); // Output: [Apple, Banana]
```

2. <b>LinkedList</b> : 
LinkedList is a doubly linked list implementation of the List interface. It provides fast insertions and deletions but slower random access compared to ArrayList.

```
List<String> linkedList = new LinkedList<>();
linkedList.add("Cat");
linkedList.add("Dog");
System.out.println(linkedList); // Output: [Cat, Dog]
```

3. <b>Stack</b> :
Stack is a subclass of Vector that implements a last-in, first-out (LIFO) stack of elements. It provides typical stack operations like push() and pop().

```
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
System.out.println(stack.pop()); // Output: 2
```

4. <b>Vector</b> :
Vector is similar to ArrayList but is synchronized, meaning it is thread-safe for multi-threaded environments.

```
Vector<String> vector = new Vector<>();
vector.add("Red");
vector.add("Blue");
System.out.println(vector); // Output: [Red, Blue]
```

### b. Set
A Set is a collection that does not allow duplicate elements. It is useful when you need to store unique elements.

1. <b>HashSet</b> :
HashSet is an implementation of the Set interface that uses a hash table for storage. It provides constant time performance for basic operations like add and remove.

```
Set<String> hashSet = new HashSet<>();
hashSet.add("One");
hashSet.add("Two");
System.out.println(hashSet); // Output: [One, Two]
```

2. <b>TreeSet</b> :
TreeSet is an implementation of the Set interface that stores elements in a sorted order using a red-black tree. The elements are sorted based on their natural ordering or a custom comparator.
```
Set<String> treeSet = new TreeSet<>();
treeSet.add("Cat");
treeSet.add("Dog");
System.out.println(treeSet); // Output: [Cat, Dog]
```

### c. Queue
A Queue is a collection that follows the first-in, first-out (FIFO) principle. It is commonly used in scenarios where elements are processed in the order they are added.

1. <b>ArrayDeque</b> :
Java doesn’t have a direct ArrayQueue, but you can implement a queue using an ArrayList. Alternatively, you can use LinkedList as a queue.

2. <b>LinkedList (as a Queue)</b> :
LinkedList can be used as a queue since it implements both the List and Queue interfaces.

```
Queue<String> queue = new LinkedList<>();
queue.add("First");
queue.add("Second");
System.out.println(queue.poll()); // Output: First
```

3. <b>PriorityQueue</b> :
PriorityQueue is a queue that orders elements according to their natural ordering or a custom comparator. Elements with higher priority are processed first.

```
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
priorityQueue.add(10);
priorityQueue.add(5);
System.out.println(priorityQueue.poll()); // Output: 5
```

## 3. Map
A Map is a collection that maps keys to values. It does not allow duplicate keys, but multiple keys can map to the same value.

### a. HashMap
HashMap is an implementation of the Map interface that uses a hash table for storage. It allows null keys and values.

```
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("Apple", 10);
hashMap.put("Banana", 20);
System.out.println(hashMap); // Output: {Apple=10, Banana=20}
```

### b. TreeMap
TreeMap is a red-black tree-based implementation of the Map interface. It stores entries in sorted order based on keys.

```
Map<String, Integer> treeMap = new TreeMap<>();
treeMap.put("Orange", 5);
treeMap.put("Mango", 15);
System.out.println(treeMap); // Output: {Mango=15, Orange=5}
```

## 4. Iterator

An Iterator allows you to traverse through a collection. ListIterator is a special type of iterator for List collections.

### a. ListIterator
ListIterator allows bidirectional traversal of a list, i.e., both forward and backward.

```
List<String> list = new ArrayList<>();
list.add("One");
list.add("Two");

ListIterator<String> iterator = list.listIterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

## 5. Custom Comparator
A Comparator allows you to define custom sorting logic for collections. You can use it to sort objects based on specific attributes.

```
Collections.sort(people, new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.age - p2.age;
    }
});
```

## 6. Common Algorithms
Java provides several utility methods through the Collections and Arrays classes:

- <i>Collections.sort(list);</i> - Sorts a list in natural order.
```
List<Integer> list = new ArrayList<>();
list.add(3);
list.add(1);
list.add(2);
Collections.sort(list);
System.out.println(list); // Output: [1, 2, 3]
```

- <i>Collections.max(list);</i> - Returns the maximum element in a list.
```
List<Integer> list = new ArrayList<>();
list.add(3);
list.add(1);
list.add(2);
int max = Collections.max(list);
System.out.println(max); // Output: 3
```

- <i>Collections.min(list);</i> - Returns the minimum element in a list.
```
int min = Collections.min(list);
System.out.println(min); // Output: 1
```

- <i>Collections.reverse(list);</i> - Reverses the order of elements in a list.
```
Collections.reverse(list);
System.out.println(list); // Output: [3, 2, 1]
```

- <i>Array.sort(array);</i> - Sorts the elements of the array.
```
int[] array = {3, 1, 2};
Arrays.sort(array);
System.out.println(Arrays.toString(array)); // Output: [1, 2, 3]
```

- <i>Collections.frequency(list, element);</i> - Returns the frequency of a specific element in a list.
```
int frequency = Collections.frequency(list, 2);
System.out.println(frequency); // Output: 1
```

- <i>Collections.binarySearch(list, key);</i> - Performs a binary search for the key in the list (must be sorted).
```
int index = Collections.binarySearch(list, 2);
System.out.println(index); // Output: 1 (index of 2 in sorted list [1, 2, 3])
```

- <i>Math.pow(base, exponent);</i> - Returns the value of base raised to the power of exponent.
```
double result = Math.pow(2, 3);
System.out.println(result); // Output: 8.0
```

# Conclusion

The Java Collections Framework provides a robust set of classes and interfaces to handle data structures like lists, sets, queues, and maps. By understanding and utilizing these collections, developers can write efficient, maintainable, and scalable applications. In addition, utility methods provided by the Collections and Arrays classes simplify common operations such as sorting and searching, making Java a powerful tool for managing data.
