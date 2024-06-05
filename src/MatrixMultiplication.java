import java.util.Arrays;
import java.util.Scanner;
public class MatrixMultiplication {
    public static void main(String[] args) {
        try{
            runMultiplication();
        }
        catch (Exception e){
            System.out.println("The number of columns of the first matrix must be equal to the number of rows of the second matrix!");
            runMultiplication();
        }
            }

    public static void runMultiplication(){
        int[][] a = getMatrix();
        int[][] b = getMatrix();
        if(a[0].length == b.length){
        int[][] c = multiply(a, b);
        System.out.println("The product of the two matrices is: ");
            for (int[] ints : c) {
                System.out.println(Arrays.toString(ints));
            }
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    public static int[][] multiply(int[][] a, int[][] b) {
        int m = a.length;
        int n = a[0].length;
        int p = b[0].length;
        int[][] c = new int[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
    public static int[][] getMatrix() {
        Scanner scanner = new Scanner(System.in);
        int m = getSize("Enter the number of rows: ");
        int n = getSize("Enter the number of columns: ");
        int[][] matrix = new int[m][n];
        try {
            System.out.println("Enter the elements of the matrix: ");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print("Element " + (i + 1) + ", " + (j + 1) + ": ");
                    matrix[i][j] = scanner.nextInt();
                }
            }

            return matrix;
        } catch (Exception e) {
            System.out.println("Please enter a valid number!");
            getMatrix();
        }
        return matrix;
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