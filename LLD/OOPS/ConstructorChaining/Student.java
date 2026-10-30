class Student {

    int id;
    String name;
    int age;

    // Default constructor
    Student() {
        this(101);
        System.out.println("Default Constructor Called");
    }

    // Parameterized constructor with one parameter
    Student(int id) {
        this(id, "Rahul");
        System.out.println("One Parameter Constructor Called");
    }

    // Parameterized constructor with two parameters
    Student(int id, String name) {
        this(id, name, 20);
        System.out.println("Two Parameter Constructor Called");
    }

    // Parameterized constructor with three parameters
    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        System.out.println("Three Parameter Constructor Called");
    }

    void display() {
        System.out.println("\nStudent Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.display();
    }

}