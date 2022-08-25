package jSonLession;

public class People {
     String name;
     int age;

    People(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "People{" +
                "name'" + name +'\'' +
                ", age=" + age +
                '}';
    }
}
