import java.util.Scanner;
public class CountingBinary {
    public static void main(String[] args) {
        System.out.println(countBinary(getNumber()));
    }

    public static int countBinary(int n) {
        int count = 1;
        while (n > 1) {
            count += 1;
            n /= 2;
        }
        return count;
    }

    public static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        try {
            System.out.println("Enter a number: ");
            n = scanner.nextInt();
            if (n < 0) {
                System.out.println("Please enter a non-negative number!");
                getNumber();
            }
            return n;
        }

        catch (Exception e) {
            System.out.println("Please enter a valid number!");
            getNumber();
        }
        return n;
    }
}
