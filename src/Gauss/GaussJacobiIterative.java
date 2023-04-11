package Gauss;

import javax.lang.model.element.VariableElement;

public class GaussJacobiIterative {
    private int converge;
    private double[] result;
    private double[][] matrix;
    private double[] variables;

    public GaussJacobiIterative(double[] result, double[][] matrix) {
        this.result = result;
        this.matrix = matrix;
        this.variables = new double[result.length];
        findSolution(result);
    }

    private boolean isSolution(double[] vector, double[] variables) {
        double[] diff = new double[variables.length];
        double[] absMax = new double[variables.length];
        for (int i = 0; i < variables.length; i++) {
            diff[i] = Math.abs(variables[i] - vector[i]);
        }
        for (int j = 0; j < vector.length; j++) {
            absMax[j] = Math.abs(variables[j]);
        }
        double rule = max(diff) / max(absMax);
        return (rule <= 0.001);
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

    private void findSolution(double[] result) {
        double[] vector = new double[variables.length];
        for (int j = 0; converge < 1000; j++) {
            int currentPos = j % variables.length;
            converge = j;
            double operation = .0;
            double coeficient = .0;
            for (int i = 0; i < variables.length; i++) {
                if (i != currentPos) {
                    operation += (-variables[i] * matrix[currentPos][i]) / matrix[currentPos][currentPos];
                }
                if (i == variables.length - 1) {
                    coeficient += result[currentPos] / matrix[currentPos][currentPos];
                    variables[currentPos] = operation + coeficient;
                }
            }

            if (isSolution(vector, variables)) {
                break;
            }
            copyVariables(vector);
        }

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
        return "Matrix: \n" + matrixToString(matrix) + "\nSystem result: \n" + variables(result)
                + "\nApproximate Solution: \n"
                + variables(variables) + (converge < 100 ? ("\nThe result converged at " + converge + " iteration.")
                        : ("\nThe system was not converging at " + converge + "th iteration."));
    }

    private double max(double[] vector) {
        if (vector.length == 0)
            return 0;
        double max = Double.MIN_VALUE;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > max)
                max = vector[i];
        }
        return max;
    }

    public void copyVariables(double[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = variables[i];
        }
    }

    public String equation() {
        String equation = "";
        for (int i = 0; i < variables.length; i++) {
            if (i == 0) {
                equation += variables[i] + " + ";
            } else if (i == variables.length - 1) {
                equation += variables[i] + "X^" + i;
            } else {
                equation += variables[i] + "X^" + i + " + ";
            }

        }
        return equation;
    }

}
