import java.util.*;

public class ConnectFour {
    public static String whoIsWinner(List<String> piecesPositionList) {
        // retrun "Red" or "Yellow" or "Draw"

        return "Draw";
    }

    private static int[] getCol (String string) {
        char col = string.charAt(0);
        char player = string.charAt(2);
        int[] result = new int[2];
        result[1] = (player == 'R') ? 1 : -1;

        switch (col) {
            case 'A' -> result[0] = 0;
            case 'B' -> result[0] = 1;
            case 'C' -> result[0] = 2;
            case 'D' -> result[0] = 3;
            case 'E' -> result[0] = 4;
            case 'F' -> result[0] = 5;
            case 'G' -> result[0] = 6;
        }

        return result;
    }
}