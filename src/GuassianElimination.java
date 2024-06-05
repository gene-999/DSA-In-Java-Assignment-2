import java.util.Scanner;
public class GuassianElimination {
    public static void main(String[] args) {
        runGuassianElimination();
    }

    public static void runGuassianElimination() {
        try {
            double[][] a = getMatrix();
            double[] b = getCoefficients();
            double[] x = guassianElimination(a, b);
            System.out.println("The solution is: ");
            for (double v : x) {
                System.out.println(v);
            }
        } catch (Exception e) {
            System.out.println("The number of rows of the matrix must be equal to the number of coefficients!");
            runGuassianElimination();

        }
    }
    public static double[] guassianElimination(double[][] a, double[] b) {
        double[] x = new double[b.length];
        int n = b.length;
        for (int i = 0; i < n; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(a[j][i]) > Math.abs(a[max][i])) {
                    max = j;
                }
            }
            double[] temp = a[i];
            a[i] = a[max];
            a[max] = temp;
            double t = b[i];
            b[i] = b[max];
            b[max] = t;
            for (int j = i + 1; j < n; j++) {
                double alpha = a[j][i] / a[i][i];
                b[j] -= alpha * b[i];
                for (int k = i; k < n; k++) {
                    a[j][k] -= alpha * a[i][k];
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += a[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / a[i][i];
        }
        return x;
    }

    public static double[][] getMatrix() {
        Scanner scanner = new Scanner(System.in);
        int m = getSize("Enter the number of rows: ");
        int n = getSize("Enter the number of columns: ");
        if(m != n){
            System.out.println("The number of rows must be equal to the number of columns!");
            getMatrix();
        }
        double[][] matrix = new double[m][n];
        try {
            System.out.println("Enter the elements of the matrix: ");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print("Element " + (i + 1) + ", " + (j + 1) + ": ");
                    matrix[i][j] = scanner.nextDouble();
                }
            }

            return matrix;
        } catch (Exception e) {
            System.out.println("Please enter a valid number!");
            getMatrix();
        }
        return matrix;
    }

    public static double[] getCoefficients() {
        Scanner scanner = new Scanner(System.in);
        int n = getSize("Enter the number of coefficients: ");
        double[] coefficients = new double[n];
        try {
            System.out.println("Enter the coefficients: ");
            for (int i = 0; i < n; i++) {
                System.out.print("Coefficient " + (i + 1) + ": ");
                coefficients[i] = scanner.nextDouble();
            }
            return coefficients;
        } catch (Exception e) {
            System.out.println("Please enter a valid number!");
            getCoefficients();
        }
        return coefficients;
    }

    public static int getSize(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int n = 0;
        try {
            n = scanner.nextInt();
            if (n < 1) {
                System.out.println("Please enter a number greater than 0!");
                n = getSize(message);
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number!");
            n = getSize(message);
        }
        return n;
    }
}
