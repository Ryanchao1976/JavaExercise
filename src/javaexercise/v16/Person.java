package javaexercise.v16;

import java.io.Serializable;

public record Person(String name, String gender, int age) implements Serializable {}
