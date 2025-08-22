import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                for (int j = 0; j < arr.length; j++) {
                    map[i][j] = arr[j];
                }
            }

            divideConquer(0, 0, map.length);
            bw.write(String.valueOf(count[0]));
            bw.newLine();
            bw.write(String.valueOf(count[1]));
            bw.newLine();
            bw.write(String.valueOf(count[2]));
            bw.newLine();
        }
    }

    private static void divideConquer(int row, int col, int length) {
        if (isUniform(row, col, length)) {
            count[map[row][col] + 1]++;
            return;
        }
        int dividedLength = length / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divideConquer(row + i * dividedLength, col + j * dividedLength, dividedLength);
            }
        }

    }

    private static boolean isUniform(int row, int col, int length) {
        int first = map[row][col];

        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if (map[i][j] != first)
                    return false;
            }
        }
        return true;
    }
}
