import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static int[][] map;
    private static int[][] owner;
    private static int[] dr = { -1, 1, 0, 0 };
    private static int[] dc = { 0, 0, -1, 1 };
    private static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            owner = new int[N][N];

            for (int i = 0; i < N; i++) {
                int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

                for (int j = 0; j < arr.length; j++) {
                    map[i][j] = arr[j];
                }
            }

            int team = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && owner[i][j] == 0) {
                        bfs(i, j, team++);
                    }
                }
            }

            bw.write(String.valueOf(team - 1));
            bw.write("\n");
            Collections.sort(list);
            list.stream().forEach(i -> {
                try {
                    bw.write(String.valueOf(i));
                    bw.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.flush();
        }
    }

    private static void bfs(int startRow, int startCol, int team) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startRow, startCol });
        owner[startRow][startCol] = team;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int r = cur[0] + dr[i];
                int c = cur[1] + dc[i];
                if (r < 0 || r >= map.length || c < 0 || c >= map.length)
                    continue;
                if (map[r][c] == 1 && owner[r][c] == 0) {
                    count++;
                    owner[r][c] = team;
                    queue.offer(new int[] { r, c });
                }
            }
        }
        list.add(count);
    }

}
