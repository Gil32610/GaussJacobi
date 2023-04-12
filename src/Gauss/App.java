package Gauss;

public class App {
        public static void main(String[] args) {
                // Questão de exemplo apresentada em sala:
                // Utilizando 5 variáveis e 5 equações para a função f(x) = e^x
                // Obter o polinômio do 4 grau a partir da interpolação.

                // VALORES DE X
                double[][] matrix = { { 1, 0, 0, 0, 0 },
                                { 1, 0.5, Math.pow(0.5, 2), Math.pow(0.5, 3), Math.pow(0.5, 4) },
                                { 1, 1, 1, 1, 1 },
                                { 1, 1.5, Math.pow(1.5, 2), Math.pow(1.5, 3), Math.pow(1.5, 4) },
                                { 1, 2, 4, 8, 16 } };

                // VALORES DE F(X)
                double[] result = { 1, Math.sqrt(Math.E), Math.E, Math.sqrt(Math.pow(Math.E, 3)), Math.pow(Math.E, 2) };
                GaussJacobiIterative gauss = new GaussJacobiIterative(result, matrix);
                System.out.println(gauss);
                System.out.println("\n".repeat(2));
                System.out.println(gauss.equation());
                System.out.println("\n".repeat(2));
                gauss.printEquation();
                System.out.println("\n".repeat(2));
        }
}
