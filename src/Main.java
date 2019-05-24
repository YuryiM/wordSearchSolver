import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of rows :: ");
        int R = keyboard.nextInt();
        System.out.print("Enter the number of columns :: ");
        int C = keyboard.nextInt();
        char[][] board1 =  new char[R][C];
        System.out.println("===============================\nEnter the letters with spaces between\nPress 'Enter' when ready to go to next row\n===============================\n");
        for(int i = 0; i < R; i++){
            System.out.print("Row " + i + " :: ");
            char[] test1 = keyboard.nextLine().toLowerCase().replaceAll(" ", "").toCharArray();
            board1[i] = test1;
        }
        System.out.println("===============================\nEnter the words separated by commas, no spaces\n===============================\n");
        String[] words = keyboard.next().toLowerCase().split(",");
        Board testBoard1 = new Board(words, board1);
        System.out.print(testBoard1);

    }
}
