package Gauss;

public class App {
    public static void main(String[] args) {
        GaussJacobiIterative gauss = new GaussJacobiIterative();
        double[][] matrix = { { -2, 6, 6, -2, 5 }, { 3, -3, -8, -1, -8 }, { 6, -8, -8, 8, 2 }, { 4, -4, 6, 5, -1 },
                { -6, -7, 8, -1, 9 } };
        double[] result = { -48, 15, 36, 73, 37 };
        gauss.setMatrix(matrix);
        gauss.setResult(result);
        System.out.println(gauss);
    }
}
