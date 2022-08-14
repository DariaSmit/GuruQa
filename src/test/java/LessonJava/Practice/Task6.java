package LessonJava.Practice;

import java.util.Scanner;

//Сколько нужно парт для учеников трёх классов.
public class Task6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int child1 = scanner.nextInt();
        int desk1 = (child1 / 2 + child1 % 2);
        System.out.println(desk1);

        int child2 = scanner.nextInt();
        int desk2 = (child2 / 2 + child2 % 2);
        System.out.println(desk2);

        int child3 = scanner.nextInt();
        int desk3 = (child3 / 2 + child3 % 2);
        System.out.println(desk3);
        scanner.close();

        System.out.println("result");
        int desk123 = (desk1 + desk2 + desk3);
        System.out.println(desk123);

    }

}
