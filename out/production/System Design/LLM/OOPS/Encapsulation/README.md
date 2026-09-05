# Java Encapsulation

## 📌 Definition

**Encapsulation** is one of the four fundamental principles of Object-Oriented Programming (OOP).

Encapsulation means **binding data (variables) and methods that operate on that data into a single unit (class)** and **restricting direct access to the internal state of an object**.

In Java, encapsulation is primarily achieved by:

* Declaring instance variables as `private`
* Providing `public` getter and setter methods
* Controlling how the data can be accessed or modified

### Simple Definition

> **Encapsulation = Data Hiding + Controlled Access**

---

# 🎯 Why Do We Need Encapsulation?

Without encapsulation, any class can directly modify an object's internal data.

### ❌ Without Encapsulation

```java
class BankAccount {

    public double balance;
}
```

Anyone can modify the balance:

```java
BankAccount account = new BankAccount();

account.balance = -50000;
```

There is no validation or control.

### ✅ With Encapsulation

```java
class BankAccount {

    private double balance;

    public void setBalance(double balance) {

        if (balance >= 0) {
            this.balance = balance;
        }
    }

    public double getBalance() {
        return balance;
    }
}
```

Now the object controls how its data is modified.

---

# 🔐 How Encapsulation Works

```text
             BankAccount
        ┌─────────────────────┐
        │                     │
        │  private balance    │
        │                     │
        │  private accountNo  │
        │                     │
        ├─────────────────────┤
        │                     │
        │  getBalance()       │
        │  setBalance()       │
        │                     │
        └──────────┬──────────┘
                   │
                   │ Controlled Access
                   ▼
             Outside Classes
```

The internal data is hidden from outside classes.

Outside classes interact with the object through public methods.

---

# 🧩 Main Components of Encapsulation

## 1. Private Variables

Instance variables should generally be declared `private`.

```java
private String name;
private int age;
private double salary;
```

This prevents direct access from outside the class.

---

## 2. Getter Methods

A getter is used to retrieve the value of a private variable.

```java
public String getName() {
    return name;
}
```

Example:

```java
Employee employee = new Employee();

String name = employee.getName();
```

---

## 3. Setter Methods

A setter is used to modify the value of a private variable.

```java
public void setName(String name) {
    this.name = name;
}
```

Example:

```java
employee.setName("Rahul");
```

---

# 💻 Complete Example

```java
class Employee {

    private String name;
    private int age;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if (age >= 18) {
            this.age = age;
        } else {
            System.out.println("Age must be at least 18");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {

        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative");
        }
    }
}
```

### Main Class

```java
public class Main {

    public static void main(String[] args) {

        Employee employee = new Employee();

        employee.setName("Rahul");
        employee.setAge(25);
        employee.setSalary(50000);

        System.out.println("Name: " + employee.getName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Salary: " + employee.getSalary());
    }
}
```

### Output

```text
Name: Rahul
Age: 25
Salary: 50000.0
```

---

# 🏦 Real-World Example: Bank Account

Consider a bank account.

The customer should **not** be able to directly change the balance.

Instead, operations such as deposit and withdrawal should control the balance.

```java
class BankAccount {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdrawal");
        }
    }
}
```

Usage:

```java
public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.deposit(10000);

        account.withdraw(3000);

        System.out.println("Balance: " + account.getBalance());
    }
}
```

Output:

```text
Balance: 7000.0
```

Notice that there is **no `setBalance()` method**.

This is an important aspect of encapsulation:

> You don't have to provide setters for every private field.

You should expose only the operations that make sense.

---

# 🔒 Encapsulation vs Data Hiding

These concepts are related but not exactly identical.

### Data Hiding

Data hiding focuses on **preventing direct access** to internal data.

```java
private double balance;
```

### Encapsulation

Encapsulation focuses on **bundling data and behavior together and controlling access to that data**.

```java
class BankAccount {

    private double balance;

    public void deposit(double amount) {
        // controlled modification
    }

    public double getBalance() {
        return balance;
    }
}
```

### Interview Answer

> **Data hiding is a mechanism, while encapsulation is a broader design principle. Encapsulation bundles data and behavior together and provides controlled access to the object's state.**

---

# ⭐ Advantages of Encapsulation

## 1. Data Protection

Internal data cannot be directly modified.

```java
private double salary;
```

---

## 2. Validation

You can validate data before modifying it.

```java
public void setAge(int age) {

    if (age >= 18) {
        this.age = age;
    }
}
```

---

## 3. Maintainability

Internal implementation can change without affecting external code.

For example:

```java
private double salary;
```

could later become:

```java
private BigDecimal salary;
```

while the public API can remain controlled.

---

## 4. Better Security

Sensitive information can be protected from direct access.

Examples:

* Password
* Bank balance
* Account number
* Salary
* Authentication tokens

---

## 5. Controlled Modification

You can decide whether a field should be:

* Read-only
* Write-only
* Read-write
* Modified only through specific business operations

---

# 🧠 Types of Encapsulation Access

### Read + Write

```java
public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
```

### Read Only

Provide only a getter.

```java
public String getAccountNumber() {
    return accountNumber;
}
```

No setter is provided.

### Write Only

Provide only a setter.

```java
public void setPassword(String password) {
    this.password = password;
}
```

In real applications, write-only designs are uncommon for ordinary fields but can be useful for sensitive configuration or APIs.

---

# 🚫 Common Mistake

A common beginner implementation is:

```java
class Employee {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

This is technically encapsulated because the field is private and access is through methods.

However, **encapsulation is not simply "make everything private and generate getters/setters."**

Good encapsulation also means exposing **meaningful operations** and protecting the object's invariants.

For example:

```java
public void withdraw(double amount) {
    if (amount <= 0 || amount > balance) {
        throw new IllegalArgumentException("Invalid amount");
    }

    balance -= amount;
}
```

is often better than:

```java
public void setBalance(double balance) {
    this.balance = balance;
}
```

because callers cannot arbitrarily put the object into an invalid state.

---

# 🔥 Encapsulation in Spring Boot

Encapsulation is heavily used in Spring Boot applications.

Example entity:

```java
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

The fields are private, and external code interacts with them through methods.

---

# 🎯 Interview Questions

### 1. What is encapsulation?

Encapsulation is the process of bundling data and methods into a class while restricting direct access to the object's internal state.

### 2. How do you achieve encapsulation in Java?

Primarily by:

1. Declaring fields `private`
2. Providing controlled public/protected methods where needed
3. Applying validation and business rules inside the class

### 3. Is encapsulation the same as data hiding?

No.

Data hiding is about restricting access to internal data, while encapsulation is the broader concept of combining data and behavior and controlling how the object's state is accessed.

### 4. Why are variables usually declared private?

To prevent direct modification and maintain control over the object's state.

### 5. Are getters and setters mandatory for encapsulation?

**No.**

A class can expose domain-specific methods instead.

```java
account.deposit(1000);
account.withdraw(500);
```

This can provide stronger encapsulation than:

```java
account.setBalance(500);
```

### 6. Can encapsulation be achieved without getters and setters?

Yes.

Example:

```java
class BankAccount {

    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
```

### 7. What is the main benefit of encapsulation?

**Controlled access to an object's internal state**, which helps protect invariants, validate changes, and reduce coupling.

---

# 📌 Key Points to Remember

```text
Encapsulation
      │
      ├── Bundle Data + Behavior
      │
      ├── Hide Internal State
      │
      ├── Control Access
      │
      ├── Validate Input
      │
      └── Protect Object Invariants
```

### One-Line Interview Definition

> **Encapsulation is an OOP principle that bundles data and behavior inside a class and provides controlled access to the object's internal state.**

---

# 📝 Summary

| Concept          | Purpose                         |
| ---------------- | ------------------------------- |
| `private` fields | Hide internal state             |
| Getter           | Controlled read access          |
| Setter           | Controlled write access         |
| Business methods | Controlled state changes        |
| Validation       | Prevent invalid state           |
| Encapsulation    | Protect and manage object state |

---

## 🚀 Best Practice

Don't think:

> **Encapsulation = private fields + getters + setters**

Think:

> **Encapsulation = Protect the object's state and expose only the operations that are necessary and valid.**
