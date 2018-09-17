package javacore.week3;

import java.util.function.DoubleUnaryOperator;

public class LeftTriangle {

    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate( x -> Math.sin(x) / x , 1, 5));//0.603848

        System.out.println(integrateAlg(x -> 1, 0, 10));//10.0
        System.out.println(integrateAlg(x -> x + 2, 0, 10));//70.0
        System.out.println(integrateAlg( x -> Math.sin(x) / x , 1, 5));//0.603848
    }

        private static double integrate(DoubleUnaryOperator f, double a, double b) {
            double n = 1e7; //шаг сетки
            double h = (b - a) / n;
            double result = 0;

            for (int i = 0; i < n; i++) {
                result += f.applyAsDouble(a + i * h);
            }

            result *= h;

            return result;
        }

        private static double integrateAlg(DoubleUnaryOperator f, double a, double b) {
            double h = 1; //шаг сетки
            double n;
            double result = 0;
            double result1 = 0;

            n = (b - a) / h;

            for (int i = 0; i < n; i++) {
                result1 += f.applyAsDouble(a + i * h);
            }
            result1 *= h;

            while (true){
                double result2 = 0;
                h /= 10;
                n *= 10;

                for (int i = 0; i < n ; i++) {
                    result2 += f.applyAsDouble(a + i * h );
                }
                result2 *= h;

                if (Math.abs(result2 - result1) < 0.001){
                    result = result2;
                    break;
                }

                result1 = result2;
            }

            //System.out.println("шагов: " + n + "\tшаг:" + h);
            return result;
        }

}
