package Gauss;

public class App {
    public static void main(String[] args) {
        GaussJacobiIterative gauss = new GaussJacobiIterative();
        double[][] matrix = { { 6, -1, -1, +4 }, { 1, -10, 2, -1 }, { 3, -2, 8, -1 }, { 1, 1, 1, -5 } };
        double[] result = { 17, -17, 19,-14 };

        gauss.setMatrix(matrix);
        gauss.setResult(result);
        System.out.println(gauss);

    }
}
