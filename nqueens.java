import java.util.*;

public class nqueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        List<List<String>> res = new ArrayList<>();
        System.out.println(queen(board,0 ,res));
        System.out.println(res);
    }

    static int queen(boolean[][] board, int row ,List<List<String>> res) {
        if (row == board.length ) {
            List<String> combination = new ArrayList<>();
            combination = display(board);
            res.add(combination);
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board , row, col)) {
                board[row][col] = true;
                count += queen(board , row + 1 , res);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static List<String> display(boolean[][] grid) {
        List<String> res = new ArrayList();

        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }

        return res;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        int minl = Math.min(row, col);
        for (int i = 1; i <= minl; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        int minr = Math.min(row, board.length - 1 - col);
        for (int i = 1; i <= minr; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }
}