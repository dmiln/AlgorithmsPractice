package greedyalgorithms.intro;

import java.util.Arrays;

public class SortBuble {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortBuble(new int[]{9,8,7,6,5,4,3,2,1})));
    }

    private static int[] sortBuble(int[] array){
        for(int i = 0; i < array.length; i++){
            for (int j = 1; j < array.length; j++){
                if (array[j] < array[j - 1]){
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
        return array;
    }
}
