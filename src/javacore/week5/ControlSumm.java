package javacore.week5;

import java.io.IOException;
import java.io.InputStream;

public class ControlSumm {

    public static void main(String[] args) {

    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int sum = 0;
        int c;
        while ((c = inputStream.read()) != -1){
            sum = Integer.rotateLeft(sum,1) ^ c;
        }
        return sum;
    }
}
