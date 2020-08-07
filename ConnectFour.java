import java.util.*;

public class ConnectFour {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>(Arrays.asList(
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "G_Red",
                "B_Yellow"
        ));

        System.out.println(whoIsWinner(myList));
    }
    public static String whoIsWinner(List<String> piecesPositionList) {
        int[][] board = new int[9][8];

        for (String s : piecesPositionList) {
            int[] move = getMove(s);
            int row = getRow(move[0], board);
            board[move[0]][row] = move[1];

            printBoard(board);
            System.out.println();

            if (!winner(board, move[0], row).equals("No"))
                return winner(board, move[0], row);

        }

        return "Draw";
    }

    private static void printBoard (int[][] board) {
        for (int[] i : board) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static int[] getMove (String string) {
        char col = string.charAt(0);
        char player = string.charAt(2);
        int[] result = new int[2];
        result[1] = (player == 'R') ? 1 : -1;

        switch (col) {
            case 'A': result[0] = 1; break;
            case 'B': result[0] = 2; break;
            case 'C': result[0] = 3; break;
            case 'D': result[0] = 4; break;
            case 'E': result[0] = 5; break;
            case 'F': result[0] = 6; break;
            case 'G': result[0] = 7; break;
        }

        return result;
    }

    private static int getRow (int col, int[][] moves) {
        for (int i = 1; i < 7; i++) {
            if (moves[col][i] == 0)
                return i;
        }
        return -1;
    }

    private static String winner (int[][] board, int col, int row) {
        if (checkVertical(board, col, row) || checkHorizontal(board, col, row) ||
                checkDiagLeft(board, col, row) || checkDiagRight(board, col, row)) {
            if (board[col][row] == 1) { return "Red"; }
            return "Yellow";
        }
        return "No";
    }

    private static boolean checkVertical (int[][] board, int col, int row) {
        int initial = board[col][row];
        int count = 1;
        int i = 1;

        while (board[col][row + i] == initial) {
            count++; i++;
        }
        i = 1;
        while (board[col][row - i] == initial) {
            count++; i++;
        }

        return (count >= 4);
    }

    private static boolean checkHorizontal (int[][] board, int col, int row) {
        int initial = board[col][row];
        int count = 1;
        int i = 1;

        while (board[col + i][row] == initial) {
            count++; i++;
        }
        i = 1;
        while (board[col - i][row] == initial) {
            count++; i++;
        }

        return (count >= 4);
    }

    private static boolean checkDiagRight (int[][] board, int col, int row) {
        int initial = board[col][row];
        int count = 1;
        int i = 1;

        while (board[col + i][row + i] == initial) {
            count++; i++;
        }
        i = 1;
        while (board[col - i][row - i] == initial) {
            count++; i++;
        }

        return (count >= 4);
    }

    private static boolean checkDiagLeft (int[][] board, int col, int row) {
        int initial = board[col][row];
        int count = 1;
        int i = 1;

        while (board[col - i][row + i] == initial) {
            count++; i++;
        }
        i = 1;
        while (board[col + i][row - i] == initial) {
            count++; i++;
        }

        return (count >= 4);
    }
}