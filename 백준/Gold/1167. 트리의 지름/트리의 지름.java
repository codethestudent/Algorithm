import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Edge>[] tree;
    static boolean[] visited;
    static int farthestNode;
    static int maxDistance;

    // DFS to find the farthest node and its distance from the start
    static void dfs(int u, int dist) {
        visited[u] = true;
        if (dist > maxDistance) {
            maxDistance = dist;
            farthestNode = u;
        }
        for (Edge e : tree[u]) {
            if (!visited[e.to]) {
                dfs(e.to, dist + e.weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        // Read the tree
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;
                int w = Integer.parseInt(st.nextToken());
                tree[u].add(new Edge(v, w));
            }
        }

        // 1) From node 1, find the farthest node A
        visited = new boolean[V + 1];
        maxDistance = 0;
        dfs(1, 0);

        // 2) From node A, find the farthest node B — that's the diameter
        visited = new boolean[V + 1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }
}
