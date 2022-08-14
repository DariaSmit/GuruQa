package LessonJava.Practice;
///*
//    На вход подаётся некоторое число. Выведите количество десятков в этом числе.
//    Количество десятков - предпоследнее число.
//     */

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int a1 = (number % 100 /10);
        System.out.println(a1);
    }
}
