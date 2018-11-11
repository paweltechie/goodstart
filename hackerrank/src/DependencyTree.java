import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DependencyTree {

    public static void main(String args[]) {
        DependencyTree myApp = new DependencyTree();
        myApp
    }

    private void buildTree() {

    }

    class Node {
        private List<Node> nextNode = new LinkedList<>();
        private int value;
        Iterator<Node> getNextNodes() { return nextNode.iterator(); }
        void setNextNode(Node node) { nextNode.add(node); }
    }

    private void readInput(String file) {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {

        }
    }
}
