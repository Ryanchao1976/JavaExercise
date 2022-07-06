import javaexercise.Converter;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {



    public static void main(String[] args) {

        Converter<String, Integer> converter = Integer::valueOf;    // method references
        Integer converted = converter.convert("123");
        System.out.println(converted); // 123

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (a, b) -> a.compareTo(b) );
        System.out.println(names); // 123

        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");     // "123"

        Optional<String> optional = Optional.of("bam");
        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> System.out.println(val));

        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);             // val33

//        map.computeIfPresent(9, (num, val) -> null);
//        map.containsKey(9);     // false

        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);    // true

        map.computeIfAbsent(3, num -> "bam");
        map.get(3);             // val33

        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9)); //// val9

        Predicate<String> pre = (@Nullable var a) -> true;


        var list = List.of("A", "B", "C");
        //list.add("D");
        var copy = List.copyOf(list);
        System.out.println("aaa: " + (list == copy));   // true

        var map2 = Map.of("A", 1, "B", 2);
        System.out.println(map2);    // {B=2, A=1}

        Stream.of(1, 2, 3, 2, 1)
                .dropWhile(n -> n < 3)
                .collect(Collectors.toList());  // [3, 2, 1]

        Stream.of(1, 2, 3, 2, 1)
                .takeWhile(n -> n < 3)
                .collect(Collectors.toList());  // [1, 2]

        Stream.of("a","b","c","","e","", "f")
                .dropWhile(s-> !s.isEmpty())
                .forEach(System.out::print);

        Stream.of(1, 2, 3, 2, 1, 3, 2, 1)
                .dropWhile(n -> n < 3)
                .forEach(System.out::print);

    }
}