import java.io.*;
import java.util.*;

public class P2_sleepy {

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new
        // OutputStreamWriter(System.out)));

        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(br.readLine()); // read a line from the input file
        int N = Integer.parseInt(st.nextToken()); // N points

        int[] line = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }
        int k = 0;
        for (k = N - 2; k >= 0; k--) {
            if (line[k] > line[k + 1]) {
                break;
            }
        }
        out.println(k + 1);

        out.close(); // close the output file
    }

}