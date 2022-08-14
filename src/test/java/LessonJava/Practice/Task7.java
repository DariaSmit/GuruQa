package LessonJava.Practice;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        // получаю три числа - существует ли треугольник с размерами этих сторон.

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a");
        int a = scanner.nextInt();
        System.out.println("enter b");
        int b = scanner.nextInt();
        System.out.println("enter c");
        int c = scanner.nextInt();
        System.out.println("result");
        if (a + b > c || a + c > b || b + c > a) {
            System.out.println("done");

        }
    }
}