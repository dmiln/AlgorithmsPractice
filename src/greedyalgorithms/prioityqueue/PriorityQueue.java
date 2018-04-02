package greedyalgorithms.prioityqueue;

import java.util.ArrayList;
import java.util.Scanner;

public class PriorityQueue {

    private static ArrayList<Integer> queue = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(scanInstructions());
    }

    private static String scanInstructions() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder instructions = new StringBuilder();
        int numOfInstr = scanner.nextInt();
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            instructions.append(s).append("\n");
            numOfInstr--;
            if (numOfInstr < 0) {
                break;
            }
        }
        return instructions.toString();
    }

    private static String getMethod(String s, int i) {
        String[] str = s.split("\n");
        if (i < str.length) {
            return str[i].split(" ")[0];
        } else {
            return "error";
        }
    }

    private static int getValue(String s, int i) {
        String[] str = s.split("\n");
        if (i < str.length) {
            return Integer.parseInt(str[i].split(" ")[1]);
        } else {
            return 0;
        }

    }

    private static void run() {
        String s = scanInstructions();
        for (int i =0; i < s.split("\n").length; i++){
            String method = getMethod(s, i);
            if (method.equals("Insert")){
                int value = getValue(s, i);
                insert(value);
            }else if(method.equals("ExtractMax")){
                extractMax();
            }
        }
    }

    private static void extractMax() {
        System.out.println(queue.get(0));
    }

    private static void insert(int value) {
        queue.add(value);
    }
}
