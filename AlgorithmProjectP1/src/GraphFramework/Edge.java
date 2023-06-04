/*
Student Name: Shahad Abdulaziz
Student ID: 2105902
Section: B0B
*/
package GraphFramework;

//------------------------------ Edge Class -------------------------------
public class Edge {
    
    //-------------- Attribute ---------------
    private Vertex sourceVertex;
    private Vertex targetVertex;
    private int weight;
    private Vertex parent;

    //-------------- Constructer ---------------
    public Edge(Vertex sourceVertex, Vertex targetVertex, int weight) {
        this.sourceVertex = sourceVertex;
        this.targetVertex = targetVertex;
        this.weight = weight;
    }

    //-------------- Setters & Getters ---------------
    public Vertex getSourceVertex() {
        return sourceVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }
}
