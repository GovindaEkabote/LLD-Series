package LLD.OOPS.Inheritance;

class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

// 2. Multilevel Inheritance
class Puppy extends Dog {
    void weep() {
        System.out.println("Puppy is weeping");
    }
}

// 3. Hierarchical Inheritance
class Cat extends Animal {
    void meow() {
        System.out.println("Cat is meowing");
    }
}

// 4. Multiple Inheritance using Interfaces
interface Father {
    void fatherQuality();
}

interface Mother {
    void motherQuality();
}

class Child implements Father, Mother {
    public void fatherQuality() {
        System.out.println("Child inherits father's qualities");
    }

    public void motherQuality() {
        System.out.println("Child inherits mother's qualities");
    }
}

// 5. Hybrid Inheritance using Interfaces
interface Sports {
    void play();
}

class Student {
    void study() {
        System.out.println("Student is studying");
    }
}

class Result extends Student implements Sports {
    public void play() {
        System.out.println("Student is playing sports");
    }
}

// Main Class
public class Inheritance {
    public static void main(String[] args) {

        System.out.println("1. Single Inheritance");
        Dog d = new Dog();
        d.eat();
        d.bark();

        System.out.println("\n2. Multilevel Inheritance");
        Puppy p = new Puppy();
        p.eat();
        p.bark();
        p.weep();

        System.out.println("\n3. Hierarchical Inheritance");
        Cat c = new Cat();
        c.eat();
        c.meow();

        System.out.println("\n4. Multiple Inheritance");
        Child ch = new Child();
        ch.fatherQuality();
        ch.motherQuality();

        System.out.println("\n5. Hybrid Inheritance");
        Result r = new Result();
        r.study();
        r.play();
    }
}
