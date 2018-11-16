import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfsgraph extends Graph {

    public static void main(String[] args) {
        Bfsgraph myApp = new Bfsgraph();
        LinkedList[] G = myApp.createGraph();
        myApp.bfs(adj, V, 3);
    }

    static void bfs(LinkedList[] adj, int V, int s) {
        Boolean[] visited = new Boolean[V];
        Queue<Integer> outQueue = new LinkedList<>();

        visited[s] = true;
        outQueue.add(s);

        Iterator<Integer> adjI = adj[s].iterator();
        while (outQueue.size() != 0) {
            s = findNext(adjI, visited, outQueue);
            adjI = adj[s].iterator();
            System.out.print(outQueue.poll() + ", ");
        }
    }

    static int findNext(Iterator<Integer> adjI, Boolean[] visited, Queue<Integer> outQueue ) {
        int n = adjI.next();
        if ((visited[n] == null || !visited[n]) && !adjI.hasNext()) {
            visited[n] = true;
            outQueue.add(n);
        } else {
            findNext(adjI, visited, outQueue);
        }
        return n;
    }
}
