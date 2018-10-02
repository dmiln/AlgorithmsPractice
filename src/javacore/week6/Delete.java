package javacore.week6;

import java.util.*;

public class Delete {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            list.add(scanner.nextInt());
        }

        List<Integer> result = rem(list);

        for (Integer i : result){
            System.out.print(i + " ");
        }
    }

    private static List<Integer> rem(List<Integer> list) {
        List<Integer> integers = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        //Iterator<Integer> it = list.iterator();
        for (int i = 1; i < list.size(); i = i + 2){
            integers.add(list.get(i));
        }

        for (int i = integers.size() - 1; i >= 0; i--){
            res.add(integers.get(i));
        }

        return res;
    }


}
