package Gauss;

import javax.lang.model.element.VariableElement;

public class GaussJacobiIterative {
    private int converge;
    private double[] result;
    private double[][] matrix;
    private double[] variables;

    private boolean isSolution(double[] result, double[] solution) {
        boolean equal = false;
        double[] vector = multiplication(solution);
        for (int i = 0; i < solution.length; i++) {
            double absolute = Math.abs((result[i] - vector[i]));
            if (absolute <= 0.1) {
                continue;
            }
            return equal;
        }
        return !equal;
    }

    private boolean converge(double[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            double value = 0.;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i][i])
                    value += matrix[i][j];
                if (value > matrix[i][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private double[] multiplication(double[] result) {
        double[] multiplication = new double[result.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                multiplication[i] += matrix[i][j] * result[j];
            }
        }
        return multiplication;

    }

    public void setResult(double[] result) {
        this.result = result;
            findSolution(result);
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    private void findSolution(double[] result) {
        double[] variables = new double[result.length];

        for (int j = 0; !isSolution(result, variables); j++) {
            int currentPos = j % variables.length;
            converge = j;
            switch (currentPos) {
                case 0 ->
                    variables[currentPos] = (-variables[1] * matrix[0][1] - variables[2] * matrix[0][2]
                            - variables[3] * matrix[0][3] + result[0])
                            / matrix[0][0];
                case 1 ->
                    variables[currentPos] = (-variables[0] * matrix[1][0] - variables[2] * matrix[1][2]
                            - variables[3] * matrix[1][3] + result[1])
                            / matrix[1][1];
                case 2 ->
                    variables[currentPos] = (-variables[0] * matrix[2][0] - variables[1] * matrix[2][1]
                            - variables[3] * matrix[2][3] + result[2])
                            / matrix[2][2];
                case 3 ->
                    variables[currentPos] = (-variables[0] * matrix[3][0] - variables[1] * matrix[3][1]
                            - variables[2] * matrix[3][2] + result[3]) / matrix[3][3];
                default -> variables = null;
            }
        }
        this.variables = variables;
    }

    private String variables(double[] variables) {
        String tripleVar = "";
        if (variables != null) {
            tripleVar += "(";
            for (int i = 0; i < variables.length; i++) {
                if (i == variables.length - 1)
                    tripleVar += variables[i] + ")";
                else
                    tripleVar += variables[i] + ", ";
            }
        }
        return tripleVar;
    }

    private String matrixToString(double[][] table) {
        String system = "";
        if (table != null) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[0].length; j++) {
                    system += (!(j == table[0].length - 1) ? table[i][j] + "  " : table[i][j] + "\n");
                }
            }
        }
        return system;
    }

    public String toString() {
        return "Matrix: \n" + matrixToString(matrix) + "\nSystem result: \n" + variables(result) + "\nSolution: \n"
                + variables(variables) + "\nThe result converged at " + converge + " iteration.";
    }

}
