package GreedyAlgorithms.Intro;

import java.util.*;

public class CoverLines {

    public static void main(String[] args) {
        ArrayList<int[]> vector = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            vector.add(new int[]{a, b});
            i++;
            if (i == n){
                break;
            }
        }

        ArrayList<int[]> sortVector = new CoverLines().sortList(vector);

        coverLines(sortVector);
    }

    private static void coverLines(ArrayList<int[]> list) {
        int count = 0;
        ArrayList<Integer> points = new ArrayList<>();
        while (list.size() > 0) {
            points.add(list.get(0)[1]);
            for (int j = 1; j < list.size();) {
                if (list.get(j)[0] <= list.get(0)[1]) {
                    list.remove(j);
                }else {
                    ++j;
                }
            }
            list.remove(0);
            count++;
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
        /*for (int[] a: arrayList){
            System.out.print(Arrays.toString(a));
        }
        System.out.println();*/
        return arrayList;
    }

}
