# Java Collections Framework

The Java Collections Framework (JCF) is a set of classes and interfaces that implement commonly reusable data structures. It is similar to the Standard Template Library (STL) in C++. Let’s explore the various collections and utilities provided by Java in detail.

## 1. Custom classes
In Java, collections can store custom objects, allowing you to define your own classes and use them within collections such as List, Set, and Map. Let’s take a simple class Person as an example:

```Java
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

1. ArrayList
An ArrayList is a resizable array implementation of the List interface. It offers fast random access but slower insertions and deletions as elements need to be shifted.
```
List<String> arrayList = new ArrayList<>();
arrayList.add("Apple");
arrayList.add("Banana");
System.out.println(arrayList); // Output: [Apple, Banana]
```

2. LinkedList
LinkedList is a doubly linked list implementation of the List interface. It provides fast insertions and deletions but slower random access compared to ArrayList.

```
List<String> linkedList = new LinkedList<>();
linkedList.add("Cat");
linkedList.add("Dog");
System.out.println(linkedList); // Output: [Cat, Dog]
```

3. Stack
Stack is a subclass of Vector that implements a last-in, first-out (LIFO) stack of elements. It provides typical stack operations like push() and pop().

```
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
System.out.println(stack.pop()); // Output: 2
```

4. Vector
Vector is similar to ArrayList but is synchronized, meaning it is thread-safe for multi-threaded environments.

```
Vector<String> vector = new Vector<>();
vector.add("Red");
vector.add("Blue");
System.out.println(vector); // Output: [Red, Blue]
```

### b. Set
A Set is a collection that does not allow duplicate elements. It is useful when you need to store unique elements.

1. HashSet
HashSet is an implementation of the Set interface that uses a hash table for storage. It provides constant time performance for basic operations like add and remove.

```
Set<String> hashSet = new HashSet<>();
hashSet.add("One");
hashSet.add("Two");
System.out.println(hashSet); // Output: [One, Two]
```

2. TreeSet
TreeSet is an implementation of the Set interface that stores elements in a sorted order using a red-black tree. The elements are sorted based on their natural ordering or a custom comparator.
```
Set<String> treeSet = new TreeSet<>();
treeSet.add("Cat");
treeSet.add("Dog");
System.out.println(treeSet); // Output: [Cat, Dog]
```

### c. Queue
A Queue is a collection that follows the first-in, first-out (FIFO) principle. It is commonly used in scenarios where elements are processed in the order they are added.

1. ArrayDeque
Java doesn’t have a direct ArrayQueue, but you can implement a queue using an ArrayList. Alternatively, you can use LinkedList as a queue.

2. LinkedList (as a Queue)
LinkedList can be used as a queue since it implements both the List and Queue interfaces.

```
Queue<String> queue = new LinkedList<>();
queue.add("First");
queue.add("Second");
System.out.println(queue.poll()); // Output: First
```