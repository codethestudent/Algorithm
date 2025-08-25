import java.io.*;

public class Main {
    private static char[][] arr;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(br.readLine());
            int w = 2 * n - 1;
            arr = new char[n][w];

            // 1) 공백으로 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < w; j++) arr[i][j] = ' ';
            }

            // 2) 꼭짓점 (0, n-1)에서 시작
            draw(n, 0, n - 1);

            // 3) 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append('\n');
            }
            bw.write(sb.toString());
        }
    }

    // n 높이의 삼각형을 꼭짓점 (r, c)에 그림
    private static void draw(int n, int r, int c) {
        if (n == 3) {
            base3(r, c);
            return;
        }
        int h = n / 2;
        // 위
        draw(h, r, c);
        // 왼아래
        draw(h, r + h, c - h);
        // 오른아래
        draw(h, r + h, c + h);
    }

    // 높이 3 삼각형
    private static void base3(int r, int c) {
        arr[r][c] = '*';
        arr[r + 1][c - 1] = '*';
        arr[r + 1][c + 1] = '*';
        for (int d = -2; d <= 2; d++) {
            arr[r + 2][c + d] = '*';
        }
    }
}
