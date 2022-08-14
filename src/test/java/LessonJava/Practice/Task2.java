package LessonJava.Practice;

import java.util.Scanner;

public class Task2 {

    /*
            Путешественник задумал путешествие на автомобиле. На ввод
            подается время в минутах, за которое он должен проехать
            дистанцию, и сама дистанция в километрах. Требуется найти
            необходимую скорость в км/ч.
            */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter min");
        double min = scanner.nextInt();
        System.out.println("km");
        double km = scanner.nextInt();
        System.out.println("result");
        double speed = km / min/60;
        System.out.println(speed);
    }
}