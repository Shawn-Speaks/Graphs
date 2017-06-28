package nyc.c4q.shawn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by shawnspeaks on 6/28/17.
 */
public class FirstGraph {
    private HashMap<Integer, Node> nodeDictionary = new HashMap<>();

    public static class Node {
        int id;
        Object data;
        ArrayList<Node> connectedNodes = new ArrayList<>();

        public Node(int id, Object data) {
            this.id = id;
            this.data = data;
        }
    }

    private Node getNode(int id){
        return nodeDictionary.get(id);
    }

    private void addNode(int startId, Node nodeToAdd){
        Node start = getNode(startId);
        nodeDictionary.put(nodeToAdd.id, nodeToAdd);
        start.connectedNodes.add(nodeToAdd);


    }

    private boolean depthFirstSearch(Node root, Node destination){
        HashSet<Integer> visited = new HashSet<>();
        return existInGraph(root, destination, visited);
    }

    private boolean existInGraph(Node root, Node destination, HashSet<Integer> visited) {
        if(visited.contains(root.id)){
            return false;
        }
        visited.add(root.id);
        if(root == destination){
            return true;
        }
        for(Node child: root.connectedNodes){
            if(existInGraph(child, destination, visited)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1, "a");
        FirstGraph firstGraph = new FirstGraph();
        firstGraph.nodeDictionary.put(root.id, root);
        Node a2 = new Node(2, "b");
        Node a3 = new Node(3, "s");
        Node a4 = new Node(4, "c");
        Node a5 = new Node(5, "d");
        Node a6 = new Node(6, "e");
        Node a7 = new Node(7, "f");
        Node a8 = new Node(8, "x");
        Node a9 = new Node(9, "g");

        Node notInGraph = new Node(100, "PLACEHOLDER STRING");


        firstGraph.addNode(root.id, a2);
        firstGraph.addNode(root.id, a3);
        firstGraph.addNode(a2.id, a4);
        firstGraph.addNode(a2.id, a5);
        firstGraph.addNode(a2.id, a6);
        firstGraph.addNode(a3.id, a7);
        firstGraph.addNode(a7.id, a8);
        firstGraph.addNode(a8.id, a9);

        System.out.print(firstGraph.depthFirstSearch(root, a8));
    }

}
