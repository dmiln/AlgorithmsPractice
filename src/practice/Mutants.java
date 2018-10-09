package practice;

import java.util.*;
import java.io.*;

public class Mutants {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }


        for (int i = 0; i < m; i++) {
            int key = b[i];
            int left = binarySearchLeft(key, a);
            int right = binarySearchRight(key, a);

            if (left == right) {
                if (left == -1) {
                    out.println(0);
                } else {
                    out.println(1);
                }
            }else {
                int sum = right - left + 1;
                out.println(sum);
            }
        }

    }

    private int binarySearchLeft(int key, int[] array) {
        int left = -1;
        int right = array.length;
        while (left < right - 1) {
            int mid = (right + left) / 2;
            if (array[mid] < key) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private int binarySearchRight(int key, int[] array) {
        int left = -1;
        int right = array.length;
        while (left < right - 1) {
            int mid = (right + left) / 2;
            if (array[mid] <= key) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }


    public void run() {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] arg) {
        new Mutants().run();
    }
}
