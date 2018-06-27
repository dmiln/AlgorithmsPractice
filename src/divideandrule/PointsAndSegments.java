package divideandrule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

    public static void main(String[] args) {
        new PointsAndSegments().run();
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<int[]> segments = new ArrayList<>();
        ArrayList<int[]> seg = new ArrayList<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            segments.add(new int[]{a, b});
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        for (int i : points) {
            int a = 0, b = 0;
            ArrayList<int[]> s = new ArrayList<>(segments);
            quickSort(s, 0, s.size() - 1, 0);
            a = searchByLeftHandsPoints(s, i);
            quickSort(s, 0, s.size() - 1, 1);
            b = searchByRightHandsPoints(s, i);
            System.out.print((a - b) + " ");
        }
    }

    private int searchByRightHandsPoints(ArrayList<int[]> list, int point) {
        int i = 0;
        while (list.size() - 1 >= i && list.get(i)[1] < point) {
            i++;
        }
        return i;
    }

    private int searchByLeftHandsPoints(ArrayList<int[]> list, int point) {
        int i = 0;
        while (list.size() - 1 >= i && point >= list.get(i)[0]) {
            i++;
        }
        return i;
    }

    private void quickSort(ArrayList<int[]> list, int l, int r, int mode) {
        if (l > r) {
            return;
        }
        if (list.size() < 10) {
            int m = parti(list, l, r, mode);
            quickSort(list, l, m - 1, mode);
            quickSort(list, m + 1, r, mode);
        } else {
            int[] m = partition(list, l, r, mode);
            quickSort(list, l, m[0] - 1, mode);
            quickSort(list, m[1] + 1, r, mode);
        }
    }

    private int parti(ArrayList<int[]> list, int l, int r, int mode){
        int x = list.get(l)[mode];
        int j = l;
        for (int i = l + 1; i <= r; i++){
            j = getJ(list, mode, x, j, i);
        }
        int[] empty = list.get(j);
        list.set(j, list.get(l));
        list.set(l, empty);
        return j;
    }

    private int[] partition(ArrayList<int[]> list, int l, int r, int mode) {
        int leftCounter = l;
        int rightCounter = r;
        int x = list.get(l + (r - l) / 2)[mode];
        while (leftCounter < list.size() - 1 && list.get(leftCounter)[mode] < x) {
            leftCounter++;
        }
        while (rightCounter > 1 && list.get(rightCounter)[mode] > x) {
            rightCounter--;
        }
        int j = l;
        for (int i = l + 1; i <= leftCounter; i++) {
            j = getJ(list, mode, x, j, i);
        }
        int[] empty = list.get(j);
        list.set(j, list.get(l));
        list.set(l, empty);
        int k = rightCounter;
        for (int i = rightCounter; i <= r; i++) {
            k = getJ(list, mode, x, k, i);
        }
        empty = list.get(k);
        list.set(k, list.get(rightCounter));
        list.set(rightCounter, empty);
        return new int[]{j, k};
    }

    private int getJ(ArrayList<int[]> list, int mode, int x, int j, int i) {
        if (list.get(i)[mode] <= x) {
            j++;
            int[] tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
        }
        return j;
    }

}
