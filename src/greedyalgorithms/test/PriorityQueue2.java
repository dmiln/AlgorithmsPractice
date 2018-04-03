package greedyalgorithms.test;

import java.util.ArrayList;
import java.util.Scanner;

public class PriorityQueue2 {

    private static ArrayList<Integer> queue = new ArrayList<>();
    private static StringBuilder sB = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfInstr = scanner.nextInt();
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            numOfInstr--;
            String method = getMethod(s);
            if (method.equals("Insert")) {
                int value = getValue(s);
                insert(value);
            } else if (method.equals("ExtractMax")) {
                extractMax();
            }
            if (numOfInstr < 0) {
                break;
            }
        }
        System.out.println("");
        System.out.println(sB.toString());
    }

    private static String getMethod(String s) {
        String[] str = s.split(" ");
        return str[0];
    }

    private static int getValue(String s) {
        String[] str = s.split(" ");
        return Integer.parseInt(str[1]);
    }


    private static void extractMax() {
        sB.append(queue.get(0)).append("\n");
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
                    if (queue.get(currentPosition) > parentValue) {//
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
        for (int i = 0; 2 * i + 1 <= size - 1; ) {
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
            }
            else if (lChVal > queue.get(i)) {
                queue.set(posLch, queue.get(i));
                queue.set(i, lChVal);
                i = posLch;
            }else{break;}
        }
    }

}