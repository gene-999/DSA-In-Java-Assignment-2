import java.util.Arrays;
import java.util.Scanner;

public class ElementUniqueness {
    public static void main(String[] args) {
        int[] arr = getArray();
        if (isUnique(arr)) {
            System.out.println("The elements of the array are unique.");
        } else {
            System.out.println("The elements of the array are not unique.");
        }
    }

    public static int[] getArray() {
        Scanner scanner = new Scanner(System.in);
        int n = getSize();
        int[] arr = new int[n];
        try
        {
            System.out.println("Enter the elements of the array: ");
            for (int i = 0; i < n; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                arr[i] = scanner.nextInt();
            }
            System.out.println("The array is: " + Arrays.toString(arr));
            return arr;
        }
        catch (Exception e){
            System.out.println("Please enter a valid number!");
            getArray();
        }
        System.out.println("The array is: " + Arrays.toString(arr));
        return arr;
    }

    public static  int getSize(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = 0;
        try{
            n = scanner.nextInt();
            if(n < 1){
                System.out.println("Please enter a number greater than 0!");
                n = getSize();
            }}
        catch (Exception e){
            System.out.println("Please enter a valid number!");
            n = getSize();
        }
        return n;

    }
    public static boolean isUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
