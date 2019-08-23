package Assignments.Part2_3;

import java.util.*;

public class Graph {

    public static class GraphNode {
        public int data;

        GraphNode(int data) {
            this.data = data;
        }
    }

    static class GraphWithAdjacencyList {
        private Map<GraphNode, List<GraphNode>> adjNodes = new HashMap<>();
        private Map<GraphNode, List<GraphNode>> copyAdjNodes;
        private ArrayList<Integer> visitedNodesDFS = new ArrayList<>();
        private ArrayList<Integer> visitedNodesBFS = new ArrayList<>();

        private Queue<Integer> graphNodeQueue = new LinkedList<>();

        private void addNode(int key) {
            List<GraphNode> adjNodesList = new ArrayList<>();
            adjNodes.put(new GraphNode(key), adjNodesList);
        }

        private void removeNode(int key) {
            adjNodes.remove(find(key));
        }

        private void addEdge(int node1, int node2) {
            getAdjNodes(node1).add(find(node2));
            getAdjNodes(node2).add(find(node1));
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
            getAdjNodes(node1).remove(find(node2));
            getAdjNodes(node2).remove(find(node1));
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
            List<GraphNode> currentList = getAdjNodes(key);
            if (!visitedNodesDFS.contains(key)) {
                System.out.print(key + " ");
                visitedNodesDFS.add(key);
                for (GraphNode node : currentList) {
                    DFS(node.data);
                }
            }
        }

        private void BFS(int key) {
            graphNodeQueue.add(key);

            if (!visitedNodesBFS.contains(key)) {
                visitedNodesBFS.add(key);
            }

            System.out.print(key + " ");

            while (graphNodeQueue.size() > 0) {
                for (GraphNode node : getAdjNodes(graphNodeQueue.poll())) {
                    if (!visitedNodesBFS.contains(node.data)) {
                        visitedNodesBFS.add(node.data);
                        System.out.print(node.data + " ");
                        graphNodeQueue.add(node.data);
                    }
                }
            }
        }

        private int minNumberOfEdges(int node1, int node2) {
            //TODO have to fix function so that it chooses the shortest path
            ArrayList<Integer> visitedNodes = new ArrayList<>();
            Queue<Integer> nodesToVisit = new LinkedList<>();
            return minNumberOfEdges(node1,node2,visitedNodes,nodesToVisit);
        }

        private int minNumberOfEdges(int node1, int node2, ArrayList<Integer> visitedNodes, Queue<Integer> nodesToVisit) {
            List<GraphNode> currentList = getAdjNodes(node2);
            GraphNode findNode = find(node1);
            visitedNodes.add(node2);

            if (currentList.contains(findNode)) {
                return visitedNodes.size();
            } else {
                for (GraphNode node : currentList) {
                    if (!nodesToVisit.contains(node.data)) {
                        nodesToVisit.add(node.data);
                    }
                }

                int nextNode = nodesToVisit.poll();

                if (!visitedNodes.contains(nextNode)) {
                    minNumberOfEdges(node1, nextNode, visitedNodes, nodesToVisit);
                } else {
                    return -1;
                }
            }
            return visitedNodes.size();
        }

        // work backwards
        // BFS to see if target is in neighbor list
        // if not DFS and repeat the BFS step on the next level

        //We are given an undirected graph. We need to find the minimum number of edges between a given pair
        // of nodes (u, v). For example, consider the undirected graph given below.
        //Write a method minNumberOfEdges(int node1, int node2) that returns the minimum number of edges
        //between two nodes. For example:
        //minNumberOfEdges(1, 5) = 2
        //minNumberOfEdges(6, 1) = 3
    }

    public static void main(String[] args) {
        GraphWithAdjacencyList adjacencyList = new GraphWithAdjacencyList();
        adjacencyList.addNode(3);
        adjacencyList.addNode(2);
        adjacencyList.addNode(1);
        adjacencyList.addNode(5);
        adjacencyList.addNode(4);
        adjacencyList.addNode(0);

        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(1, 3);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(1, 5);
        adjacencyList.addEdge(4, 5);
        adjacencyList.addEdge(3, 2);

        adjacencyList.DFS(1);
        System.out.println();
        adjacencyList.BFS(1);
        // 1 3 4 5 2 0
        System.out.println();

        GraphWithAdjacencyList list2 = new GraphWithAdjacencyList();
        list2.addNode(2);
        list2.addNode(0);
        list2.addNode(1);
        list2.addNode(3);

        list2.addEdge(0, 2);
        list2.addEdge(2, 3);
        list2.addEdge(1, 2);
        list2.addEdge(0, 1);

        list2.DFS(2);
        System.out.println();
        list2.BFS(2);

        GraphWithAdjacencyList list3 = new GraphWithAdjacencyList();
        list3.addNode(0);
        list3.addNode(1);
        list3.addNode(2);
        list3.addNode(3);
        list3.addNode(4);
        list3.addNode(5);
        list3.addNode(6);

        list3.addEdge(0, 1);
        list3.addEdge(0, 2);
        list3.addEdge(0, 4);
        list3.addEdge(1, 2);
        list3.addEdge(2, 5);
        list3.addEdge(3, 4);
        list3.addEdge(4, 5);
        list3.addEdge(4, 6);

        System.out.println();
        System.out.println(list3.minNumberOfEdges(1, 5));
        System.out.println(list3.minNumberOfEdges(6, 1));
    }

}

/**
 * Implement the following methods for the GraphWithAdjacencyList class:
 * void addNode(int key) : Adds a new node to the graph.
 * void removeNode(int key): Removes the node from the graph.
 * void addEdge(int node1, int node2): Adds an edge between node1 and node2
 * void removeEdge(int node1, int node2): Removes an edge between node1 and node2.
 * List<GraphNode> getAdjNodes(int key): Get nodes that are connected to the node represented by ‘key’.
 * <p>
 * You can assume this is an undirected graph.
 * <p>
 * Depth-First Traversal: A depth-first traversal starts at an arbitrary root node and explores nodes as deeper
 * as possible along each branch before exploring nodes at the same level. For example, DFS starting from
 * node 2 would print:
 * 2  0	 1	3
 * <p>
 * Write a method to perform DFS(int key) traverses DFS  starting from key printing each node along the way.
 * <p>
 * Breadth-First Traversal: Comparatively, a breadth-first traversal starts at an arbitrary root node and explores
 * all neighboring nodes at the same level before going deeper in the graph.  For example, BFS starting from
 * node 2 would print:
 * 2	0	3	1
 * <p>
 * Write a method to perform BFS(int key) traverses BFS  starting from key printing each node along the way.
 * <p>
 * Depth-First Traversal: A depth-first traversal starts at an arbitrary root node and explores nodes as deeper
 * as possible along each branch before exploring nodes at the same level. For example, DFS starting from
 * node 2 would print:
 * 2  0	 1	3
 * <p>
 * Write a method to perform DFS(int key) traverses DFS  starting from key printing each node along the way.
 * <p>
 * Breadth-First Traversal: Comparatively, a breadth-first traversal starts at an arbitrary root node and explores
 * all neighboring nodes at the same level before going deeper in the graph.  For example, BFS starting from
 * node 2 would print:
 * 2	0	3	1
 * <p>
 * Write a method to perform BFS(int key) traverses BFS  starting from key printing each node along the way.
 * <p>
 * Depth-First Traversal: A depth-first traversal starts at an arbitrary root node and explores nodes as deeper
 * as possible along each branch before exploring nodes at the same level. For example, DFS starting from
 * node 2 would print:
 * 2  0	 1	3
 * <p>
 * Write a method to perform DFS(int key) traverses DFS  starting from key printing each node along the way.
 * <p>
 * Breadth-First Traversal: Comparatively, a breadth-first traversal starts at an arbitrary root node and explores
 * all neighboring nodes at the same level before going deeper in the graph.  For example, BFS starting from
 * node 2 would print:
 * 2	0	3	1
 * <p>
 * Write a method to perform BFS(int key) traverses BFS  starting from key printing each node along the way.
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

