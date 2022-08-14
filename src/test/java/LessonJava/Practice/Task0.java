package LessonJava.Practice;

import java.util.Scanner;
//Task1
public class Task0 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter first number");
        int firstNumber = scanner.nextInt();
        System.out.println("enter second number");
        int secondNumber = scanner.nextInt();
        System.out.println("result");
        int sum = firstNumber + secondNumber;
        System.out.printf("%d + %d = %d",firstNumber,secondNumber,sum);


    }

}
