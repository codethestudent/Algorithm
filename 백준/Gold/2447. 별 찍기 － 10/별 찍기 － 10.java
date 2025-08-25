import java.util.*;
import java.io.*;

public class Main {
    private static String[][] answer;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            answer = new String[n][n];

            stars(n, 0, 0);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (answer[i][j] == null) {
                        bw.write(" ");
                        continue;
                    }
                    bw.write(answer[i][j]);
                }
                bw.write("\n");
            }
            bw.flush();
        }

    }

    private static void stars(int n, int row, int col) {

        if (n == 1) {
            answer[row][col] = "*";
            return;
        }

        int depth = n / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                stars(depth, row + i * depth, col + j * depth);
            }
        }
    }

}
