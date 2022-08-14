package LessonJava.Practice;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        //пример
        int a = 6;
        int b = 2;
        int c = 4;
        System.out.println(a / b); //3
        System.out.println(a / c); //1
        System.out.println(a % b); //0
        System.out.println(a % c); //2

        // Вывести какое число введено в консоль : чётное или не чётное.
        //Условие задачи:
        //На ввод подаётся четырёхзначное число.
        //1000 - пример четырёхзначного числа.
        // Выведите сумму цифр этого числа.

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number % 2 == 0) {
            System.out.println("4etnoe");
        } else if (number % 2 != 0) {
            System.out.println("ne 4etnoe");


        }

        int a2 = (number / 1000); //= 1
        int a3 = (number % 1000 / 100); //2
        int a4 = (number % 100 / 10);
        int a5 = (number % 10);
        System.out.println(a2+a3+a4+a5);
        scanner.close();


    }
}
