import java.util.*;

class Student {
    String name;
    int absent_days;
    public Student(String name_, int absent_days_) {
        name = name_;
        absent_days = absent_days_;
    }
    public String toString() {
        String s = name + " " + absent_days + " ";
        if (s.length() < 16) {
            for (int i = 0; i < 16 - s.length(); i++) {
                s = " " + s;
            }
        }
        return s;
    }
}

class Chart {
    Student[][] mat;
    // m: # of row
    // n: # of col
    public Chart(int m, int n) {
        // to create (m x n) 2D matrix
        mat = new Student[m][n];
    }
    public void remove_absent_students(int allowed_absences) {
        for (int i = 0; i < mat.length; i++) { //i : row
            for (int j = 0; j < mat[0].length; j++) {
                Student y = mat[i][j];
                if (y != null && y.absent_days > allowed_absences) {
                    mat[i][j] = null;
                }
            }
        }
    }
}

public class Seating {
    public static void main (String [] args) {        
        // student names
        String[] names = {"Karen","Leslie","Danny","Jack","Molly",
          "Larry","Peter","Emily","Alice","Gary","Ashley","Bill",
          "Helen","Andrew"};
        int n_st = names.length;
        Student[] p = new Student[n_st];
        int k;
        for (k = 0; k < n_st; k++) {
            p[k] = new Student(names[k], (int)(Math.random()*10.0));
        }
        /*
        for (k = 0; k < n_st; k++) {
            System.out.print(p[k]);
            if (k % 5 == 4) {
                System.out.println();        
            }
        }
        System.out.println();
        */
        
        int m = 3; // # of row
        int n = 5; // # of col
        Chart chart = new Chart(m, n);
        k = 0;
        for (int i = 0; i < m && k < n_st; i++) {     // i: row
            for (int j = 0; j < n && k < n_st; j++) { // j: col
                chart.mat[i][j] = p[k];
                k++;
            }
        }

        for (int i = 0; i < m; i++) {     // i: row
            for (int j = 0; j < n; j++) { // j: col
                Student y = chart.mat[i][j];
                if (y == null) {
                    System.out.print("--------------");
                } else {
                    System.out.print(y);
                }
            }
            System.out.println();
        }
        System.out.println();
        chart.remove_absent_students(7);
        for (int i = 0; i < m; i++) {     // i: row
            for (int j = 0; j < n; j++) { // j: col
                Student y = chart.mat[i][j];
                if (y == null) {
                    System.out.print("--------------");
                } else {
                    System.out.print(y);
                }
            }
            System.out.println();
        }
    }

}
