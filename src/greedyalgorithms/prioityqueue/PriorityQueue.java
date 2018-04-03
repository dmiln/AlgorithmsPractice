/*
package greedyalgorithms.prioityqueue;

import java.util.ArrayList;
import java.util.Scanner;

public class PriorityQueue {

    private static ArrayList<Integer> queue = new ArrayList<>();

    public static void main(String[] args) {
        java.util.PriorityQueue priorityQueue = new java.util.PriorityQueue();
        run();
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
        int numOfOperations = s.split("\n").length;
        for (int i = 1; i < numOfOperations; i++) {
            String method = getMethod(s, i);
            if (method.equals("Insert")) {
                int value = getValue(s, i);
                insert(value);
            } else if (method.equals("ExtractMax")) {
                extractMax();
            }
        }
    }

    private static void extractMax() {
        System.out.println(queue.get(0));
        remove();
    }

    private static void insert(int value) {
        queue.add(value);
        int currentPosition = queue.size() - 1;
        while (true) {
            if (currentPosition > 0) {
                if (currentPosition % 2 == 0) {
                    int parentValue = queue.get((currentPosition - 2) / 2);
                    int childValue = queue.get(currentPosition);
                    if (childValue > parentValue) {
                        queue.set((currentPosition - 2) / 2, childValue);
                        queue.set(currentPosition, parentValue);
                        currentPosition = (currentPosition - 2) / 2;
                    } else {
                        break;
                    }
                } else {
                    int parentValue = queue.get((currentPosition - 1) / 2);
                    int childValue = queue.get(currentPosition);
                    if (queue.get(currentPosition) > parentValue) {
                        queue.set((currentPosition - 1) / 2, childValue);
                        queue.set(currentPosition, parentValue);
                        currentPosition = (currentPosition - 1) / 2;
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
    }

    private static void remove() {
        queue.set(0, 0);
        int size = queue.size();
        for (int i = 0; 2 * i + 1 < size - 1; ) {
            int posLch = 2 * i + 1;
            int lChVal = queue.get(posLch);
            int posRch = 2 * i + 2;
            if (posRch < queue.size()) {
                int rChVal = queue.get(posRch);
                if (lChVal >= rChVal) {
                    queue.set(posLch, queue.get(i));
                    queue.set(i, lChVal);
                    i = posLch;
                } else {
                    queue.set(posRch, queue.get(i));
                    queue.set(i, rChVal);
                    i = posRch;
                }
            } else {
                queue.set(posLch, queue.get(i));
                queue.set(i, lChVal);
                i = posLch;
            }
        }
    }
}*/
