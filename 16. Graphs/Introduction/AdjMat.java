import java.util.Scanner;

public class AdjMat {
	public static void main(String[] args){
        // taking inputs
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // nodes or vertices
        int m = sc.nextInt();

        // adjacency matrix for undirected graphs
        int[][] adj = new int[n+1][n+1]; // the default value is 0

        // Add the edges
        for(int i=0 ; i< m ; i++){
            // Take the inputs
            int x = sc.nextInt();
            int y = sc.nextInt();

            // undirected graphs
            // x->y and y->x
            adj[x][y] = 1;
            adj[y][x] = 1;

        }

        System.out.println("The Adjacency Matrix is :");
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
	}
}
