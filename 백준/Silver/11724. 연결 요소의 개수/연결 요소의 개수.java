import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = inputs[0];
            int M = inputs[1];
            visited = new boolean[N + 1];
            nodes = new ArrayList[N + 1];
            for (int i = 1; i < N + 1; i++) {
                nodes[i] = new ArrayList<>();
            }
            int[] connection;
            for (int i = 0; i < M; i++) {
                connection = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                nodes[connection[0]].add(connection[1]);
                nodes[connection[1]].add(connection[0]);
            }

            int answer = 0;
            for (int i = 1; i < visited.length; i++) {
                if (!visited[i]) {
                    answer++;
                    dfs(i);
                }
            }
            System.out.println(answer);
        }
    }

    private static void dfs(int start) {
        if (!visited[start]) {
            visited[start] = true;
            for (int node : nodes[start]) {
                dfs(node);
            }
        } else {
            return;
        }
    }
}
