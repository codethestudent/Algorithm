import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int N = input[0];
            int M = input[1];
            int V = input[2];

            visited = new boolean[N + 1];
            graph = new ArrayList[N + 1];
            for (int i = 1; i < N + 1; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                int[] connection = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                graph[connection[0]].add(connection[1]);
                graph[connection[1]].add(connection[0]);
            }

            for (int i = 1; i < N + 1; i++) {
                Collections.sort(graph[i]);
            }

            dfs(V);
            System.out.println();
            Arrays.fill(visited, false);
            bfs(V);

        }

    }

    private static void dfs(int start) {
        if (visited[start]) {
            return;
        } else {
            System.out.print(start + " ");
            int i = 0;
            visited[start] = true;
            while (i < graph[start].size()) {
                dfs(graph[start].get(i++));
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (!visited[current]) {
                System.out.print(current + " ");
                visited[current] = true;
            }
            for (int i = 0; i < graph[current].size(); i++) {
                if(!visited[graph[current].get(i)]){
                    queue.add(graph[current].get(i));
                }
            }
        }
    }

}
