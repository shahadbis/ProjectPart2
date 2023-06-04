package AirFeightApp;

import GraphFramework.DBAllSourcesSPAlg;
import GraphFramework.Graph;
import java.io.FileNotFoundException;
import java.util.Scanner;

//------------------------------ Main Class -------------------------------
public class AlgorithmProjectP1 {

    public static void main(String[] args) throws FileNotFoundException {

        // Scanner to read from user
        Scanner sc = new Scanner(System.in);

        // Voiw mune to the user to choise one of the requirements
        int userChoise = mune(sc);

        // Declearing data
        boolean isInvalid = false;
        int[] nValues = {2000, 3000, 4000, 5000, 6000};
        int[] mValues = {10000, 15000, 20000, 25000, 30000};

        // Create graph object
        Graph graph = new Graph();

        // Starting do-while loop to check the user's choise 
        do {
            //----------------------------------------------
            // First requirement reading data from file and calculate the shortest path
            if (userChoise == 1) {

                // Use readGraphFromFile method from Graph class
                graph.readGraphFromFile("inputFile.txt");

                // Create DBAllSourcesSPAlg object
                DBAllSourcesSPAlg dbAllSourcesSPAlg = new DBAllSourcesSPAlg(graph.getVertices());
                dbAllSourcesSPAlg.computeDijkstraBasedSPAlg(userChoise);

            }//----------------------------------------------
            // Second requirement generating random data and calculate the time that algoriths take
            else if (userChoise == 2) {
                for (int i = 0; i < nValues.length; i++) {

                    // n = No.vertices, m = No.edges
                    int n = nValues[i];
                    int m = mValues[i];

                    System.out.println("Generating graph with NO.vertices = " + n + " and NO.edges = " + m);

                    // Use makeGraph method from Graph class
                    graph.makeGraph(n, m);

                    // Create DBAllSourcesSPAlg object
                    DBAllSourcesSPAlg dbAllSourcesSPAlg = new DBAllSourcesSPAlg(graph.getVertices());

                    // calculating the time
                    long startTime = System.nanoTime();
                    dbAllSourcesSPAlg.computeDijkstraBasedSPAlg(userChoise);
                    long pathComputationTime = System.nanoTime() - startTime;

                    System.out.println("Time taken by Dijkstra's Algorithm: " + pathComputationTime + " ns");
                    System.out.println("\n-------------------------------------------------\n");
                }
            } //----------------------------------------------
            // Invalid input user should choose another choise 
            else {
                System.out.println("\n!!! Invalid input, choose again !!!\n");
                userChoise = mune(sc);
                isInvalid = true;
            }
        } while (isInvalid);

    }

    //---------------------------- mune Method to display mune to the user -------------------------
    public static int mune(Scanner sc) {

        System.out.println("-------------------------------------------------");
        System.out.println("\tWelcome in Phone Lines System!");
        System.out.println("-------------------------------------------------");
        System.out.println("Choose wich Requirement want to display:");
        System.out.println("1. Compute the shortest path using Dijkstra algorithm (data are taken from a file)");
        System.out.println("2. Compute the shortest path using Dijkstra algorithm (random data)");
        System.out.println("\nYour choise:");

        return sc.nextInt();
    }
}
