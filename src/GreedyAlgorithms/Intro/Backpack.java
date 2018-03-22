package GreedyAlgorithms.Intro;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Backpack {

    public static void main(String[] args) {
        ArrayList<int[]> things = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int weigth = scanner.nextInt();
        CoverLines.scannThings(things, scanner, n);

        ArrayList<int[]> sortThings = new Backpack().sortThings(things);

        System.out.println(fillBackpack(sortThings, weigth));
    }

    private static double fillBackpack(ArrayList<int[]> things, int weigth) {
        double cost = 0;
        while (weigth > 0) {
            if (things.size() == 0){
                return cost;
            }
            for (int j = 0; weigth > 0 && j < things.get(0)[1]; j++) {
                cost += (double) things.get(0)[0] / things.get(0)[1];
                weigth--;
            }
            things.remove(0);
        }
        return cost;
    }

    private ArrayList<int[]> sortThings(ArrayList<int[]> things) {
        for (int i = 0; i < things.size() - 1; i++) {
            for (int j = i + 1; j < things.size(); j++) {
                if ((double) things.get(i)[0] / things.get(i)[1] < (double) things.get(j)[0] / things.get(j)[1]) {
                    Collections.swap(things, i, j);
                }
            }
        }
/*      for (int[] a: things){
            System.out.print(Arrays.toString(a));
        }*/
        System.out.println();
        return things;
    }

}
