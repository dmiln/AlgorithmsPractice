package javacore.week5;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Chars {

    public static void main(String[] args) throws IOException {
        for (byte b : "Ы".getBytes(StandardCharsets.UTF_8)){
            System.out.printf("%d ", Byte.toUnsignedInt(b));
        }
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        String result = "";
        Reader reader = new InputStreamReader(inputStream,charset);
        int b;
        while ((b = reader.read()) != -1){
            result += (char)b;
        }
        return result;
    }
}
