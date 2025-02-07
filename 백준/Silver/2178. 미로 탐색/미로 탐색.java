import java.io.*;
import java.util.*;

class Main {
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[] size = new int[2];

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = br.readLine().split(" ");

            size[0] = Integer.parseInt(firstLine[0]);
            size[1] = Integer.parseInt(firstLine[1]);

            map = new int[size[0]][size[1]];
            visited = new boolean[size[0]][size[1]];

            for (int i = 0; i < size[0]; i++) {
                String line = br.readLine();
                for (int j = 0; j < size[1]; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }
            visited[0][0] = true;
            bfs(0, 0);
            System.out.println(map[size[0]-1][size[1]-1]);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= size[0] || nextY >= size[1]) {
                    continue;
                }
                if (visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }
                queue.add(new int[] { nextX, nextY });
                map[nextX][nextY] = map[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }

}