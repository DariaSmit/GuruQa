package LessonJava.Practice;

import java.util.Scanner;

// Подвать через консоль string и получать int ( пример с месяцами года).
public class Task3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equals("January")) {
            System.out.print(1);}
            else if (str.equals("February")){
            System.out.print(2);}
        else if (str.equals("March")) {
            System.out.print(3);}
            else if (str.equals("April")) {
            System.out.print(4);}
            else if (str.equals("May")) {
            System.out.print(5);}
           else if (str.equals("June")) {
            System.out.print(6);}
           else if (str.equals("July")) {
            System.out.print(7); }
           else if (str.equals("August")) {
            System.out.print(8); }
           else if (str.equals("September")) {
            System.out.print(9); }
           else if (str.equals("October")) {
            System.out.print(10); }
           else if (str.equals("November")) {
            System.out.print(11); }
           else if (str.equals("December")) {
            System.out.print(12); }
            else {
                System.out.println("no");
        }

        }
    }



