package in.shahhardik;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class LamdasMapFilterReduce {
    public static void main(String args[]) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("ABC","ABC",30));
        people.add(new Person("PQR","PQR",61));
        people.add(new Person("LMN","LMN",59));
        people.add(new Person("EFG","EFG",28));
        people.add(new Person("HIJ","HIJ",54));
        people.add(new Person("XYZ","XYZ",57));

        Optional<Integer> average = people
                .stream().map(person -> person.getAge()).filter(age -> age < 35).reduce((a, b) -> (a + b) / 2);

        people.stream().map(person -> person.getAge()).filter(age -> age > 35).forEach(System.out::println);
        people.stream().filter(person -> person.age < 35).forEach(System.out::println);
        System.out.println(average);

    }

}
