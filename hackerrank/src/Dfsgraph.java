import java.io.File;
import java.util.*;

public class Dfsgraph {

    static int V, s;
    static LinkedList[] adj;

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
                if (visited[n] != null && !visited[n]) {
                    visited[n] = true;
                    outQueue.add(n);
                }
            }
        }
    }

    static LinkedList[] createGraph() {
        try {
            Scanner scanner = new Scanner(new File("inputData.txt"));
            V = scanner.nextInt();
            adj = new LinkedList[V];
            for(int i=0; i<V; i++)
                adj[i] = new LinkedList<Integer>();
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String lineIn = scanner.nextLine();
                System.out.println(lineIn);
                adj[Integer.parseInt(lineIn.substring(3, 4))].add(Integer.parseInt(lineIn.substring(1, 2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
