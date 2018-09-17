package javacore.week4;

public class Exc2 {
    public static void main(String[] args) {
        try {
            int d = 0;
            int a = 42 / d;
            System.out.println("leha pidr");
        }
        catch (ArithmeticException e) {
            System.out.println("деление на ноль");
        }
    }
}
