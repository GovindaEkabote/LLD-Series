# Java Constructors

A **constructor** in Java is a special member of a class used to initialize an object when it is created.

---

## Table of Contents

* [What is a Constructor?](#what-is-a-constructor)
* [Syntax](#syntax)
* [Example](#example)
* [Rules of Constructors](#rules-of-constructors)
* [Types of Constructors](#types-of-constructors)

    * [No-Argument Constructor](#1-no-argument-constructor)
    * [Parameterized Constructor](#2-parameterized-constructor)
    * [Default Constructor](#3-default-constructor)
    * [Constructor Overloading](#4-constructor-overloading)
* [this Keyword](#this-keyword)
* [Constructor Chaining](#constructor-chaining)
* [Constructor and Inheritance](#constructor-and-inheritance)
* [Private Constructor](#private-constructor)
* [Constructor vs Method](#constructor-vs-method)
* [Important Interview Points](#important-interview-points)

---

## What is a Constructor?

A constructor is invoked automatically when an object is created using the `new` keyword.

```java
class Student {

    String name;
    int age;

    Student() {
        name = "Unknown";
        age = 0;
    }
}
```

Creating an object:

```java
Student student = new Student();
```

Execution flow:

```text
new Student()
      ↓
Memory allocated
      ↓
Constructor called
      ↓
Object initialized
```

---

## Syntax

```java
class ClassName {

    ClassName() {
        // initialization
    }
}
```

Example:

```java
class Employee {

    Employee() {
        System.out.println("Constructor called");
    }
}
```

---

# Types of Constructors

## 1. No-Argument Constructor

A constructor that does not accept any parameters.

```java
class Employee {

    String name;
    int salary;

    Employee() {
        name = "Unknown";
        salary = 0;
    }
}
```

Usage:

```java
Employee employee = new Employee();

System.out.println(employee.name);
System.out.println(employee.salary);
```

Output:

```text
Unknown
0
```

---

## 2. Parameterized Constructor

A constructor that accepts parameters to initialize an object with specific values.

```java
class Employee {

    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
```

Usage:

```java
Employee employee =
        new Employee("Govinda", 600000);

System.out.println(employee.name);
System.out.println(employee.salary);
```

Output:

```text
Govinda
600000
```

---

## 3. Default Constructor

There is an important distinction between a **compiler-generated default constructor** and a manually written no-argument constructor.

If you don't declare any constructor:

```java
class Student {

    String name;
}
```

The compiler provides a no-argument constructor conceptually similar to:

```java
Student() {
    super();
}
```

Therefore:

```java
Student student = new Student();
```

is valid.

### Important

If you declare your own constructor:

```java
class Student {

    Student(String name) {
        // ...
    }
}
```

Java will **not** provide a no-argument constructor automatically.

Therefore:

```java
Student student = new Student();
```

causes a compilation error.

You would need:

```java
Student student = new Student("Govinda");
```

---

# 4. Constructor Overloading

A class can have multiple constructors as long as their parameter lists are different.

```java
class Employee {

    String name;
    int salary;

    Employee() {
        name = "Unknown";
        salary = 0;
    }

    Employee(String name) {
        this.name = name;
        salary = 0;
    }

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
```

Usage:

```java
Employee e1 = new Employee();

Employee e2 = new Employee("Govinda");

Employee e3 = new Employee("Govinda", 600000);
```

This is called **constructor overloading**.

---

# this Keyword

The `this` keyword refers to the current object.

It is commonly used when constructor parameters have the same names as instance variables.

```java
class Employee {

    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
```

Without `this`:

```java
name = name;
```

Both `name` references refer to the parameter.

With `this`:

```java
this.name = name;
```

```text
this.name  → instance variable
name       → constructor parameter
```

---

# Constructor Chaining

Constructor chaining means calling one constructor from another constructor.

Use `this()` to call another constructor in the same class.

```java
class Employee {

    String name;
    int salary;

    Employee() {
        this("Unknown", 0);
    }

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
```

Usage:

```java
Employee employee = new Employee();
```

Execution:

```text
Employee()
    ↓
this("Unknown", 0)
    ↓
Employee(String, int)
    ↓
Object initialized
```

### Important Rule

`this()` must be the **first statement** inside a constructor.

Valid:

```java
Employee() {
    this("Unknown", 0);
}
```

Invalid:

```java
Employee() {
    System.out.println("Hello");
    this("Unknown", 0); // Compilation error
}
```

---

# Constructor and Inheritance

Constructors are **not inherited** by subclasses.

However, when a child object is created, the parent constructor is called first.

```java
class Animal {

    Animal() {
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {

    Dog() {
        System.out.println("Dog constructor");
    }
}
```

Creating the object:

```java
Dog dog = new Dog();
```

Output:

```text
Animal constructor
Dog constructor
```

Conceptually:

```text
new Dog()
   ↓
super()
   ↓
Animal constructor
   ↓
Dog constructor
```

If you don't explicitly write `super()`, Java implicitly inserts it when applicable.

---

# Private Constructor

A constructor can be declared `private`.

```java
class Database {

    private Database() {
        System.out.println("Database constructor");
    }
}
```

This prevents other classes from directly creating objects:

```java
Database db = new Database();
```

The above code will not compile because the constructor is private.

Private constructors are commonly used in patterns such as the **Singleton Pattern** or utility-style classes.

---

# Constructor with Validation

Constructors can also validate input before initializing an object.

```java
class BankAccount {

    private double balance;

    BankAccount(double balance) {

        if (balance < 0) {
            throw new IllegalArgumentException(
                    "Balance cannot be negative"
            );
        }

        this.balance = balance;
    }
}
```

Usage:

```java
BankAccount account =
        new BankAccount(10000);
```

Invalid input:

```java
BankAccount account =
        new BankAccount(-500);
```

This throws an exception.

---

# Constructor vs Method

| Constructor                   | Method                    |
| ----------------------------- | ------------------------- |
| Initializes an object         | Performs an operation     |
| Same name as class            | Can have any valid name   |
| Has no return type            | Can have a return type    |
| Called during object creation | Usually called explicitly |
| Cannot be inherited           | Methods can be inherited  |
| Can be overloaded             | Can be overloaded         |
| Cannot be overridden          | Can be overridden         |

---

# Important Interview Points

### 1. Can a constructor have a return type?

No.

```java
class Student {

    Student() { }       // Constructor

    void Student() { }  // Method
}
```

The second one is a method, not a constructor.

---

### 2. Can constructors be overloaded?

Yes.

```java
Student() { }

Student(String name) { }

Student(String name, int age) { }
```

---

### 3. Can constructors be overridden?

No.

Constructors are not inherited, so they cannot be overridden.

---

### 4. Can a constructor be private?

Yes.

```java
private Student() {
}
```

This restricts object creation from outside the class.

---

### 5. Can a constructor be static?

No.

Constructors belong to object initialization, while `static` members belong to the class.

---

### 6. Can a constructor be final?

No.

A `final` method prevents overriding, but constructors cannot be overridden anyway.

---

### 7. Can a constructor be abstract?

No.

An abstract constructor would not make sense because constructors are responsible for initializing an actual object.

---

### 8. Can a constructor call another constructor?

Yes.

Use:

```java
this();
```

or:

```java
this(arguments);
```

---

### 9. Can a constructor call a parent constructor?

Yes.

Use:

```java
super();
```

or:

```java
super(arguments);
```

`super()` must also be the first statement in the constructor.

---

# Complete Example

```java
class Employee {

    private String name;
    private int salary;

    // No-argument constructor
    Employee() {
        this("Unknown", 0);
    }

    // Parameterized constructor
    Employee(String name, int salary) {

        if (salary < 0) {
            throw new IllegalArgumentException(
                    "Salary cannot be negative"
            );
        }

        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

public class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee();
        e1.display();

        System.out.println();

        Employee e2 =
                new Employee("Govinda", 600000);

        e2.display();
    }
}
```

Output:

```text
Name: Unknown
Salary: 0

Name: Govinda
Salary: 600000
```

---

# Key Takeaways

```text
Constructor
│
├── Initializes objects
├── Same name as class
├── No return type
├── Called during object creation
├── Can be overloaded
├── Cannot be overridden
├── Cannot be static
├── Cannot be final
├── Cannot be abstract
├── Can be private
│
├── this()
│   └── Calls another constructor in same class
│
└── super()
    └── Calls parent-class constructor
```

## One-Line Interview Definition

> **A constructor is a special class member that is automatically invoked during object creation to initialize the object's state.**
