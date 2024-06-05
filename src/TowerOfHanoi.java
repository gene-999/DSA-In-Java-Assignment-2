import java.util.Scanner;
public class TowerOfHanoi {
    public static void main(String[] args) {
        System.out.println("Enter a number(greater than 0): ");
        int n = getDisks();
        towerOfHanoi(n, 'A', 'C', 'B');
    }

    public static void towerOfHanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from + " to rod " + to);
            return;
        }
        towerOfHanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
        towerOfHanoi(n - 1, aux, to, from);
    }

    public static int getDisks(){
        int input = 0;
        Scanner in = new Scanner(System.in);
        try{
            input = in.nextInt();
            while(input < 1) {
                System.out.println("Enter a number greater than 0: ");
                input = getDisks();
            }
            return input;
            }
        catch (Exception e){
            System.out.println("Enter a valid number ");
            input = getDisks();
        }
        return input;
    }
}
