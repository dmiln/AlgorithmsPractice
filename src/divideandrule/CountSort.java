package divideandrule;

import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) {
        new CountSort().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        a = countSort(a);
        for (int i : a){
            stringBuilder.append(i).append(" ");
        }
        System.out.println(stringBuilder.toString());
    }

    private int[] countSort(int[] sourceArray) {
        int[] b = new int[10];
        int[] result = new int[sourceArray.length];
        for (int aSourceArray : sourceArray) {
            b[--aSourceArray] += 1;
        }
        for (int i = 1; i < b.length; i++){
            b[i] += b[i - 1];
        }
        for (int i = sourceArray.length - 1; i >= 0; i--){
            result[b[sourceArray[i] - 1] - 1] = sourceArray[i];
            b[sourceArray[i] - 1] -= 1;
        }
        return result;
    }
}
