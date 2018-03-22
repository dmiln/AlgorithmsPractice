package GreedyAlgorithms.Intro;

import java.util.*;

public class CoverLines {

    public static void main(String[] args) {
        ArrayList<int[]> vector = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] string = new String[n];
        Scanner str = new Scanner(System.in);
        while (n != 0) {
            --n;
            String[] parts = str.nextLine().split(" ");
            vector.add(new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
        }

        ArrayList<int[]> sortVector = new CoverLines().sortList(vector);

        coverLines(sortVector);
    }

    private static void coverLines(ArrayList<int[]> list) {
        int count = 0;
        ArrayList<Integer> points = new ArrayList<>();
        while (list.size() > 0) {
            ++count;
            points.add(list.get(0)[1]);
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j)[0] < list.get(0)[1]) {
                    list.remove(j);
                }
            }
            list.remove(0);
        }
        System.out.println(count);
        for (Object obj : points.toArray()) {
            System.out.print(obj + " ");
        }
    }

    private ArrayList<int[]> sortList(ArrayList<int[]> arrayList) {
        if (arrayList.size() > 1) {
            for (int i = 0; i < arrayList.size() - 1; i++) {
                for (int j = i + 1; j < arrayList.size(); j++) {
                    if (arrayList.get(i)[1] > arrayList.get(j)[1]) {
                        Collections.swap(arrayList, i, j);
                    }
                }
            }
        }
        return arrayList;
    }

}
