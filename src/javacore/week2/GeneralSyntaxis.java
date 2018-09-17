package javacore.week2;

import java.math.BigInteger;
import static java.lang.System.out;

public final class GeneralSyntaxis {

    final static int ELO = 13;

    public static void main(String[] args) {
        String roles[] = {"Городничий","Аммос Федорович","Артемий Филиппович","Лука Лукич"};
        String text[] = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?7",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        //System.out.println(text[0].substring(roles[0].length() + 2));
        //
        out.println(ELO);
        System.out.println(new GeneralSyntaxis().printTextPerRole(roles,text));
    }

    public final void ifH(final int l){
        final int i = 0;
        final int EL = 13;
    }

    public static boolean isPalindrome(String text) {
        String result = text.replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder sB = new StringBuilder(result);
        return result.toLowerCase().equals(sB.reverse().toString().toLowerCase());
    }

    private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder();
        StringBuilder[] stringBuilders = new StringBuilder[roles.length];

        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilders[i] = new StringBuilder();
            stringBuilders[i].append(roles[i]).append(":").append("\n");
        }

        for (int i = 0; i < textLines.length; i++){
            for (int j = 0; j < roles.length; j++){
                if (textLines[i].startsWith(roles[j] + ":")){
                    stringBuilders[j].append(i+1).append(")").append(" ").append(textLines[i].substring(roles[j].length() + 2)).append("\n");
                    break;
                }
            }
        }

        for (StringBuilder s : stringBuilders){
            result.append(s.toString()).append("\n");
        }

        return result.toString();
    }

    private static int[] mergeArrays(int[] a1, int[] a2) {
        int k = 0;
        int j = 0;
        int res[] = new int[a1.length + a2.length];
        for (int i = 0; i < res.length; i++){
            if (k < a1.length && j < a2.length){
                if (a1[k] < a2[j]){
                    res[i] = a1[k];
                    k++;
                }else {
                    res[i] = a2[j];
                    j++;
                }
            }else if(j < a2.length){
                res[i] = a2[j];
                j++;
            }else if(k < a1.length){
                res[i] = a1[k];
                k++;
            }
        }
        return res;
    }

    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(1);
        for(int i = 2; i <= value; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static boolean isPowerOfTwo(int value) {
        return Integer.bitCount(Math.abs(value)) == 1;
    }

    public static char charExpression(int a) {
        return (char)('\\' + a);
    }

    private static int leapYearCount(int year) {
        return year / 4 + year / 400 - year / 100;
    }

    private static boolean doubleExpression(double a, double b, double c) {
        System.out.println(a + b - c);
        System.out.println(Math.abs(a + b - c));
        return Math.abs(a + b - c) < 1E-4;
    }

    public static int flipBit(int value, int bitIndex) {
        int a = value >> bitIndex - 1;
        int b = value - (a << bitIndex - 1);
        System.out.println(a);
        a ^= 1;
        a = a << bitIndex - 1;
        return a | b;
    }
}
