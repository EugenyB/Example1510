package lab3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by eugeny on 15.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        String t = "Hello World temp other";
        String[] arr = t.split(" ");
        for (String s : arr) {
            System.out.println(s);
        }

        Person[] persons = {
                new Person("Ярик","Пушкарь", 1943, "911"),
                new Person("Алексей","Беркунский", 1995, "1234"),
                new Person("Артем","Михайлов",1996,"5678"),
                new Person("Сергей","Митрофанов",1990,"5555"),
                new Person("Сергей","Сидоров",1996,"1878")
        };

        Arrays.sort(persons, Comparator.comparing(Person::getName).thenComparing(Person::getPhone));
        print(persons);
        Scanner in = new Scanner(System.in);
        String phone = in.nextLine();
        printByPhone(persons,phone);
    }

    private void printByPhone(Person[] persons, String phone) {
        boolean find = false;
        for (Person person : persons) {
            if(person.getPhone().startsWith(phone)){
                System.out.println(person);
                find = true;
            }
        }
        if (!find) {
            System.out.println("Нет таких");
        }
    }

    private void print(Person[] persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
