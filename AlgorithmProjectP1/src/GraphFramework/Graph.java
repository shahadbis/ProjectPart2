/*
Student Name: Shahad Abdulaziz
Student ID: 2105902
Section: B0B
*/
package GraphFramework;

import java.io.*;
import java.util.*;

//------------------------------ Graph Class -------------------------------
public class Graph {
    
    //-------------- Attribute ---------------
    private List<Vertex> vertices;
    private List<Edge> edges;

    //-------------- Constructer ---------------
    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    //-------------- Methods ---------------
    //-------------- readGraphFromFile Method ---------------
    public void readGraphFromFile(String filePath) throws FileNotFoundException {

        // read data from file
        File inputFile = new File(filePath);
        Scanner sc = new Scanner(inputFile);

        while (sc.hasNextLine()) {
            
            String line = sc.nextLine(); // take the entire line to sprate it 
            String[] parts = line.split(" ");

            if (parts.length == 3) {
                String sourceLabel = parts[0]; // sourse vertex
                String targetLabel = parts[1]; // target vertex
                int weight = Integer.parseInt(parts[2]); // weight 

                // check if the source vertex is exist
                Vertex sourceVertex = searchVertex(sourceLabel, vertices);
                if (sourceVertex == null) {
                    sourceVertex = createVertex(sourceLabel);
                }

                // check if the target vertex is exist
                Vertex targetVertex = searchVertex(targetLabel, vertices);
                if (targetVertex == null) {
                    targetVertex = createVertex(targetLabel);
                }

                // create edge 
                createEdge(sourceVertex, targetVertex, weight);
            }
            
        }
        // close scanner
        sc.close();
    }
    
    //-------------- makeGraph Method ---------------
    public void makeGraph(int n, int m) {
        
        // Generate n vertices
        for (int i = 0; i < n; i++) {
            createVertex("V" + i);
        }

        List<Vertex> vertices = getVertices();

        // check that the number of edges less than vertices
        if (m > (n * (n - 1)) / 2) {
            System.out.println("Invalid number of edges for the given number of vertices.");
            return;
        }
        
        // Generate m edges
        Random random = new Random();
        int count = 0;
        while (count < m) {
            Vertex source = vertices.get(random.nextInt(n));
            Vertex target = vertices.get(random.nextInt(n));

            // check the graph is connected 
            if (source != target && !isConnected(source, target)) {
                int weight = random.nextInt(100) + 1; // Generate random weight between 1 and 100
                createEdge(source, target, weight);
                count++;
            }
        }
        
    }
    
    //-------------- addEdge Method ---------------
    public void addEdge(Vertex source, Vertex target, int weight) {
        Edge edge = new Edge(source, target, weight);
        edges.add(edge);
        source.addAdjacency(edge);
    }

    //-------------- searchVertex Method ---------------
    public Vertex searchVertex(String label, List<Vertex> vertices) {
        for (Vertex vertex : vertices) {
            if (vertex.getLabel().equals(label)) {
                return vertex;
            }
        }
        return null;
    }
    
    //-------------- createVertex Method ---------------
    public Vertex createVertex(String label) {
        Vertex vertex = new Vertex(label);
        vertices.add(vertex);
        return vertex;
    }

    //-------------- createEdge Method ---------------
    public void createEdge(Vertex source, Vertex target, int weight) {
        Edge edge = new Edge(source, target, weight);
        edges.add(edge);
        source.addAdjacency(edge);
    }
    
    //-------------- isConnected Method ---------------
    public boolean isConnected(Vertex source, Vertex target) {
        for (Edge edge : edges) {
            if (edge.getSourceVertex() == source && edge.getTargetVertex() == target) {
                return true;
            }
        }
        return false;
    }

    //-------------- Setters & Getters ---------------
    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
