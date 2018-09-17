package javacore.week4;

public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    private static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        if (stackTraceElement.length < 4){
            return null;
        }else {
            StackTraceElement s = stackTraceElement[3];
            stringBuilder.append(s.getClassName()).append("#").append(s.getMethodName());
            return stringBuilder.toString();
        }
    }
}
