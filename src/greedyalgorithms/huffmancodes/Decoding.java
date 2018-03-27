package greedyalgorithms.huffmancodes;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Decoding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, String> treeMap = new TreeMap<>();
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        int iterator = 0;
        while (scanner.hasNext()){
            String a = scanner.next();
            String b = scanner.next();
            treeMap.put(a.substring(0,1), b);
            iterator++;
            if (iterator == k){
                break;
            }
        }
        String codeString = scanner.next();
        codeString = codeString.substring(0, l);

        for (int i = 1; i <= codeString.length(); i++){
            Set<Map.Entry<String, String>> set = treeMap.entrySet();
            for (Object aSet : set) {
                Map.Entry mapEntry = (Map.Entry) aSet;
                if (codeString.substring(0,i).equals(String.valueOf(mapEntry.getValue()))){
                    System.out.print(mapEntry.getKey());
                    codeString = codeString.substring(i);
                    i = 0;
                    break;
                }
            }
        }
    }

/*    private static void scanThings(TreeMap<String, String> treeMap, Scanner scanner, int k) {
        int i = 0;
        while (scanner.hasNext()){
            String a = scanner.next();
            String b = scanner.next();
            treeMap.put(a.substring(0,1), b);
            i++;
            if (i == k){
                break;
            }
        }
    }*/


}
