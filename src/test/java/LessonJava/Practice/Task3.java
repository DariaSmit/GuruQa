package LessonJava.Practice;

import java.util.Scanner;

// Подвать через консоль string и получать int ( пример с месяцами года).
public class Task3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equals("January")) {
            System.out.print(1);
        } else if (str.equals("February")) {
            System.out.print(2);
        } else if (str.equals("March")) {
            System.out.print(3);
        } else if (str.equals("April")) {
            System.out.print(4);
        } else if (str.equals("May")) {
            System.out.print(5);
        } else if (str.equals("June")) {
            System.out.print(6);
        } else if (str.equals("July")) {
            System.out.print(7);
        } else if (str.equals("August")) {
            System.out.print(8);
        } else if (str.equals("September")) {
            System.out.print(9);
        } else if (str.equals("October")) {
            System.out.print(10);
        } else if (str.equals("November")) {
            System.out.print(11);
        } else if (str.equals("December")) {
            System.out.print(12);
        } else {
            System.out.println("no");
        }
    switch (str){

        case ("March"):
            System.out.println(3);

        case ("April"):
            System.out.println(4);

        case ("May"):
            System.out.println(5);
            break;
        case ("June"):
            System.out.println(6);

        case ("July"):
            System.out.println(7);

        case ("August"):
            System.out.println(8);
            break;
        case ("September"):
            System.out.println(9);

        case ("October"):
            System.out.println(10);

        case ("November"):
            System.out.println(11);
            break;
        case ("December"):
            System.out.println(12);

        case ("January"):
            System.out.println(1);

        case ("February"):
            System.out.println(2);
            break;
        default:
            System.out.println("no");
    }
    }

}



