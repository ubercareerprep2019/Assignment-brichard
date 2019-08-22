package Assignments.Part2_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public static class GraphNode {
    public int data;
    GraphNode(int data) {
        this.data = data;
    }
}

class GraphWithAdjacencyList {
    private Map<GraphNode, List<GraphNode>> adjNodes;
    private ArrayList<Integer> visitedNodesDFS = new ArrayList<>();
    private ArrayList<Integer> visitedNodesBFS = new ArrayList<>();

    private void addNode(int key) {
        List<GraphNode> adjNodesList = new ArrayList<>();
        adjNodes.put(new GraphNode(key), adjNodesList);
    }

    private void removeNode(int key) {
        for (Map.Entry<GraphNode, List<GraphNode>> currentNode : adjNodes.entrySet()) {
            if (currentNode.getKey().data == key) {
                adjNodes.remove(currentNode);
            }
        }
    }

    private void addEdge(int node1, int node2) {
        for (Map.Entry<GraphNode, List<GraphNode>> currentNode : adjNodes.entrySet()) {
            if (currentNode.getKey().data == node1) {
                currentNode.getValue().add(find(node2));
            } else if (currentNode.getKey().data == node2) {
                currentNode.getValue().add(find(node1));
            }
        }
    }

    private GraphNode find(int data) {
        for (Map.Entry<GraphNode, List<GraphNode>> entry : adjNodes.entrySet()) {
            if (entry.getKey().data == data) {
                return entry.getKey();
            }
        }
        return null;
    }

    private void removeEdge(int node1, int node2) {
        for (Map.Entry<GraphNode, List<GraphNode>> currentNode : adjNodes.entrySet()) {
            if (currentNode.getKey().data == node1) {
                currentNode.getValue().remove(find(node2));
            } else if (currentNode.getKey().data == node2) {
                currentNode.getValue().remove(find(node1));
            }
        }
    }

    private List<GraphNode> getAdjNodes(int key) {
        for (Map.Entry<GraphNode, List<GraphNode>> entry : adjNodes.entrySet()) {
            if (entry.getKey().data == key) {
                return entry.getValue();
            }
        }
        return null;
    }

    private void DFS(int key) {
        for (Map.Entry<GraphNode, List<GraphNode>> entry : adjNodes.entrySet()) {
            if (entry.getKey().data == key && !visitedNodesDFS.contains(key)) {
                System.out.println(entry.getKey().data + " ");
                visitedNodesDFS.add(key);
                DFS(entry.getValue().get(0).data);
            }
        }
    }

    private void BFS(int key) {

    }

 }

/**
 * Implement the following methods for the GraphWithAdjacencyList class:
 * void addNode(int key) : Adds a new node to the graph.
 * void removeNode(int key): Removes the node from the graph.
 * void addEdge(int node1, int node2): Adds an edge between node1 and node2
 * void removeEdge(int node1, int node2): Removes an edge between node1 and node2.
 * List<GraphNode> getAdjNodes(int key): Get nodes that are connected to the node represented by ‘key’.
 *
 * You can assume this is an undirected graph.
 */

/**
 * Depth-First Traversal: A depth-first traversal starts at an arbitrary root node and explores nodes as deeper
 * as possible along each branch before exploring nodes at the same level. For example, DFS starting from
 * node 2 would print:
 * 2  0	 1	3
 *
 * Write a method to perform DFS(int key) traverses DFS  starting from key printing each node along the way.
 */

/**
 * Breadth-First Traversal: Comparatively, a breadth-first traversal starts at an arbitrary root node and explores
 * all neighboring nodes at the same level before going deeper in the graph.  For example, BFS starting from
 * node 2 would print:
 * 2	0	3	1
 *
 * Write a method to perform BFS(int key) traverses BFS  starting from key printing each node along the way.
 */

