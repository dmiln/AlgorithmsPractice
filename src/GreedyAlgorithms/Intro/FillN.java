package GreedyAlgorithms.Intro;

import java.util.ArrayList;
import java.util.Scanner;

public class FillN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = decompose(n);
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
        for (int i = 1; i <= n - sum; i++){
            if (2*in + i <= n - sum){
                return true;
            }
        }
        return false;
    }

    /*
    Написал более компактный рабочий алгоритм
     */
    private static ArrayList<Integer> decompose(int n){
        ArrayList<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i <= n - sum; i++){
            if (2*i + 1 <= n - sum){
                result.add(i);
                sum += i;
            }
        }
        result.add(n - sum);
        return result;
    }
}
