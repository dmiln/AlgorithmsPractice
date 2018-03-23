package GreedyAlgorithms.Intro;

import java.util.ArrayList;
import java.util.Scanner;

public class FillN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = fillN(n);
        System.out.println(list.size());
        for (int i: list){
            System.out.print(i + " ");
        }
    }

    private static ArrayList<Integer> fillN(int n){
        ArrayList<Integer> result = new ArrayList<>();
        int in = 1;
        int sum = 0;
        while (true){
            if (canDecompose(in , sum, n)) {
                result.add(in);
                sum += in;
                in++;
            }else{
                result.add(n - sum);
                break;
            }
        }
        return result;
    }

    private static boolean canDecompose(int in, int sum, int n){
        for (int i = in; i < n; i++){
            if (sum + i <= n - sum){
                return true;
            }
        }
        return false;
    }
}
