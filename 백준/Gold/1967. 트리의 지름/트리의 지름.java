import java.util.*;
import java.io.*;

public class Main {
    private static List<Edge>[] nodes;
    private static boolean[] visited;
    private static int farthestNode;
    private static int maxCost;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            nodes = new ArrayList[n + 1];
            visited = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                nodes[i] = new ArrayList<>();
            }
            for (int i = 1; i < n; i++) {
                int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                nodes[inputs[0]].add(new Edge(inputs[1], inputs[2]));
                nodes[inputs[1]].add(new Edge(inputs[0], inputs[2]));
            }
            
            if(n==1){
                System.out.println(0);
                return;
            }

            dfs(1, 0);
            maxCost = 0;
            Arrays.fill(visited, false);
            dfs(farthestNode, 0);
            System.out.println(maxCost);
        }
    }

    private static void dfs(int start, int cost) {
        visited[start] = true;
        if (maxCost < cost) {
            maxCost = cost;
            farthestNode = start;
        }

        for (Edge e : nodes[start]) {
            if (!visited[e.to]) {
                dfs(e.to, e.cost + cost);
            }
        }
    }

    private static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
