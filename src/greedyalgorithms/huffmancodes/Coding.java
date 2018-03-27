package greedyalgorithms.huffmancodes;

import greedyalgorithms.intro.CoverLines;

import java.util.*;

public class Coding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
/*        Map<Character, Integer> tree = createTree(string);

        Set<Map.Entry<Character, Integer>> set = tree.entrySet();

        for (Object aSet : set) {
            Map.Entry mapEntry = (Map.Entry) aSet;
            System.out.print("freq: " + mapEntry.getKey() + " ");
            System.out.println("char: " + mapEntry.getValue());
        }*/

        ArrayList<int[]> freqMas = initString(string);
        for (int[] i: freqMas){
            System.out.print((char)i[0] + " ");
            System.out.println(i[1]);
        }

        System.out.println();

        freqMas = new CoverLines().sortBubleList(freqMas);
        for (int[] i: freqMas){
            System.out.print((char)i[0] + " ");
            System.out.println(i[1]);
        }
    }

    private static Map<Character, Integer> createTree(String str){
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < str.length(); i++){
            if (treeMap.containsKey(str.charAt(i))){
                int k = treeMap.get(str.charAt(i));
                treeMap.put(str.charAt(i), ++k);
            }else{
                treeMap.put(str.charAt(i), 1);
            }
        }
        return treeMap;
    }

    private static ArrayList<int[]> initString(String string){
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < string.length();){
            int count = 1;
            for (int j = i + 1; j < string.length(); j++){
                if (string.charAt(i) == string.charAt(j)){
                    count++;
                    string = string.substring(i, j) + string.substring(j + 1);
                    j--;
                }
            }
            result.add(new int[]{string.charAt(i),count});
            string = string.substring(i+1);
        }
        return result;
    }

}
