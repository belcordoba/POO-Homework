package models;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {

    }

    private void greet() {
        System.out.println("Hello, my name is " + name + "!");
    }

    private static void greetOtherPerson(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
