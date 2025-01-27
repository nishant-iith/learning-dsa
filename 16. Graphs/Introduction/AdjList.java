import java.util.Scanner;
import java.util.ArrayList;

public class AdjList {
    

    public static void main(String[] args) {
        // taking inputs
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // nodes or vertices
        int m = sc.nextInt();

        // adjacency list for undirected graphs
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        // Initialize the adjacency list
        for(int i=0 ; i<=n ; i++){
            adj.add(new ArrayList<Integer>());
        }

        // add the edges to the list
        for(int i=0 ; i< m ; i++){
            // Take the inputs
            int x = sc.nextInt();
            int y = sc.nextInt();

            // add the edges for undirected graph
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        // print the adjacency list
        System.out.println("The Adjacency List is :");
        for(int i = 1; i<=n; i++){
            System.out.print(i + " -> ");
            for(int j = 0; j<adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
