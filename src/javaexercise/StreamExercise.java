package javaexercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ryan
 */
public class StreamExercise {

    public static void main(String[] args) {

        // Stream將要處理的元素集合看作一種 '流'，在流的過程中，藉助Stream API對流中的元素進行操作，比如：篩選、排序、聚合等。
        // Stream可以由陣列或集合建立，對流的操作分為兩種：
        //中間操作，每次返回一個新的流，可以有多個。
        //終端操作，每個流只能進行一次終端操作，終端操作結束後流無法再次使用。終端操作會產生一個新的集合或值。

        //Stream有幾個特性：
        //stream不儲存資料，而是按照特定的規則對資料進行計算，一般會輸出結果。
        //stream不會改變資料來源，通常情況下會產生一個新的集合或一個值。
        //stream具有延遲執行特性，只有呼叫終端操作時，中間操作才會執行。

        List<Person> people = Arrays.asList(
                new Person("Eddie", "Peng", "I don't know", 0),
                new Person("Bill", "Gates", "1999/10/28", 21),
                new Person("Jobs", "Steve", "1996/02/24", 24),
                new Person("May", "Frank", "1976/09/12", 44),
                new Person("Judy", "James", "1978/12/24", 42),
                new Person("Ben", "Friend", "1995/02/10", 25),
                new Person("Jobs", "Yang", "1997/01/22", 23));

        people.forEach(System.out:: println);

        long count = people.stream().filter( p -> p.age > 30).count();
        System.out.println("Age > 30 count: " + count);

        List<Person> result = people.stream()
            .filter( p -> p.age > 30)
            .collect(Collectors.toList());
        System.out.println(result);

        Optional<Person> oldestPerson = people.stream().max(Comparator.comparingInt(Person:: getAge));
        System.out.println("oldestPerson: " + oldestPerson.get());

        // map: 對當前傳入的stream進行處理並轉換成另一個stream/對stream裡面的每一個元素進行轉換
        List<String> birthdays = people.stream().map( p ->  p.birthday).collect(Collectors.toList());
        System.out.println(birthdays);

        List<String> words = Arrays.asList("Hello", "World");
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split(""))) //代表切除空字串，所以每切一次就讓每個字換行。
                .distinct() // 把不一樣字母分割出來。
                .forEach(System.out::println);

        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> listNew = list.stream().flatMap(s -> {
            // 將每個元素轉換成一個stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());

        System.out.println("處理前的集合：" + list);
        System.out.println("處理後的集合：" + listNew);

        List<Integer> numbers = Arrays.asList(1, 3, 2, 8, 11, 4);
        // 求和方式1
        Optional<Integer> sum = numbers.stream().reduce((x, y) -> x + y);
        System.out.println("sum：" + sum);

        Optional<Integer> sum2 = numbers.stream().reduce(Integer::sum);
        System.out.println("sum2：" + sum2);

        Integer sum3 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum3：" + sum3);

        // 求乘積
        Optional<Integer> product = numbers.stream().reduce((x, y) -> x * y);
        System.out.println("product：" + product);

        // 求最大值方式1
        Optional<Integer> max = numbers.stream().reduce((x, y) -> x > y ? x : y);
        System.out.println("max：" + max);

        // 求最大值寫法2
        Integer max2 = numbers.stream().reduce(1, Integer::max);
        System.out.println("max2：" + max2);
    }
}
