package divideandrule;

import java.util.*;

public class MergeSort {

    private long inversions = 0;

    public static void main(String[] args) {
        new MergeSort().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        MergeSort MergeS = new MergeSort();
        A = MergeS.iterativeMergeSort(A);
        System.out.println(MergeS.inversions);
    }

    private int[] iterativeMergeSort(int[] x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i : x) {
            queue.add(new int[]{i});
        }
        int k = 1;
        double d = 0;
        while (Math.pow(2, k) < queue.size()) {
            k++;
            d = Math.pow(2, k);
        }
        while (queue.size() < d) {
            queue.add(new int[]{Integer.MAX_VALUE});
        }
        for (int[] q : queue) {
            System.out.print(Arrays.toString(q));
        }
        System.out.println();
        while (queue.size() > 1) {
            queue.add(merge(queue.pop(), queue.pop()));
        }
        return queue.getFirst();
    }

    /**
     * Сливает два отсортированных массива в один
     */
    private int[] merge(int[] x, int[] y) {
        int[] result = new int[x.length + y.length];
        int i = 0;
        int j = 0;
        while (true) {
            if (i >= x.length && j >= y.length) {
                break;
            } else if (i >= x.length) {
                result[i + j] = y[j];
                j++;
                continue;
            } else if (j >= y.length) {
                result[i + j] = x[i];
                i++;
                continue;
            }
            if (x[i] <= y[j]) {
                result[i + j] = x[i];
                i++;
            } else {
                result[i + j] = y[j];
                j++;
                inversions += x.length - i;
            }
        }
        return result;
    }
}
