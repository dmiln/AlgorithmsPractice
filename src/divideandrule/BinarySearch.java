package divideandrule;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        //long startTime = System.currentTimeMillis();
        new BinarySearch().run();
        //long endTime = System.currentTimeMillis();
        //System.out.println();
        //System.out.println("time = " + (endTime - startTime) + "ms");
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = scanArray(n, scanner);
        int k = scanner.nextInt();
        int[] b = scanArray(k, scanner);
        for (int anB : b) {
            System.out.print(binarySearch(anB, a) + " ");
        }
    }

    private int binarySearch(int reference, int[] array) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (array[m] == reference){
                return m + 1;
            }else if(array[m] > reference){
                r = m - 1;
            }else if(array[m] < reference){
                l = m + 1;
            }
        }
        return -1;
    }

    private int[] scanArray(int n, Scanner s) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        return a;
    }
}
