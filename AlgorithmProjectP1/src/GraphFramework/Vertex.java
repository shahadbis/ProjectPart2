/*
Student Name: Shahad Abdulaziz
Student ID: 2105902
Section: B0B
*/
package GraphFramework;

import java.util.LinkedList;
import java.util.List;

//------------------------------ Vertex Class -------------------------------
public class Vertex implements Comparable<Vertex>{
    
    //-------------- Attribute ---------------
    private String label;
    private List<Edge> adjList;
    private int distance = 0;
    private Vertex previousVertex;

    //-------------- Constructer ---------------
    public Vertex(String label) {
        this.label = label;
        adjList = new LinkedList<>();
        distance = Integer.MAX_VALUE;
        previousVertex = null;
    }

    //-------------- Methods ---------------
    public void addAdjacency(Edge edge) {
        adjList.add(edge);
    }
    
    @Override
    public int compareTo(Vertex other) {
        return Integer.compare(distance, other.distance);
    }
    
    //-------------- Setters & Getters ---------------
    public String getLabel() {
        return label;
    }

    public boolean isVisited(String label) {
        return this.label.equals(label);
    }

    public List<Edge> getAdjList() {
        return adjList;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    
}
