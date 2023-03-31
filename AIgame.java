import java.io.*;
import java.util.*;

class Node {
    int d;
    String s;
    Node left;
    Node right;

    public Node(int d_, String s_) {
        d = d_;
        s = s_;
        left = null;
        right = null;
    }
}

public class AIgame {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("game1.txt"));

        String title = scan.nextLine();
        System.out.println("title: " + title);

        String help_info = scan.nextLine();
        System.out.println("help_info: " + help_info);

        Node[] node = new Node[31];
        for (int k = 0; k < 31; k++) {
            String line = scan.nextLine();

            int d = Integer.parseInt(line.substring(0, 3));
            String s = line.substring(5);
            node[k] = new Node(d, s);
        }
        scan.close();

        // build the tree
        Node root = node[0];
        for (int k = 1; k < 31; k++) {
            add(root, node[k]);
        }

        // to verify BST by DFS
        // DFS: traverse left substree, current node, traverse right subtree
        dfs(root);
        System.out.println();

        // to interact with the player
        Scanner scan2 = new Scanner(System.in);
        String op = "init"; // P,p: play the game  L,l: load a different game  D,d: dfs  H,h: help  E,e: exit
        while(!op.equals("e")) {
            if (op.equals("p")) {
                play_game(root, scan2);
            } else if (op.equals("l")) {

                System.out.println("Please enter another game file: ");
                String fn = scan2.nextLine();
                Scanner scan3 = new Scanner(new FileReader(fn));
                title = scan3.nextLine();
                help_info = scan3.nextLine();
                for (int k = 0; k < 31; k++) {
                    String line = scan3.nextLine();
                    int d = Integer.parseInt(line.substring(0, 3));
                    String s = line.substring(5);
                    node[k] = new Node(d, s);
                }
                scan3.close();
                root = node[0];
                for (int k = 1; k < 31; k++) {
                    Node y = node[k];
                    add(root, y);
                }


            } else if (op.equals("d")) {
                dfs(root);
            } else if (op.equals("h")) {
                System.out.println(help_info);
            }

            System.out.println("\n" + title);
            op = get_input_op(scan2, true);
        }

    }

    // to play the game
    static void play_game(Node c, Scanner scan2) {
        while (c.left != null || c.right != null) {
            // to do Q&A with the user
            System.out.println(c.s);
            String ans = get_input_op(scan2, false); // to get a user's answer
            ans = ans.toLowerCase();
            if (ans.equals("y")) {
                c = c.left;
            } else {
                c = c.right;
            }
        }
        // now c is a leaf
        System.out.println(c.s);
    }


    // c: current node in the tree
    // y: a new node to add to the tree
    static void add(Node c, Node y) {
        if (y.d < c.d) { // y to go to the left subtree of c
            if (c.left == null) {
                c.left = y;
            } else {
                add(c.left, y);
            }
        } else { // y to go to the right subtree of c
            if (c.right == null) {
                c.right = y;
            } else {
                add(c.right, y);
            }
        }
    }

    // to traverse the tree by inorder: L C R
    static void dfs(Node c) { // Depth-first search
        if (c == null) return;

        // to traverse the left subtree of c
        dfs(c.left);

        // current node
        System.out.print(c.d + " ");

        // to traverse the right subtree of c
        dfs(c.right);
    }

    static String get_input_op(Scanner scan_user, boolean main_menu) {
        if (main_menu) {
            System.out.println("\nP,p  Play the game\nL,l  Load another game file\nD,d  Display the binary tree");
            System.out.print("H,h  Help information\nE,e  Exit the program\n... your choice: ");
        }

        String op = new String(scan_user.nextLine());

        return op.toLowerCase();
    }
}