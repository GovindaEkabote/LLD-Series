
# Constructor Chaining in Java

## Aim
To demonstrate constructor chaining in Java using the `this()` keyword.

## Introduction
Constructor chaining is the process of calling one constructor
from another constructor.

It helps in code reusability and avoids writing the same
initialization code multiple times.

## Types of Constructor Chaining

1. Using this() - Calls another constructor within the same class.
2. Using super() - Calls the parent class constructor.

## Program
The Student class demonstrates constructor chaining using
the this() keyword.

## Concepts Used

- Default Constructor
- Parameterized Constructor
- this() keyword
- Constructor Overloading
- Object Creation

## Output

Three Parameter Constructor Called
Two Parameter Constructor Called
One Parameter Constructor Called
Default Constructor Called

Student Details:
ID: 101
Name: Rahul
Age: 20

## How to Run

1. Save the program as Student.java.
2. Open the terminal in the project folder.
3. Compile the program:

   javac Student.java

4. Run the program:

   java Student

## Conclusion

Constructor chaining in Java allows one constructor to call
another constructor using this() or super().

It improves code reusability and makes object initialization
easier and more organized.
