package javaexercise.v16;

public record NestedRecord(String name, String gender, int age) {

    static Nested nested = new Nested("YO");

    public record  Nested(String name) {}
}
