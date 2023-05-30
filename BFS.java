import java.util.*;

public class BFS {
    public static void bfs(ArrayList<ArrayList<Integer>> adjacencyList, int startVertex) {
        int numVertices = adjacencyList.size();
        int[] visited = new int[numVertices];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = 1;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for (int w : adjacencyList.get(v)) {
                if (visited[w] == 0) {
                    visited[w] = 1;
                    queue.add(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        System.out.println("Enter the edges in the format (u v):");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        System.out.print("Enter the starting vertex: ");
        int startVertex = scanner.nextInt();

        System.out.print("BFS traversal starting from vertex " + startVertex + ": ");
        bfs(adjacencyList, startVertex);

        scanner.close();
    }
}
