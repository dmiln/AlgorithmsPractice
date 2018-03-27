package greedyalgorithms.huffmancodes;

import java.util.*;

public class Coding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        Map<Character, Integer> tree = createTree(string);

        Set<Map.Entry<Character, Integer>> set = tree.entrySet();

        for (Object aSet : set) {
            Map.Entry mapEntry = (Map.Entry) aSet;
            System.out.print("freq: " + mapEntry.getKey() + " ");
            System.out.println("char: " + mapEntry.getValue());
        }
    }

    private static Map<Character, Integer> createTree(String str){
        TreeMap<Character, Integer> treeMap = new TreeMap<Character, Integer>();
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

/*    private static Map<Character, Integer> creaTree(String str){
        Map<Integer, Character> treeMap = new TreeMap<Integer, Character>();
        for (int i = 0; i < str.length(); i++){
            if (treeMap.containsValue(str.charAt(i))){
                treeMap.get(treeMap.)
            }else{

            }
        }

        return treeMap;
    }*/


}
