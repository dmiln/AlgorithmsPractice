package divideandrule;

import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {
    private int height = 0;

    public static void main(String[] args) {
        new PointsAndSegments().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] points = new int[m];
        int[] leftPoints = new int[n];
        int[] rightPoints = new int[n];
        for (int i = 0; i < n; i++) {
            leftPoints[i] = scanner.nextInt();
            rightPoints[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        StringBuilder sB = new StringBuilder();
        for (int i : points) {
            int a, b;
            quicks(leftPoints, 0, n - 1, height);
            if (height >= Math.log10(leftPoints.length)){
                Arrays.parallelSort(leftPoints);
            }
            height = 0;
            quicks(rightPoints, 0, n - 1, height);
            if (height >= Math.log10(rightPoints.length)){
                Arrays.parallelSort(rightPoints);
            }
            a = startsBefore(leftPoints, i);
            b = endsBefore(rightPoints, i);
            sB.append(String.valueOf(a - b)).append(" ");
        }

        System.out.println(sB.toString());
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
        while (i < b.length && b[i] <= point) {
            i++;
        }
        return i;
    }

    private void quicks(int[] elements, int left, int right, int heigth) {
        if (heigth >= Math.log(elements.length)){
            return;
        }
        int i = left, j = right;
        int pivot = elements[(left + right) / 2];
        while (i <= j)
        {
            while (elements[i] < pivot)
            {
                i++;
            }

            while (elements[j] > pivot)
            {
                j--;
            }

            if (i <= j)
            {
                int tmp = elements[i];
                elements[i] = elements[j];
                elements[j] = tmp;

                i++;
                j--;
            }
        }
        if (left < j)
        {
            quicks(elements, left, j, ++heigth);
        }
        if (i < right)
        {
            quicks(elements, i, right, ++heigth);
        }
    }
}
