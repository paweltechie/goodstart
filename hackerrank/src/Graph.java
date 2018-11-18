import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

abstract class Graph {
    static int V, s;
    static LinkedList[] adj;

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
//                adj[Integer.parseInt(lineIn.substring(1, 2))].add(Integer.parseInt(lineIn.substring(3, 4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}