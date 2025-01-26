## Java Collections Framework

The Java Collections Framework (JCF) is a set of classes and interfaces that implement commonly reusable data structures. It is similar to the Standard Template Library (STL) in C++. Let’s explore the various collections and utilities provided by Java in detail.

### 1. Custom classes
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