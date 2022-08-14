package LessonJava.Practice;

import java.util.Scanner;

public class Task1 {
    /*
        Пусть на ввод с клавиатуры дается буква П,
        нужно с помощью арифметической операции вывести
        букву "Я". (Используйте таблицу Unicode)
        */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str =scanner.nextLine ();
        if (str.charAt(0) >=97 && str.charAt(0)<=122){
            char ch = str.charAt(0);
            ch = (char) (ch -32);
            System.out.println(ch);
        } else {
            System.out.println("miss click");
        }
        char ch = str.charAt(0);
        ch = (char) (ch -32);
        System.out.println(ch);


    }
}