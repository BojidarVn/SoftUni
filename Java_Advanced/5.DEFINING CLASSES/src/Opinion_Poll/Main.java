package Opinion_Poll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);
            persons.add(person);
        }
        //persons= persons.stream()                   na4in za proverka dali mi e mahnalo izli6nite
        //         .filter(p -> p.getAge() >30).collect(Collectors.toList());
        // System.out.println();

        persons.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))         //sorted((p1,p2) ->p1.getName().compareTo(p2.getName()));
                .forEach(person -> {
                    System.out.printf("%s - %d\n",person.getName(),person.getAge());
                });
    }
}
