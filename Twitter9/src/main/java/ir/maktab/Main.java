package ir.maktab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

            List<Person> people = new ArrayList<>();
            people.add(new Person("Alice", 30));
            people.add(new Person("Bob", 35));
            people.add(new Person("Charlie", 35));

//            Collections.sort(people);

        System.out.println(people.get(1).compareTo(people.get(2)));


//            for (Person person : people) {
//                System.out.println(person);
//            }
        }

    }
