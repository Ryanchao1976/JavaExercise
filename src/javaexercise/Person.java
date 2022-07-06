package javaexercise;

public class Person {

    String firstName;
    String lastName;
    String birthday;
    int age;

    Person(String firstName, String lastName, String birthday, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.age = age;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    String getBirthday() {
        return birthday;
    }

    int getAge() {
        return age;
    }

    //這個對之後要印出東西，會有幫助，所以請留著他。
    @Override
    public String toString() {
        return new StringBuilder(getFirstName()).append("-").append(getLastName()).toString();
    }

}
