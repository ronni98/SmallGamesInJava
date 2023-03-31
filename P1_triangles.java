import java.io.*;
import java.util.*;

public class P1_triangles {

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("triangles.in"));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new
        // OutputStreamWriter(System.out)));

        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(br.readLine()); // read a line from the input file
        int N = Integer.parseInt(st.nextToken()); // N points

        int[] x = new int[N];
        int[] y = new int[N];
        for (int k = 0; k < N; k++) {
            st = new StringTokenizer(br.readLine());
            x[k] = Integer.parseInt(st.nextToken());
            y[k] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (y[i] == y[j]) { // ij is horizontal
                    for (int k = 0; k < N; k++) {
                        if (i == k || j == k) {
                            continue;
                        }
                        if (x[i] == x[k]) { // ik is vertical
                            int length_h = Math.abs(x[i] - x[j]);
                            int length_v = Math.abs(y[i] - y[k]);
                            int area = length_v * length_h;
                            max = Math.max(area, max);
                        }
                    }
                }
            }
        }
        out.println(max);

        out.close(); // close the output file
    }

}