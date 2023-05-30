import java.util.Scanner;

public class NQueens {
    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // check if there is a queen in the same row
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        // check if there is a queen in the same column
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        // check if there is a queen on the diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // it's safe to place a queen at (row, col)
        return true;
    }

    public static boolean backtrack(int[][] board, int row, int n) {
        if (row == n) {
            return true;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;
                if (backtrack(board, row + 1, n)) {
                    return true;
                }
                board[row][col] = 0; // backtrack
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the chessboard: ");
        int n = scanner.nextInt();
        scanner.close();

        int[][] board = new int[10][10];
        if (backtrack(board, 0, n)) {
            // print the first solution found
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 0) {
                        System.out.print("_  ");
                    } else {
                        System.out.print("Q  ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution found.");
        }
    }
}
