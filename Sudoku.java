import java.io.*;
import java.util.*;

public class Sudoku {
    int[][] puzzle;

    boolean[][] row; // initialize
    boolean[][] col;
    boolean[][][] block;

    int[] rnd_digits;

    public boolean create(int r, int c) {
        for (int d = 1; d <= 9; d++) {
            int d2 = d - 1; //index for digit d
            if (check_av(r, c, d2)) { //true : digit d can is availible for current cell [r][c]
                puzzle[r][c] = d;

                // base case
                if (r == 8 && c == 8) {
                    return true; //success
                }

                assign_used(r, c, d2);
                int k = r; // row k
                int j = c + 1; // col j
                if (j >= 9) {
                    k++;
                    j = 0;
                }

                // [k][j] : next cell to explore
                boolean flag = create(k, j);
                if (flag) {
                    return true;
                } else {
                    // restore to previous state
                    clear(r, c, d2);
                    puzzle[r][c] = 0;
                }
            }
        }

        return false;
    }

    // to assign used 2D arrays
    public void assign_used(int r, int c, int d) { // d=0, 1, 2, ..., 8
        row[r][d] = true;
        col[c][d] = true;
        block[r / 3][c / 3][d] = true;
    }

    // to release digit d from cell (r, c)
    public void clear(int r, int c, int d) { // backtrack to original state; initialization
        row[r][d] = false;
        col[c][d] = false;
        block[r / 3][c / 3][d] = false;
    }

    // to check whether digit d is available for cell [r][c]
    public boolean check_av(int r, int c, int d) {
        if (row[r][d]) return false;
        if (col[c][d]) return false;
        if (block[r / 3][c / 3][d]) return false;

        return true;
    }

    public Sudoku() {
        row = new boolean[9][9]; // used; [row][digit - 1] for index
        col = new boolean[9][9];
        block = new boolean[3][3][9]; // [0][0] which block, 3rd means digit - 1
        puzzle = new int[9][9];

        rnd_digits = new int[9];

    }

    public void display() {
        for (int k = 0; k < 9; k++) {
            if (k % 3 == 0) {
                System.out.println(" +-----------+-----------+-----------+");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0)
                    System.out.print(" | ");
                System.out.print(" " + puzzle[k][j] + " ");
            }
            System.out.println(" | ");
        }
        System.out.println(" +-----------+-----------+-----------+");
    }

    public static void main(String[] args) throws IOException {
        Sudoku sudoku = new Sudoku();
        sudoku.create(0, 0); // recursive call
        sudoku.display();
    }
}