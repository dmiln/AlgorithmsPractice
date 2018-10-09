package javacore.week5;

import java.util.Scanner;

public class Summ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s");
        double result = 0;
        while (scanner.hasNext()){
            String s = scanner.next();
            try {
                double d = Double.parseDouble(s);
                result += d;
            }catch (IllegalArgumentException ignored){}

        }
        System.out.printf("%.6f",result);
    }
}
