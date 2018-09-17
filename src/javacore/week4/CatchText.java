package javacore.week4;

public class CatchText {
    public static void main(String[] args) {
        testCatch();
    }

    private static int testCatch(){
        try {

            B b = new B("naem");
            //System.exit(0);
            if (b.getNAME().equals(b.getNAME())) {
                return 1;
            }else {
                return 0;
            }
        } catch (Exception e) {
            int i = 13 / 0;
        } finally {
            System.out.println("finally");
        }
        return 5;
    }
}
