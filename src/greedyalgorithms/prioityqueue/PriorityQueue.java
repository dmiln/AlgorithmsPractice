package greedyalgorithms.prioityqueue;

import java.util.ArrayList;
import java.util.Scanner;

public class PriorityQueue {

    private static ArrayList<Integer> queue = new ArrayList<>();

    public static void main(String[] args) {
        /*long startTime = System.currentTimeMillis();*/
        run();
        /*long endTime = System.currentTimeMillis();
        System.out.println("Programm execution time: " + (endTime - startTime));*/
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
        int currentPosition = 0;
        queue.set(currentPosition, 0);
        while (true) {
            int posLeftChild = 2 * currentPosition + 1;
            int posRightChild = 2 * currentPosition + 2;
            int size = queue.size() - 1;
            if (posLeftChild <= size) {
                if (posRightChild <= size) {
                    int firstChildValue = queue.get(posLeftChild);
                    int secondChildValue = queue.get(posRightChild);
                    if (firstChildValue >= secondChildValue) {
                        queue.set(posLeftChild, queue.get(currentPosition));
                        queue.set(currentPosition, firstChildValue);
                        currentPosition = posLeftChild;
                        if (currentPosition >= size) {
                            break;
                        }
                    } else {
                        queue.set(posRightChild, queue.get(currentPosition));
                        queue.set(currentPosition, secondChildValue);
                        currentPosition = posRightChild;
                        if (currentPosition >= size) {
                            break;
                        }
                    }
                } else {
                    int firstChildValue = queue.get(posLeftChild);
                    queue.set(posLeftChild, queue.get(currentPosition));
                    queue.set(currentPosition, firstChildValue);
                    currentPosition = posLeftChild;
                    if (currentPosition >= size) {
                        break;
                    }
                }
            } else {
                break;
            }
        }

    }

    private static void insert(int value) {
        queue.add(value);
        int currentPosition = queue.size() - 1;
        while (true) {
            if (currentPosition > 0 && currentPosition % 2 == 0) {
                int parentValue = queue.get((currentPosition - 2) / 2);
                int childValue = queue.get(currentPosition);
                if (childValue > parentValue) {
                    queue.set((currentPosition - 2) / 2, childValue);
                    queue.set(currentPosition, parentValue);
                    currentPosition = (currentPosition - 2) / 2;
                } else {
                    break;
                }
            } else if (currentPosition > 0 && currentPosition % 2 == 1) {
                int parentValue = queue.get((currentPosition - 1) / 2);
                int childValue = queue.get(currentPosition);
                if (queue.get(currentPosition) > parentValue) {
                    queue.set((currentPosition - 1) / 2, childValue);
                    queue.set(currentPosition, parentValue);
                    currentPosition = (currentPosition - 1) / 2;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    /*private static void removeTop() {
        int currentPosition = 0;
        queue.set(currentPosition, 0);
        while (true) {
            int posLeftChild = 2 * currentPosition + 1;
            int posRightChild = 2 * currentPosition + 2;
            int size = queue.size() - 1;
            if (posLeftChild <= size) {
                if (posRightChild <= size) {
                    int firstChildValue = queue.get(posLeftChild);
                    int secondChildValue = queue.get(posRightChild);
                    if (firstChildValue >= secondChildValue) {
                        queue.set(posLeftChild, queue.get(currentPosition));
                        queue.set(currentPosition, firstChildValue);
                        currentPosition = posLeftChild;
                        if (currentPosition >= size) {
                            break;
                        }
                    } else {
                        queue.set(posRightChild, queue.get(currentPosition));
                        queue.set(currentPosition, secondChildValue);
                        currentPosition = posRightChild;
                        if (currentPosition >= size) {
                            break;
                        }
                    }
                } else {
                    int firstChildValue = queue.get(posLeftChild);
                    queue.set(posLeftChild, queue.get(currentPosition));
                    queue.set(currentPosition, firstChildValue);
                    currentPosition = posLeftChild;
                    if (currentPosition >= size) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
    }*/
}

    /*private static void removeTop() {
        int currentPosition = 0;
        queue.set(currentPosition, 0);
        while (true){
            int posLeftChild = 2 * currentPosition + 1;
            int posRightChild = 2 * currentPosition + 2;
            int size = queue.size() - 1;
            if (posLeftChild <= size && posRightChild <= size) {
                int firstChildValue = queue.get(posLeftChild);
                int secondChildValue = queue.get(posRightChild);
                if (firstChildValue >= secondChildValue) {
                    queue.set(posLeftChild, queue.get(currentPosition));
                    queue.set(currentPosition, firstChildValue);
                    currentPosition = posLeftChild;
                    if (currentPosition >= size){
                        break;
                    }
                } else {
                    queue.set(posRightChild, queue.get(currentPosition));
                    queue.set(currentPosition, secondChildValue);
                    currentPosition = posRightChild;
                    if (currentPosition >= size){
                        break;
                    }
                }
            }else if(posLeftChild <= size){
                int firstChildValue = queue.get(posLeftChild);
                queue.set(posLeftChild, queue.get(currentPosition));
                queue.set(currentPosition, firstChildValue);
                currentPosition = posLeftChild;
                if (currentPosition >= size){
                    break;
                }
            }else{
                break;
            }
        }
    }*/
