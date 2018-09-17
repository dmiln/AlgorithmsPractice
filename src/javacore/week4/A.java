package javacore.week4;

public class A extends B{
    private final String SECOND_NAME;

    public A(String name,String secondName){
        super(name);
        SECOND_NAME = secondName;
    }

    public String getSECOND_NAME() {
        return SECOND_NAME;
    }

    public static void main(String[] args) {
        A a = new A("Dima", "Ilin");
        B b = (B)a;

        B b1 = new B("Other");

        System.out.println(sqrt(16));
        System.out.println(sqrt(-16));
    }

    public static double sqrt(double x) {
        if (x >= 0){
            return Math.sqrt(x);
        }else {

            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
    }
}

