import java.io.*;
import java.util.*;

public class Knight {
    static int[][] board; // 8x8 chess board

    public static void main(String[] args) {
        board = new int[8][8];

        // start position (k, j) of the knight in chess
        // int k = ((int) (Math.random() * 8)); // row k = 0, 1, 2, ..., 7 (equal
        // chance)
        // int j = ((int) (Math.random() * 8)); // col j = 0, 1, 2, ..., 7 (equal
        // chance)
        int k = 0;
        int j = 1;

        
    }

    static boolean move(int k, int j, int step) { // row k, col j
        // System.out.println("enter move(): k=" + k + " j=" + j + " step=" + step);
    return false;
    }

    static void display(int[][] A) {
        for (int k = 0; k < A.length; k++) { // row k
            for (int j = 0; j < A[0].length; j++) { // col j
                System.out.printf("%5d", A[k][j]); // %3d : field of width 3 for int
            }
            System.out.println();
        }
    }
}
