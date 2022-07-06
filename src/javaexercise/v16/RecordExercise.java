package javaexercise.v16;

import java.util.Arrays;

/**
 * @author Ryan
 * Records cannot extend other classes
 * Records are final
 * Records can implement interfaces
 * Records cannot create extra instance fields
 * The components of a record are implicitly final
 * Records can have static fields
 * The static methods, static fields, static initializers are allowed
 * We can declare constructors
 * We can add explicit accessors
 * Extra instance methods are allowed
 * Nested records are allowed(The nested records are implicitly static.)
 * Generic records are allowed
 * Records can be annotated
 * Records cannot be abstract
 *
 * https://www.logicbig.com/tutorials/core-java-tutorial/java-16-changes/java-records-features-quick-walk-through.html
 */
public class RecordExercise {



    public  static  void main(String[] args)
    {
        Person person = new Person("Jenny", "Female", 35);
        System.out.println(person); //Person[name=Jenny, gender=Female, age=35]

        Arrays.stream(Person.class.getInterfaces()).forEach(System.out::println);   //interface java.io.Serializable

        Person2 person2 = new Person2("john", "Male", 24);
        person2.extraMethod();

        GenericNumber<Double> d = new GenericNumber<>(3.2);
        System.out.println(d);  //GenericNumber[number=3.2]
    }
}
