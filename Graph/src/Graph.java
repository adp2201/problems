import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    int n;
    LinkedList<Integer> adjList[];

    public Graph(int n) {
        this.n = n;
        adjList = new LinkedList[n];
        for(int i=0; i<n; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int start, int end) {
        adjList[start].add(end);
        adjList[end].add(start);
    }

    public void print() {
        for(int i=0; i<n; i++) {
            System.out.print(i);
            for(Integer a : adjList[i]) {
                System.out.print(" -> " + a);
            }
            System.out.println();
        }
    }

    public void bfs(int i) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            System.out.print(num);
            for(int adj : adjList[num]) {
                if(!visited[adj]) {
                    queue.add(adj);
                    visited[adj] = true;
                }
            }
        }
    }

    public void dfs(int i) {
        boolean[] visited = new boolean[n];
        dfs(i, visited);
    }

    public void dfs(int i, boolean[] v) {
        if(!v[i]) {
            System.out.print(i);
            v[i]=true;
            for (int num : adjList[i]) {
                dfs(num, v);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.print();
        graph.dfs(2);
        System.out.println();
        graph.bfs(2);
    }
}
