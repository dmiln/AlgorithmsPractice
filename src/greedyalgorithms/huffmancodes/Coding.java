package greedyalgorithms.huffmancodes;


import java.util.*;

public class Coding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        ArrayList<int[]> freqMas = initString(string);
        ArrayList<int[]> frM = initString(string);
        showAlphabet(freqMas);
        ArrayList<Node> tree = createTree(freqMas);
        printCode(frM, tree, string);
    }

    private static void printCode(ArrayList<int[]> frequince, ArrayList<Node> tree, String s) {
        int count = 0;
        TreeMap<Integer, String> alphabet = new TreeMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        frequince = sortBubleList(frequince, 0);
        for (int[] aFrequince : frequince) {
            StringBuilder sB = new StringBuilder();
            int letterStr = aFrequince[0];
            Node node = null;
            Node prnt;
            for (Node aTree : tree) {
                if (aTree.getLetter() == letterStr) {
                    node = aTree;
                    break;
                }
            }
            assert node != null;
            prnt = node.getParent();
            while (true) {
                if (node.getPosition().equals("left")) {
                    sB.append(0);
                } else if (node.getPosition().equals("right")) {
                    sB.append(1);
                }
                node = prnt;
                if (prnt == null) {
                    break;
                }
                if (prnt.getParent() == null) {
                    break;
                }
                prnt = node.getParent();
            }
            sB.reverse();
            count += aFrequince[1] * sB.length();
            alphabet.put(letterStr, sB.toString());
            stringBuilder.append((char) letterStr).append(": ").append(sB.toString());
            stringBuilder.append("\n");
        }
        System.out.println(frequince.size() + " " + count);
        System.out.print(stringBuilder);
        for (int i = 0; i < s.length(); i++){
            System.out.print(alphabet.get((int)s.charAt(i)));
        }
    }

    private static ArrayList<Node> createTree(ArrayList<int[]> quarity) {
        ArrayList<Node> nodes = new ArrayList<>();
        if (quarity.size() == 1) {
            nodes.add(new Node(quarity.get(0)[0], quarity.get(0)[1]));
            nodes.get(0).setPosition();
            return nodes;
        }
        while (quarity.size() != 1) {
            int[] left = quarity.get(0);
            int[] right = quarity.get(1);
            Node leftNode = null;
            Node rightNode = null;

            for (Node node : nodes) {
                if (node.getLetter() == left[0] && node.getFrequency() == left[1]) {
                    leftNode = node;
                    break;
                }
            }
            for (Node node : nodes) {
                if (node.getLetter() == right[0] && node.getFrequency() == right[1]) {
                    rightNode = node;
                    break;
                }
            }

            if (leftNode == null) {
                leftNode = new Node(left[0], left[1]);
                nodes.add(leftNode);
            }
            if (rightNode == null) {
                rightNode = new Node(right[0], right[1]);
                nodes.add(rightNode);
            }
            Node prnt = Node.addNode(leftNode, rightNode);
            nodes.add(prnt);
            quarity.remove(0);
            quarity.remove(0);
            quarity.add(new int[]{prnt.getLetter(), prnt.getFrequency()});
            quarity = sortBubleList(quarity, 1);
        }

        return nodes;
    }

    private static void showAlphabet(ArrayList<int[]> arrayList) {
        for (int[] i : arrayList) {
            System.out.print((char) i[0] + ":");
            System.out.print(i[1] + "  ");
        }
        System.out.println();
    }
    private static ArrayList<int[]> sortBubleList(ArrayList<int[]> arrayList, int position) {
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 1; j < arrayList.size(); j++) {
                if (arrayList.get(j - 1)[position] > arrayList.get(j)[position]) {
                    Collections.swap(arrayList, j, j - 1);
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<int[]> initString(String string) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < string.length(); ) {
            int count = 1;
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    count++;
                    string = string.substring(i, j) + string.substring(j + 1);
                    j--;
                }
            }
            result.add(new int[]{string.charAt(i), count});
            string = string.substring(i + 1);
        }
        return  sortBubleList(result, 1);
    }

    static class Node {
        static int id = 999;
        int letter;
        int frequency;
        Node left, right;
        Node parent = null;
        String position = null;


        Node(int letter, int frequency) {
            this.letter = letter;
            this.frequency = frequency;
            id = id + 1;
        }

        static Node addNode(Node left, Node right) {
            int l = left.frequency;
            int r = right.frequency;
            Node prnt = new Node(id, l + r);
            prnt.left = left;
            prnt.right = right;
            left.position = "left";
            left.parent = prnt;
            right.position = "right";
            right.parent = prnt;
            return prnt;
        }

        int getFrequency() {
            return frequency;
        }

        int getLetter() {
            return letter;
        }

        Node getParent() {
            return parent;
        }

        String getPosition() {
            return position;
        }

        void setPosition() {
            this.position = "left";
        }

    }
}
