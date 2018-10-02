package javacore.week5;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class FromWtoU {
    public static void main(String[] args) throws IOException {
        byte[] arr = {1, 2, 3, 10, 13, 4, 5, 6 };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
        System.setIn(inputStream);
        int b = 0;
        int c;
        while ((c = System.in.read()) != -1) {
            if (b == 13) {
                if (c == 10) {
                    System.out.print(c);
                    System.out.print(" ");
                    b = 0;
                    continue;
                } else {
                    System.out.print(b);
                    System.out.print(" ");
                    b = 0;
                }
            }
            if (c == 13) {
                b = 13;
            } else {
                System.out.print(c);
                System.out.print(" ");
            }
        }
        if (b == 13) {
            System.out.print(b);
            System.out.print(" ");
        }
        System.out.flush();
    }
}