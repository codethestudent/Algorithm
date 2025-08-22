import java.io.*;
import java.util.*;

public class Main {
    private static int[][] paper;
    // cnt[0] = -1 개수, cnt[1] = 0 개수, cnt[2] = 1 개수
    private static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine().trim());
            paper = new int[N][N];

            for (int i = 0; i < N; i++) {
                // 입력이 공백 구분이므로 split(" ")로 충분
                int[] arr = Arrays.stream(br.readLine().trim().split(" "))
                                  .mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < N; j++) {
                    paper[i][j] = arr[j];
                }
            }

            solve(0, 0, N);

            // 순서: -1, 0, 1
            bw.write(String.valueOf(cnt[0])); bw.newLine();
            bw.write(String.valueOf(cnt[1])); bw.newLine();
            bw.write(String.valueOf(cnt[2])); bw.newLine();
        }
    }

    private static void solve(int r, int c, int len) {
        if (isUniform(r, c, len)) {
            // 값(-1,0,1)을 인덱스(0,1,2)로 매핑: value + 1
            cnt[paper[r][c] + 1]++;
            return;
        }

        int m = len / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solve(r + i * m, c + j * m, m); // 오프셋 반드시 포함
            }
        }
    }

    private static boolean isUniform(int r, int c, int len) {
        int first = paper[r][c];
        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                if (paper[i][j] != first) return false;
            }
        }
        return true;
    }
}
