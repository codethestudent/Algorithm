import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            int nodes = sc.nextInt();
            int connections = sc.nextInt();
            int startingNode = sc.nextInt();

            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 1; i <= nodes; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int i = 0; i < connections; i++) {
                int node1 = sc.nextInt();
                int node2 = sc.nextInt();
                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
                Collections.sort(graph.get(node1));
                Collections.sort(graph.get(node2));
            }

            boolean[] visited = new boolean[nodes];
            dfs(graph, visited, startingNode);
            visited = new boolean[nodes];
            System.out.println();
            bfs(graph, visited, startingNode);
        }
    }

    public static void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int startingNode) {
        while (!visited[startingNode - 1]) {
            System.out.print(startingNode + " ");
            visited[startingNode - 1] = true;

            for (int i = 0; i < graph.get(startingNode).size(); i++) {
                dfs(graph, visited, graph.get(startingNode).get(i));
            }
        }
    }

    public static void bfs(Map<Integer, List<Integer>> graph, boolean[] visited, int startingNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node - 1] = true;
            System.out.print(node + " ");
            for (int i = 0; i < graph.get(node).size(); i++) {
                if (!visited[graph.get(node).get(i) - 1]) {
                    visited[graph.get(node).get(i) - 1] = true;
                    queue.add(graph.get(node).get(i));
                }
            }
        }
    }
}