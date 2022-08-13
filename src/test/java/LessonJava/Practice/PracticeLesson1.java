package LessonJava.Practice;

import java.util.Scanner;

public class PracticeLesson1 {
    public static void main(String[] args){
        byte by = -128;
        byte by2 = 127;

        short sh = 1005;
        int in = 2_000_000;
        int in2 = 3_000_000;
        int in3 = 300_000_000;

        long lon = 1_000_000_000_000_000_000L;

        float flo = 1.22F;
        double doubl = 1.22222222222222222222222222222;
        float flo1 = (float) doubl;
        System.out.println(flo1);

        char ch = 56;
        System.out.println(ch);
        char ch1 = 'K';
        System.out.println(ch1);

        boolean b1 = true;
        boolean b2 = false;

        //ссылочные типы данных

        String str = "Meow"; // не изменяемый класс(
        String str2;
        String str3 = " ";
        String str4 = "Meow";
        String str5 = str + str3 + str4;
        System.out.println(str5);
        str = str + str3 + str4;
        System.out.println(str);

        Scanner scanner = new Scanner(System.in);

        String stri = scanner.nextLine();
        if (stri.equals("Monday")) {
            System.out.println("Monday");
         } else if (stri.equals("Wansday")){
            System.out.println("Wansday");
        } else if (stri.equals("sunday")) {
            System.out.println("sunday");
        } else {
            System.out.println("no");
        }
        switch (stri){
            case ("Monday"):
                System.out.println("Monday");

            case ("Wansday"):
                System.out.println("Wansday");

            case ("sunday"):
                System.out.println("sunday");

            default:
                System.out.println("no");
        }

    }

}

