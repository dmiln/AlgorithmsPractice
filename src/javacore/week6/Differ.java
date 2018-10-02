package javacore.week6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Differ {

    public static void main(String[] args) {

    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>(set1);
        for (T i : set2) {
            boolean b = result.add(i);
            if (!b) {
                result.remove(i);
            }
        }
        return result;
    }
}
