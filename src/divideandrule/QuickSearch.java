package divideandrule;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSearch {

    public static void main(String[] args) {
        new QuickSearch().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] points = new int[m];
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = scanner.nextInt();
            right[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }

        Arrays.parallelSort(left);
        Arrays.parallelSort(right);
        StringBuilder s = new StringBuilder();
        for (int p : points) {
            int k = startsBefore(left, p);
            int l = endsBefore(right, p);
            s.append(String.valueOf(k - l)).append(" ");
        }
        System.out.println(s.toString());
    }

    private int startsBefore(int[] a, int point) {
        int i = 0;
        while (i < a.length && a[i] <= point) {
            i++;
        }
        return i;
    }

    private int endsBefore(int[] b, int point) {
        int i = 0;
        while (i < b.length && b[i] < point) {
            i++;
        }
        return i;
    }
}
