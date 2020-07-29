package codeWars;

public class ISC {

    public static void main(String[] args) {
        String check = "Romani_ite_domum";
        encode(check);

    }
    public static String encode(String s) {
        int size = findSize(s);
        char[][] matrix = new char[size][size];

        while (s.length() != size*size) {
            s += " ";
        }

        for (int step = 0; step < size; step++) {
            s = fillBound(matrix, step, s);
            if (s.length() <= 0) {
                break;
            }
        }

        printMatrix(matrix);

        return "";
    }


    public static String decode(String s) {
        // Your code here!
        return "";
    }

    private static int findSize(String str) {
        int i = 2;
        while (i*i < str.length()) {
            i++;
        }

        return i;
    }

    private static String fillBound(char[][] matrix, int step, String s) {
        int length = (matrix.length - 1 - step*2);
        System.out.println(length);

        for (int i = 0; i < length; i++) {
            matrix[step][step + i] = s.charAt(4 * i);
            matrix[step + i][length + step] = s.charAt(4*i + 1);
            matrix[length+step][length-i + step] = s.charAt(4*i + 2);
            matrix[length-i + step][step] = s.charAt(4*i + 3);
            printMatrix(matrix);
            System.out.println();
        }

        System.out.println(s.substring(length*4));
        return s.substring(length*4);
    }


    private static void printMatrix(char[][] matrix) {
        for (char[] i : matrix) {
            for (char j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    private static void question(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = '?';
            }
        }
    }

}
