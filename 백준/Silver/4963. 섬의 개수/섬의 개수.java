import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static int[][] map;
    private static int[][] owner;
    private static int[] dr = { -1, -1, -1, 1, 1, 1, 0, 0 };
    private static int[] dc = { -1, 0, 1, -1, 0, 1, -1, 1 };
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String line = null;
            while (!"0 0".equals(line = br.readLine())) {
                int[] size = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

                int col = size[0];
                int row = size[1];

                map = new int[row][col];
                owner = new int[row][col];

                for (int i = 0; i < row; i++) {
                    int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                    for (int j = 0; j < col; j++) {
                        map[i][j] = inputs[j];
                    }
                }

                int team = 0;
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (map[i][j] == 1 && owner[i][j] == 0) {
                            bfs(i, j, ++team);
                        }
                    }
                }

                list.add(team);
            }

            list.forEach(System.out::println);

        }

    }

    private static void bfs(int row, int col, int team) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { row, col });

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int r = cur[0] + dr[i];
                int c = cur[1] + dc[i];

                if (r < 0 || r >= map.length || c < 0 || c >= map[0].length)
                    continue;
                if (map[r][c] == 1 && owner[r][c] == 0) {
                    queue.offer(new int[] { r, c });
                    owner[r][c] = team;
                }
            }
        }
    }

}
