/*
Student Name: Shahad Abdulaziz
Student ID: 2105902
Section: B0B
 */
package GraphFramework;

import java.util.PriorityQueue;

//------------------------------ SingleSourceSPAlg Class -------------------------------
public class SingleSourceSPAlg extends shortestPathAlgorithm {

    //-------------- Attribute ---------------
    private Vertex sourceVertex;

    //-------------- Constructer ---------------
    public SingleSourceSPAlg(Vertex sourceVertex) {
        this.sourceVertex = sourceVertex;
    }

    //-------------- Methods ---------------
    @Override
    public void computeDijkstraAlg() {
        // Create a priority queue to store vertices in the order of their distances
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();

        // Set the distance of the source vertex to 0 and add it to the priority queue
        sourceVertex.setDistance(0);
        priorityQueue.add(sourceVertex);

        // Perform Dijkstra's algorithm until the priority queue is empty
        while (!priorityQueue.isEmpty()) {
            // Get the vertex with the smallest distance from the priority queue
            Vertex currentVertex = priorityQueue.poll();

            // Iterate over the adjacent edges of the current vertex
            for (Edge edge : currentVertex.getAdjList()) {
                // Get the target vertex and the weight of the edge
                Vertex targetVertex = edge.getTargetVertex();
                int weight = edge.getWeight();

                // Calculate the distance from the source vertex to the target vertex through the current vertex
                int distance = currentVertex.getDistance() + weight;

                // If the newly calculated distance is smaller than the current distance of the target vertex,
                // update the distance, previous vertex, and add the target vertex to the priority queue
                if (distance < targetVertex.getDistance()) {
                    priorityQueue.remove(targetVertex);
                    targetVertex.setDistance(distance);
                    targetVertex.setPreviousVertex(currentVertex);
                    edge.setParent(currentVertex); // Set the parent for the edge
                    priorityQueue.add(targetVertex);
                }
            }
        }
    }

}
