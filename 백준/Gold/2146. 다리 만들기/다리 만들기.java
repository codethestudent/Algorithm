import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int[][] idMap;
    private static int[][] owner;
    private static int[][] distance;
    private static int[] dr = { -1, 1, 0, 0 };
    private static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Integer N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                for (int j = 0; j < arr.length; j++) {
                    map[i][j] = arr[j];
                }
            }

            idMap = new int[N][N];
            int id = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && idMap[i][j] == 0) {
                        id++;
                        labelMap(i, j, id);
                    }
                }
            }

            owner = new int[N][N];
            distance = new int[N][N];
            Deque<int[]> queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (idMap[i][j] > 0) {
                        owner[i][j] = idMap[i][j];
                        queue.offer(new int[] { i, j });
                    }
                }
            }

            // System.out.println("Hello! owner map showing!");

            // for (int[] arr : owner) {
            //     Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
            //     System.out.println();
            // }
            int answer = Integer.MAX_VALUE;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];

                for (int i = 0; i < 4; i++) {
                    int sr = r + dr[i];
                    int sc = c + dc[i];

                    if (sr < 0 || sr >= N || sc < 0 || sc >= N)
                        continue;

                    if (owner[sr][sc] == 0 && owner[r][c] != 0) {
                        owner[sr][sc] = owner[r][c];
                        distance[sr][sc] = distance[r][c] + 1;
                        queue.offer(new int[] { sr, sc });

                    } else if (owner[sr][sc] != owner[r][c]) {
                        int dist = distance[sr][sc] + distance[r][c];
                        answer = dist < answer ? dist : answer;
                    }
                }
            }
            // System.out.println("Hello! owner map showing!");

            // for (int[] arr : owner) {
            //     Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
            //     System.out.println();
            // }
            // System.out.println("Hello! dist map showing!");
            // for (int[] arr : distance) {
            //     Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
            //     System.out.println();
            // }

            System.out.println(answer);
        }

    }

    private static void labelMap(int sr, int sc, int id) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { sr, sc });
        idMap[sr][sc] = id;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int r = arr[0] + dr[i];
                int c = arr[1] + dc[i];

                if (r < 0 || r >= map.length || c < 0 || c >= map.length)
                    continue;
                if (map[r][c] == 1 && idMap[r][c] == 0) {
                    idMap[r][c] = id;
                    queue.offer(new int[] { r, c });
                }
            }
        }
    }

}
