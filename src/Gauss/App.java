package Gauss;

public class App {
    public static void main(String[] args) {
        // double[][] matrix = { { 6, -1, -1, 4 }, { 1, -10, 2, -1 }, { 3, -2, 8, -1 },
        // { 1, 1, 1, -5 } };
        // double[] result = { 17, -17, 19, -14 };
        double[][] matrix = { { 1, 0, 0, 0, 0 }, { 1, 0.5, Math.pow(0.5, 2),
                Math.pow(0.5, 3), Math.pow(0.5, 4) },
                { 1, 1, 1, 1, 1 }, { 1, 1.5, Math.pow(1.5, 2), Math.pow(1.5, 3),
                        Math.pow(1.5, 4) },
                { 1, 2, 4, 8, 16 } };
        double[] result = { 1, Math.sqrt(Math.E), Math.E, Math.sqrt(Math.pow(Math.E,
                3)), Math.pow(Math.E, 2) };
        GaussJacobiIterative gauss = new GaussJacobiIterative(result, matrix);
        System.out.println(gauss);
        System.out.println(gauss.equation());
    }
}
