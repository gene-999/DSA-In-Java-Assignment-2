import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    runChoice(getChoice());

    }

    public static int getChoice(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("Choose an algorithm to run: ");
        System.out.println("1. Tower of Hanoi");
        System.out.println("2. Counting Binary");
        System.out.println("3. Factorial");
        System.out.println("4. Fibonacci");
        System.out.println("5. Maximum element in an array");
        System.out.println("6. Matrix Multiplication");
        System.out.println("7. Guassian Elimination");
        System.out.println("8. Element Uniqueness");
        System.out.println("9. Exit");
        System.out.println("Enter a number: ");
        try{
            choice = scanner.nextInt();
            if(choice < 1 || choice > 9){
                System.out.println("Please enter a number between 1 and 9!");
                choice = getChoice();
            }
        }
        catch (Exception e){
            System.out.println("Please enter a valid number!");
            choice = getChoice();
        }
        return choice;
    }

    public static void runChoice(int choice){
        switch (choice) {
            case 1:
                TowerOfHanoi.main(null);
                runChoice(getChoice());
                break;
            case 2:
                CountingBinary.main(null);
                runChoice(getChoice());
                break;
            case 3:
                Factorial.main(null);
                runChoice(getChoice());
                break;
            case 4:
                Fibonacci.main(null);
                runChoice(getChoice());
                break;
            case 5:
                MaxElement.main(null);
                runChoice(getChoice());
                break;
            case 6:
                MatrixMultiplication.main(null);
                runChoice(getChoice());
                break;
            case 7:
                GuassianElimination.main(null);
                runChoice(getChoice());
                break;
            case 8:
                ElementUniqueness.main(null);
                runChoice(getChoice());
                break;
            case 9:
                System.exit(0);
                break;

        }
    }
}