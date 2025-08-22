import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static List<String> answerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < arr.length; j++) {
                    map[i][j] = arr[j];
                }
            }

            divideConquer(0, 0, map.length);
            answerList.forEach(i -> {
                try {
                    bw.write(i);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.flush();

        }
    }

    private static void divideConquer(int row, int col, int length) {

        if (isUniform(row, col, length)) {
            return;
        }

        answerList.add("(");
        int len = length / 2;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                divideConquer(row + i * len, col + j * len, len);
            }
        }
        answerList.add(")");
    }

    private static boolean isUniform(int row, int col, int length) {
        int first = map[row][col];

        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if (first != map[i][j]) {
                    return false;
                }
            }
        }
        answerList.add(String.valueOf(first));
        return true;
    }
}
