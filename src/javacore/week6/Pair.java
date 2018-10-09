package javacore.week6;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class Pair<T, D> {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        System.out.println(i);
        System.out.println(s);

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);

        Pair<Integer, String> p1 = Pair.of(null,null);
        Pair<Integer, String> p2 = Pair.of(null,"Hello");
        Pair<Integer, String> p3 = Pair.of(null,null);

        boolean mustBeFalse = p1.equals(p2); // false!
        boolean mustAlsoBeFalse = p1.hashCode() == p2.hashCode(); // false!
        System.out.println(mustBeFalse);
        System.out.println(mustAlsoBeFalse);

        mustBeTrue = p1.equals(p3); // true!
        mustAlsoBeTrue = p1.hashCode() == p3.hashCode(); // true!
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);

/*        Collection<?> collection = new LinkedList<>();
        Object object = 3;

        collection.toArray();
        collection.iterator();
        collection.remove(object);
        collection.contains(object);
        collection.clear();
        collection.size();*/
    }


    private static final Pair<?, ?> EMPTY = new Pair<>();

    private final T first;
    private final D second;

    private Pair() {
        this.first = null;
        this.second = null;
    }

    private Pair(T first, D second){
        this.first = first;
        this.second = second;
    }

    public static <T,D> Pair<T,D> of(T first, D second){
        return new Pair<>(first,second);
    }

    public T getFirst() {
/*        if (first == null) {
            throw new NoSuchElementException("No value present");
        }*/
        return first;
    }

    public D getSecond() {
/*        if (second == null) {
            throw new NoSuchElementException("No value present");
        }*/
        return second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Pair)) {
            return false;
        }

        Pair<?,?> other = (Pair<?,?>) obj;

        return (Objects.equals(first, other.first)) && (Objects.equals(second, other.second));
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(first) + Objects.hashCode(second);
    }
}
