import java.io.File;
import java.util.*;

public class Dfsgraph extends Graph {

    public static void main(String[] args) {
        Dfsgraph myApp = new Dfsgraph();
        LinkedList[] G = myApp.createGraph();
        myApp.dfs(adj, V, 3);
    }

    static void dfs(LinkedList[] adj, int V, int s) {
        Boolean[] visited = new Boolean[V];
        Queue<Integer> outQueue = new LinkedList<>();

        visited[s] = true;
        outQueue.add(s);

        while (outQueue.size() != 0) {
            s = outQueue.remove();
            System.out.print(s + ", ");

            Iterator<Integer> adjI = adj[s].iterator();
            while (adjI.hasNext()) {
                int n = adjI.next();
                if (visited[n] == null || !visited[n]) {
                    visited[n] = true;
                    outQueue.add(n);
                }
            }
        }
    }

}
