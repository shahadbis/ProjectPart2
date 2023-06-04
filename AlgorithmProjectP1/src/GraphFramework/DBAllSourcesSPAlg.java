/*
Student Name: Shahad Abdulaziz
Student ID: 2105902
Section: B0B
 */
package GraphFramework;

import java.util.*;

//------------------------------ DBAllSourcesSPAlg Class -------------------------------
public class DBAllSourcesSPAlg extends shortestPathAlgorithm {

    //-------------- Attribute ---------------
    private List<Vertex> vertices;

    //-------------- Constructer ---------------
    public DBAllSourcesSPAlg(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    //-------------- Methods ---------------
    /**
     * This method computes Dijkstra-based shortest path algorithm for each
     * vertex in the graph. It creates an instance of SingleSourceSPAlg for each
     * vertex and calls its computeDijkstraAlg() method. If the choice is 1, it
     * also prints the shortest paths from the source vertex to all other
     * vertices.
     *
     * @param choice The choice to print the shortest paths or not.
     */
    public void computeDijkstraBasedSPAlg(int choice) {
        for (Vertex vertex : vertices) {
            SingleSourceSPAlg singleSourceSPAlg = new SingleSourceSPAlg(vertex);
            singleSourceSPAlg.computeDijkstraAlg();

            if (choice == 1) {
                printShortestPaths(vertex);
            }
        }
    }

    /**
     * This method prints the shortest paths from a given source vertex to all
     * other vertices in the graph.
     *
     * @param sourceVertex The source vertex from which the shortest paths are
     * calculated.
     */
    private void printShortestPaths(Vertex sourceVertex) {
        System.out.println("The starting point location is " + sourceVertex.getLabel());
        System.out.println("The routes from location " + sourceVertex.getLabel() + " to the rest of the locations are:");

        for (Vertex vertex : vertices) {
            if (vertex != sourceVertex) {
                System.out.print("From " + sourceVertex.getLabel() + " to " + vertex.getLabel() + " path: ");
                printPath(vertex);
                System.out.println(" Route length: " + vertex.getDistance());
            }
        }

        System.out.println();
    }

    /**
     * This method prints the path from the target vertex to the source vertex.
     *
     * @param targetVertex The target vertex for which the path is printed.
     */
    private void printPath(Vertex targetVertex) {
        List<String> path = new ArrayList<>();
        Vertex currentVertex = targetVertex;

        while (currentVertex != null) {
            path.add(currentVertex.getLabel());
            currentVertex = currentVertex.getPreviousVertex();
        }

        Collections.reverse(path);

        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
    }

    @Override
    void computeDijkstraAlg() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }

}
