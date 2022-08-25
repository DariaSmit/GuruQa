package jSonLession;

public class Main {
    public static void main(String[] args) {
        JSonSimpleParser parser = new JSonSimpleParser();
        Root root = (Root) parser.parse();

        System.out.println("Root" + root.toString());

    }
}
