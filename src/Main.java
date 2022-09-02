import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
        System.out.print("Enter number of Queens (N>3): ");
        int size = n.nextInt();
        while (size < 4){
            System.out.print("Can't Solve for N<4: ");
            System.out.print("Enter number of Queens (N>3): ");
            size = n.nextInt();
        }
        n.close();
        Board initialBoard = new Board(size);
        HillClimbing algorithm = new HillClimbing();
        long startTimer = System.currentTimeMillis();
        algorithm.run(initialBoard);
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (double)(end - startTimer) / 1000 + " sec.");
    }
}
