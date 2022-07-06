package javaexercise.v16;

import java.util.Objects;

/**
 * @author Ryan
 *
 * The primary reasons to provide an explicit declaration of the constructor methods are to validate constructor arguments
 */
public record Person2(String name, String gender, int age) {

    public Person2 {
        Objects.requireNonNull(name);
        Objects.requireNonNull(gender);
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0");
        }
    }

    public int age() {
        return age < 0 ? 0 : age;
    }

    public void extraMethod()
    {
        System.out.println("This is a extraMethod of a Record.");
    }

}
