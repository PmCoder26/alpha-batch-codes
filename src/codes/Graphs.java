package codes;
import java.util.*;


 public class Graphs {
    static class Edge{
        int src;       // source.
        int dest;       // destination.
        int wt;         // weight;

        public Edge(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void create1(ArrayList<Edge>[] graph){
        for(int x=0; x<graph.length; x++){
            graph[x]=new ArrayList<>();
        }
        // for vertex 0.
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        // for vertex 1.
        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 0, 1));
        // for vertex 2.
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        // for vertex 3.
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        // for vertex 4.
        graph[4].add(new Edge(4, 2,1));
        graph[4].add(new Edge(4, 3,1));
        graph[4].add(new Edge(4, 5,1));
        // for vertex 5.
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        // for vertex 6.
        graph[6].add(new Edge(6, 5, 1));
    }
    public static void breadthFirstSearch(ArrayList<Edge>[] graph, boolean[] visited){     // O(V+E)  V-vertex, E-edges.
        if(graph.length==0){
            return;
        }
        else{
            Queue<Integer> q=new LinkedList<>();
            q.add(0);   // source = 0;
            while(!q.isEmpty()){
                int curr=q.remove();
                if(!visited[curr]){
                    System.out.print(curr + " ");
                    visited[curr]=true;
                    for(int x=0; x<graph[curr].size(); x++){
                        Edge e=graph[curr].get(x);
                        q.add(e.dest);      // adding destination to traverse further.
                    }
                }
            }
        }
    }
    public static void depthFirstSearch(ArrayList<Edge>[] graph, int curr , boolean[] visited){
        // visiting the current.
        System.out.print(curr + " ");
        visited[curr] = true;
        for (int x = 0; x < graph[curr].size(); x++) {
            Edge e = graph[curr].get(x);
            if (!visited[e.dest]) {       // checking whether the next element is visited or not.
                depthFirstSearch(graph, e.dest, visited);       // calling dfs for the next vertex.
            }
        }
    }
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        visited[src]=true;
        if(src==dest){
            return true;
        }
        else{
            for(int x=0; x<graph[src].size(); x++){
                Edge e=graph[src].get(x);
                if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)){
                    return true;
                }
            }
            return false;
        }
    }
    public static void create2(ArrayList<Edge>[] graph){
        for(int x=0; x<graph.length; x++){
            graph[x]=new ArrayList<>();
        }
        /*
                0 --- 3
              / |     |
             1  |     4
              \ |
                2
         */
        // vertex - 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));
        // vertex - 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));
        // vertex - 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));
        // vertex - 3
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));
        // vertex - 4
        graph[4].add(new Edge(4, 3, 1));
    }
    public static boolean cycleDetector(ArrayList<Edge>[] graph){
        /*
                0 --- 3
              / |     |
             1  |     4
              \ |
                2
         */
        boolean[] visited=new boolean[graph.length];
        for(int x=0; x<graph.length; x++){
            if(!visited[x]){
                if(detectorUtil1(graph, visited, x, -1)) {   // as for starting node/vertex, there is no parent
                    return true;        // cycle exists in one of the part.
                }
            }
        }
        return false;
    }
    public static boolean detectorUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent){
        visited[curr]=true;
        for(int x=0; x<graph[curr].size(); x++){
            Edge e=graph[curr].get(x);
            // case 3: neighbor is not visited.
            if(!visited[e.dest]){
                if(detectorUtil(graph, visited, e.dest, curr)) {
                    return true;
                }
            }
            // case 1: when the neighbor is visited and current is not parent.
            else if(visited[e.dest] && e.dest!=parent){
                return true;
            }
            // case 2: continue, that is, when neighbor and current is parent.
        }
        return false;
    }
    public static boolean detectorUtil1(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent){
        visited[curr]=true;
        for(int x=0; x<graph[curr].size(); x++){
            Edge e=graph[curr].get(x);
            if(!visited[e.dest]){
                if(detectorUtil1(graph, visited, e.dest, curr)){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(visited[e.dest] && e.dest!=parent){
                return true;
            }
        }
        return false;
    }
    public static void create3(ArrayList<Edge>[] graph){
        if(graph.length==0){
            return;
        }
        else{
            // filling the graph will new arraylists.
            for(int x=0; x<graph.length; x++){
                graph[x]=new ArrayList<>();
            }
            /*
                    0 ------ 2
                   /        /
                  /       /         Ans - False.
                 1       4
                  \     /
                   \  /
                    3
         */
            // vertex - 0.
           graph[0].add(new Edge(0, 1, 1));
           graph[0].add(new Edge(0, 2, 1));
           // vertex - 1.
            graph[1].add(new Edge(1, 0, 1));
            graph[1].add(new Edge(1, 3, 1));
            // vertex - 2.
            graph[2].add(new Edge(2, 0, 1));
            graph[2].add(new Edge(2, 4, 1));
            // vertex - 3.
            graph[3].add(new Edge(3, 1, 1));
            graph[3].add(new Edge(3, 4, 1));
            // vertex - 4.
            graph[4].add(new Edge(4, 2, 1));
            graph[4].add(new Edge(4, 3, 1));
        }
    }
    public static boolean isBipartite(ArrayList<Edge>[] graph){     // O(V+E)
        int[] color=new int[graph.length];
        // Initialising the -1 values that is no color initially assigned to any node.
        for(int x=0; x<color.length; x++){
            color[x]=-1;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int x=0; x<graph.length; x++){
            if(color[x]==-1){       // performing BFS.
                color[x]=0;     // yellow color.
                q.add(0);
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int y=0; y<graph[curr].size(); y++){
                        Edge e=graph[curr].get(y);
                        if(color[e.dest]==-1){      // If no color for the destination of the current.
                            int nextColor=color[curr]==0 ? 1:0;
                            color[e.dest]=nextColor;
                            q.add(e.dest);
                        }
                        else if(color[curr]==color[e.dest]){        // if current and destination have the same color.
                            return false;       // Hence, the graph given is not Bipartite Graph.
                        }
                    }
                }
            }
        }
        return true;      // It means the graph is Bipartite as all the conditions are satisfied from the looping structure.
    }
    public static void create4(ArrayList<Edge>[] graph){
        // filling the empty arraylist.
        for(int x=0; x<graph.length; x++){
            graph[x]=new ArrayList<>();
        }
        /*
                       0
                      / \
                     /   \
                    V     V
                    2     1
                    \     /
                     \   /
                      V V
                       3
         */
        // vertex - 0.
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        // vertex - 1.
        graph[1].add(new Edge(1, 3, 1));
        // vertex - 2.
        graph[2].add(new Edge(2, 3, 1));
    }
    public static boolean isCycleExists(ArrayList<Edge>[] graph){
        /*      No cycle exists here.
                       0
                      / \
                     /   \
                    V     V
                    2     1
                    \     /
                     \   /
                      V V
                       3
         */
        boolean[] visited=new boolean[graph.length];
        boolean[] stack=new boolean[graph.length];
        for(int x=0; x<graph.length; x++){
            if(!visited[x]){
                if(isCycleExistsUtil(graph, x, visited, stack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleExistsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, boolean[] stack){
        visited[curr]=true;
        stack[curr]=true;
        for(int x=0; x<graph[curr].size(); x++){
            Edge e=graph[curr].get(x);
            if(stack[e.dest]){     //   Means the element was visited and in the boolean stack, its value is true. Hence, cycle exists.
                return true;
            }
            if(!visited[e.dest]){
                if(isCycleExistsUtil(graph, e.dest, visited, stack)){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        stack[curr]=false;  // for further recursion and checking for cycle.
        return false;
    }
    public static void create5(ArrayList<Edge>[] graph){
        // inserting the null and new arraylists in graph.
        for(int x=0; x< graph.length; x++){
            graph[x]=new ArrayList<>();
        }
        // vertex - 2;
        graph[2].add(new Edge(2, 3, 1));
        // vertex - 3;
        graph[3].add(new Edge(3, 1, 1));
        // vertex - 4;
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        // vertex - 5;
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
    }
    public static void topoSort1(ArrayList<Edge>[] graph){
        boolean[] visited=new boolean[graph.length];
        Stack<Integer> st=new Stack<>();
        for(int x=0; x<graph.length; x++){
            if(!visited[x]){
                topoSortUtil1(graph, x, visited, st);       // Using modified DFS.
            }
        }
        // printing the elements in the order of topological order.
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
    }
    public static void topoSortUtil1(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> st){
        visited[curr]=true;
        for(int x=0; x<graph[curr].size(); x++){
            Edge e=graph[curr].get(x);
            if(!visited[e.dest]){
                topoSortUtil1(graph, e.dest, visited, st);
            }
        }
        // When all neighbors are visited then finally pushing the current element into the stack.
        st.push(curr);
    }
    public static void create6(ArrayList<Edge>[] graph){
        // inserting the empty arraylist in graph
        for(int x=0; x<graph.length; x++){
            graph[x]=new ArrayList<>();
        }
        /*
                       5       4
                       |\     / \
                       | V   V   \
                       |   0      \
                       |           \
                       |            \
                       V             V
                       2 ---> 3 ---> 1
         */
        // vertex - 2
        graph[2].add(new Edge(2, 3, 1));
        // vertex - 3
        graph[3].add(new Edge(3, 1, 1));
        // vertex - 5
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
        // vertex - 4
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
    }
    public static void inDegreeCalc(ArrayList<Edge>[] graph, int[] inDegree){       // used to calculate the incoming edges for all vertices.
        // we calculate here the total no.of inDegrees for all vertices.
        for(int x=0; x<graph.length; x++){
            for(int y=0; y<graph[x].size(); y++){
                Edge e=graph[x].get(y);     // x denotes the current vertices.
                inDegree[e.dest]++;     // Increment in the inDegree for the next as current will be source. As incoming for dest is outgoing for source.
            }
        }
    }
    public static void topoSort2(ArrayList<Edge>[] graph){      // Using BFS approach.
        int[] inDegree=new int[graph.length];   // for calculating the in-degree edges of all the vertices.
        // Calculating the in-degree of all vertices.
        inDegreeCalc(graph, inDegree);
        Queue<Integer> q=new LinkedList<>();       // to store the vertices whose in-degree count is zero.
        // Firstly, adding the vertices whose in-degree is zero. That means they don't have incoming nodes, they are starting point.
        for(int x=0; x<inDegree.length; x++){
            if(inDegree[x]==0){
                q.add(x);
            }
        }
        // using BFS.
        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr + " ");
            // checking for the neighbors of the current.
            for(int x=0; x<graph[curr].size(); x++){
                Edge e=graph[curr].get(x);
                // decrement for dest counts as we visit it.
                inDegree[e.dest]--;
                if(inDegree[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
    }
    public static void create7(ArrayList<Edge>[] graph){
        // inserting the empty arraylist in graph
        for(int x=0; x<graph.length; x++){
            graph[x]=new ArrayList<>();
        }
        /*
                       5       4
                       |\     / \
                       | V   V   \
                       |   0      \
                       |    \      \
                       |     |      \
                       V     V       V
                       2 ---> 3 ---> 1
         */
        // vertex - 0
        graph[0].add(new Edge(0, 3, 1));
        // vertex - 2
        graph[2].add(new Edge(2, 3, 1));
        // vertex - 3
        graph[3].add(new Edge(3, 1, 1));
        // vertex - 5
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
        // vertex - 4
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
    }
    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, StringBuilder path){
        if(src==dest){
            System.out.println(path);
            return;
        }
        else{
            for(int x=0; x<graph[src].size(); x++){
                Edge e=graph[src].get(x);
                printAllPaths(graph, e.dest, dest, path.append(Integer.toString(src)));
                path.deleteCharAt(path.length()-1);
            }
        }
    }
    public static void create8(ArrayList<Edge>[] graph){
        // inserting the empty arraylist in the graph;
        for(int x=0; x<graph.length; x++){
            graph[x]=new ArrayList<>();
        }
        /*
                                  (7)
                                1 --> 3
                               ^|     ^ \ (1)
                          (2) / |(1)  |  v
                             0  |  (2)|  5
                         (4) \  |     |  ^
                              V V     | / (5)
                                2 --> 4
                                  (3)
         */
        // vertex - 0;
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        // vertex - 1;
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        // vertex - 2;
        graph[2].add(new Edge(2, 4, 3));
        // vertex - 3;
        graph[3].add(new Edge(3, 5, 1));
        // vertex - 4;
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        public Pair(int n, int path){
            this.n=n;
            this.path=path;
        }
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }
    }
    public static void dijkstra(ArrayList<Edge>[] graph, int src){
        int[] dist=new int[graph.length];
        // initializing the values of all vertices except source vertex to infinity.
        for(int x=0; x<graph.length; x++){
            if(x!=src){
                dist[x]=Integer.MAX_VALUE;
            }
        }
        // starting main logic.
        boolean[] visited=new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>();   // used to store objects and retrieval of an object with a minimum path.
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!visited[curr.n]){
                visited[curr.n]=true;
                // for neighbors.
                for(int x=0; x<graph[curr.n].size(); x++){
                    Edge e=graph[curr.n].get(x);
                    if(dist[e.src]+e.wt<dist[e.dest]){
                        dist[e.dest]=dist[e.src]+e.wt;  // updating the distance from source to destination.
                        pq.add(new Pair(e.dest, dist[e.dest]));
                    }
                }
            }
        }
        // finally, printing the shortest distance from source to destination.
        for(int x=0; x<dist.length; x++){
            System.out.print(dist[x] + " ");
        }
        System.out.println();
    }
    public static void create9(ArrayList<Edge>[] graph){
        // inserting empty arraylist in the graph.
        for(int x=0; x<graph.length; x++){
            graph[x]=new ArrayList<>();
        }
        /*
                Consider,
                                          (-1)
                                    1 <--------- 4
                                   ^ |           ^
                              (2) /  \  (-4)     |  (4)
                                 /    V           \
                                0 ---> 2 --------> 3
                                   (4)      (2)
         */
        // vertex - 0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        // vertex - 1
        graph[1].add(new Edge(1, 2, -4));
        // vertex - 2
        graph[2].add(new Edge(2, 3, 2));
        // vertex - 3
        graph[3].add(new Edge(3, 4, 4));
        // vertex - 4
        graph[4].add(new Edge(4, 1, -1));
    }
    public static void bellmanAlgo(ArrayList<Edge>[] graph, int src){
        int[] dist=new int[graph.length];
        // inserting the distance as infinity initially for all vertices.
        for(int x=0; x<dist.length; x++){
            if(x!=src) {
                dist[x] = Integer.MAX_VALUE;
            }
        }
        int V=graph.length;
        for(int x=0; x<V-1; x++){                   // O(V*E)
            // operations for the vertices of graph.
            for(int y=0; y<graph.length; y++){
                for(int z=0; z<graph[y].size(); z++){
                    Edge e=graph[y].get(z);
                    if(dist[e.src]!=Integer.MAX_VALUE && dist[e.src]+e.wt<dist[e.dest]){
                        dist[e.dest]=dist[e.src]+e.wt;
                    }
                }
            }
        }
        // printing the shortest path.
        for(int x=0; x<dist.length; x++){
            System.out.print(dist[x] + " ");
        }
        System.out.println();
    }
    public static void create10(ArrayList<Edge>[] graph){
        // inserting vertices in graph.
        for(int x=0; x<graph.length; x++){
            graph[x]=new ArrayList<>();
        }
        // vertex - 0
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        // vertex - 1
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        // vertex - 2
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        // vertex - 3
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }
    static class Pair2 implements Comparable<Pair2>{
        int v;      // vertex.
        int cost;
        public Pair2(int v, int c){
            this.v=v;
            this.cost=c;
        }
        public int compareTo(Pair2 p2){
            return this.cost-p2.cost;       // less cost will be prioritized.
        }
    }
    public static void primsAlgo(ArrayList<Edge>[] graph){
        boolean[] visited=new boolean[graph.length];
        PriorityQueue<Pair2> pq=new PriorityQueue<>();
        pq.add(new Pair2(0, 0));
        int finalCost=0;
        while(!pq.isEmpty()){
            Pair2 curr=pq.remove();
            if(!visited[curr.v]){
                visited[curr.v]=true;
                finalCost+=curr.cost;
                // performing operations on the neighbors of current.
                for(int x=0; x<graph[curr.v].size(); x++){
                    Edge e=graph[curr.v].get(x);
                    pq.add(new Pair2(e.dest, e.wt));
                }
            }
        }
        // printing the cost of MST.
        System.out.println("Final minimum cost of MST is: " + finalCost);
    }

//    Questions.

    public static void create11(int[][] flights, ArrayList<Edge>[] graph){
        // inserting empty arraylist.
        for(int x=0; x<graph.length; x++){
            graph[x]=new ArrayList<>();
        }
        for(int x=0; x<flights.length; x++){
            int src=flights[x][0];
            int dest=flights[x][1];
            int wt=flights[x][2];
            Edge e=new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }
    static class Info{
        int cost;
        int v;      // vertex
        int stops;      // stops from src to current.
        public Info(int v,int c, int s){
            this.cost=c;
            this.v=v;
            this.stops=s;
        }
    }
    public static int cheapestFlight(int src, int dest, int k, ArrayList<Edge>[] graph){
        int[] dist=new int[graph.length];
        // inserting initial values of paths of each vertex to infinity except src.
        for(int x=0; x<dist.length; x++){
            if(x!=src){
                dist[x]=Integer.MAX_VALUE;
            }
        }
        Queue<Info> q=new LinkedList<>();
        /*
         Priority queue is not used because the sorting is done on the basis of stops not price.
         Also, as we iterate, all the vertices corresponding stops will increase and get added in queue
         in increasing order.
         */
        // Initially adding the source and its info.
        q.add(new Info(src, 0 , 0));
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr.stops>k){
                break;
            }
            else{
                for(int x=0; x<graph[curr.v].size(); x++){
                    Edge e=graph[curr.v].get(x);
                    if(curr.cost+e.wt<dist[e.dest]  && curr.stops<=k){
                        dist[e.dest]=dist[e.src]+e.wt;
                        q.add(new Info(e.dest, dist[e.dest], curr.stops+1));
                    }
                }
            }
        }
        if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dist[dest];
        }

    }
    static class Edge2 implements Comparable<Edge2>{
        int dest;
        int cost;
        public Edge2(int d, int c){
            this.dest=d;
            this.cost=c;
        }
        @Override
        public int compareTo(Edge2 e2){
            return this.cost-e2.cost;       // sorting on the basis of cost in ascending order.
        }
    }
    public static int connectCitiesMinCost(int[][] cities){
        PriorityQueue<Edge2> pq=new PriorityQueue<>();
        boolean[] visited=new boolean[cities.length];
        int finalCost=0;
        pq.add(new Edge2(0, 0));
        while(!pq.isEmpty()){
            Edge2 curr=pq.remove();
            if(!visited[curr.dest]){
                visited[curr.dest]=true;
                finalCost+=curr.cost;
                // adding the neighbors in the priority queue.
                for(int x=0; x<cities[curr.dest].length; x++){
                    if(cities[curr.dest][x]!=0){
                        pq.add(new Edge2(x, cities[curr.dest][x]));
                    }
                }
            }
        }
        return finalCost;
    }
    public static void helper(int[][] image, int sr, int sc, boolean[][] visited, int color, int orgColor){     // O(m*n)
        // orgColor - original/initial color of the pixel.
        if(sr<0 || sc<=0 || sr>=image[0].length || sc>=image.length || visited[sr][sc] || image[sr][sc]!=orgColor){
            return;
        }
        // Now, moving towards the left from the pixel location.
        helper(image, sr, sc-1, visited, color, orgColor);
        // Now, moving towards the right of the pixel location.
        helper(image, sr, sc+1, visited, color, orgColor);
        // Now, moving upwards from the pixel location.
        helper(image, sr-1, sc, visited, color, orgColor);
        // Now, moving downwards from the pixel location.
        helper(image, sr+1, sc, visited, color, orgColor);
    }
    public static int[][] floodFillAlgo(int[][] image, int sr, int sc, int color){
        // sr - starting row, sc - starting column.
        boolean[][] visited=new boolean[image.length][image[0].length];
        helper(image, sr, sc, visited, color, image[sr][sc]);
        return image;
    }

    static class DisjointSet{
        public static int n=7;
        public static int[] parent=new int[n];      // used to store the parent of the numbers.
        public static int[] rank=new int[n];        // used to store the ranks of the numbers.
        public static void initialize(){
            for(int x=0; x<parent.length; x++){
                parent[x]=x;        // initially, the number itself is the parent.
            }
        }
        public static int find(int x){          // used to find the final parent of the number in a set.
            if(parent[x]==x){
                return x;
            }
            else{
                return find(parent[x]);
            }
        }
        public static void union(int a, int b){
            // finding the actual/final parents of a and b.
            int parA=find(a);
            int parB=find(b);
            if(rank[parA]==rank[parB]){
                rank[parA]++;               // increasing the rank of a.
                parent[parB]=parA;          // changing the parent of b to the parent of a.
            }
            else if(rank[parA]<rank[parB]){
                parent[parA]=parB;      // if the rank of parent of a is less than parent of b, then parent of a will be attached to parent of b.
            }
            else{
                parent[parB]=parA;
            }
        }
    }
    public static DisjointSet ds=new DisjointSet();
    static class Edge3 implements Comparable<Edge3>{
        int src;
        int dest;
        int wt;
        public Edge3(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
        @Override
        public int compareTo(Edge3 e2){
            return this.wt-e2.wt;           // comparing on the basis of weight of the edge.
        }
    }
    public static void create12(ArrayList<Edge3> edges){
        edges.add(new Edge3(0, 1, 10));
        edges.add(new Edge3(0, 2, 15));
        edges.add(new Edge3(0, 3, 30));
        edges.add(new Edge3(1, 3, 40));
        edges.add(new Edge3(2, 3, 50));
    }
    public static void kruskalsAlgo(ArrayList<Edge3> edges, int V){
        ds.initialize();        // initializing the parent array.
        Collections.sort(edges);
        int finalCost=0;
        int count=0;
        for(int x=0; count<V-1; x++){
            Edge3 curr=edges.get(x);
            // finding the parents of source and destination.
            int parA=ds.find(curr.src);     // parent of source
            int parB=ds.find(curr.dest);    // parent of destination
            // Note that, if the parents are equal of source and destination, that means there cycle exists. Hence, nothing to do.
            if(parA!=parB){
                ds.union(curr.src, curr.dest);      // taking union of the source and destination and updating their parents/
                finalCost+=curr.wt;
                count++;
            }
        }
        System.out.println("The cost required to build MST using kruskal's algo is: " + finalCost);
    }


    public static void main(String[] args){


//        Graphs.

//        Creating graph using an Adjacency list.
        /*
                            (5)
                       0----------- 1
                                   / \
                             (1)  /   \  (3)
                                 /     \
                                2 ----- 3
                                |  (1)
                           (2)  |
                                |
                                4

         */
//        int V=5;        // No.of vertices==array size;
//        ArrayList<Edge>[] graph=new ArrayList[V];   // this is null -> empty firstly.
//        // filling the arraylists in the array.
//        for(int x=0; x<graph.length; x++){
//            graph[x]=new ArrayList<>();
//        }
//        // 0 - vertex.
//        graph[0].add(new Edge(0, 1, 5));
//        // 1 - vertex.
//        graph[1].add(new Edge(1, 3, 3));
//        graph[1].add(new Edge(1, 2, 1));
//        graph[1].add(new Edge(1, 0, 5));
//        // 2 - vertex.
//        graph[2].add(new Edge(2, 1, 1));
//        graph[2].add(new Edge(2, 3, 1));
//        graph[2].add(new Edge(2, 4, 2));
//        // 3 - vertex.
//        graph[3].add(new Edge(3, 1, 3));
//        graph[3].add(new Edge(3, 2, 1));
//        // 4 - vertex.
//        graph[4].add(new Edge(4, 2, 2));
//
//        // printing the lists of connections between nodes.
//        for(ArrayList al:graph){
//
//            for(Object e:al){
//                Edge curr= (Edge) e;
//                System.out.println("From -> " + curr.src + " to " + curr.dest);
//            }
//            System.out.println();
//        }

//        Traversing the graph.
        /*      Types:
                1. Breadth-first search(BFS)
                2. Depth-first search(DFS)
         */

        /*
                1 --- 3
               /      | \
              0       |  5 --- 6
               \      | /
                2 --- 4
         */
//        ArrayList<Edge>[] graph=new ArrayList[7];
//        boolean[] visited=new boolean[graph.length];
//        create1(graph);     // creating graph.
//            BFS.
//        breadthFirstSearch(graph, visited);
//            DFS.
//        depthFirstSearch(graph, 0, visited);

//        Has a Path.
        // for a given src and dest, tell if a path exists from src to dest.
//        ArrayList<Edge>[] graph=new ArrayList[7];
//        boolean[] visited=new boolean[graph.length];
//        create1(graph);     // creating graph.
//        System.out.println(hasPath(graph, 0, 5, visited));

//        Cyclic graph.
//        Cycle detection in undirected graph.
        /*
                0 --- 3
              / |     |
             1  |     4
              \ |
                2
         */
//        ArrayList<Edge>[] graph=new ArrayList[5];
//        create2(graph);
//        System.out.println(cycleDetector(graph));

//        Bipartite graph.
        /*
                A Bipartite Graph is a graph whose vertices can be divided into two independent sets,
                U and V such that every edge(u, v) either connects a vertex from U to V or vertex from
                V to U. In other words, for every edge(u,v), either u belongs to U and v to V or u belongs
                to V and v to U. We can also say that there is no edge that connects vertices of same set.
         */
//        Checking whether a graph is bipartite or not.
        /*
            Note: 1. for no color - -1.
                  2. for yellow - 0.
                  3. for blue - 1.
         */
        /*      Note - If the graph does not contain ant cycle, then it is Bipartite graph.
                    0 ------ 2
                   /        /
                  /       /         Ans - False.
                 1       4
                  \     /
                   \  /
                    3
         */
//        ArrayList<Edge>[] graph=new ArrayList[5];
//        create3(graph);
//        System.out.println("Is the given graph Bipartite? - " + isBipartite(graph));

//        Cycle Detection in directed graph.

        /*      No cycle exists here.
                       0
                      / \
                     /   \
                    V     V
                    2     1
                    \     /
                     \   /
                      V V
                       3
         */

//        ArrayList<Edge>[] graph=new ArrayList[4];
//        create4(graph);
//        System.out.println(isCycleExists(graph));

//        Topological Sorting.
        /*
                Directed Acyclic Graph (DAG) is a directed graph with no cycles.
                Topological sorting is used to DACs. It is a linear order of
                vertices such that every directed edge u->v, the vertex u comes
                before v in the order.
         */
//        ArrayList<Edge>[] graph=new ArrayList[6];
//        create5(graph);
//        topoSort1(graph);

//        Topological sort using BFS.
        /*
            This sorting is performed using Kahn's algorithm.

           Note - 1. in-degree: incoming edges.
                  2. out-degree: outgoing edges.
           Consider,
                       5       4
                       |\     / \
                       | V   V   \
                       |   0      \
                       |           \
                       |            \
                       V             V
                       2 ---> 3 ---> 1

           In-degrees for every element will be,

                0   1   2   3   4   5
     in-degree  2   2   1   1   0   0
    out-degree  0   0   1   1   2   2

Fact - A DAG has at least one vertex with in-degree 0 and one vertex ith out-degree 0
         */

//        ArrayList<Edge>[] graph=new ArrayList[6];
//        create6(graph);
//        topoSort2(graph);

//        All paths from source to target.
        /*
                       5       4
                       |\     / \
                       | V   V   \
                       |   0      \
                       |    \      \
                       |     |      \
                       V     V       V
                       2 ---> 3 ---> 1
         */
//        ArrayList<Edge>[] graph=new ArrayList[6];
//        create7(graph);
//        printAllPaths(graph, 5, 1, new StringBuilder());

//        Dijkstra's Algorithm.
//        The shortest paths orm the source to all vertices (weighted graph).
        /*
                Main formula: if dist[u]+ weight(u,v)<dist[v].
                          then, update the distance of v dist[v] as, dist[v]=ist[u]+ weight(u,v).
                - We use here Priority queue as we are finding the shortest path. Hence, the order
                 will be maintained of all paths, and we get the shortest one.

                Consider,         (7)
                                1 --> 3
                               ^|     | \ (1)
                          (2) / |(1)  |  v
                             0  |  (2)|  5
                         (4) \  |     |  ^
                              V V     V / (5)
                                2 --> 4
                                  (3)
         */
//        ArrayList<Edge>[] graph=new ArrayList[6];
//        create8(graph);
//        dijkstra(graph, 0);

//        Bellman Ford Algorithm.
        // The shortest paths from the source to all vertices.(negative edges)
        /*
                Consider,
                                          (-1)
                                    1 <--------- 4
                                   ^ |           ^
                              (2) /  \  (-4)     |  (4)
                                 /    V           \
                                0 ---> 2 -------- 3
                                   (4)      (2)
         */
//        ArrayList<Edge>[] graph=new ArrayList[5];
//        create9(graph);
//        bellmanAlgo(graph, 0);

//        Minimum Spanning Tree (MST)
        /*
                A MST or minimum weight spanning tree is a subset of the edges of a
                connected, edge-weighted undirected graph that connects all the
                vertices together, without any cycles and with the minimum possible
                total edge weight.
                We are using Prim's Algorithm to determine this MST.
         */
//        ArrayList<Edge>[] graph=new ArrayList[4];
//        create10(graph);
//        primsAlgo(graph);

//        Cheapest Flights within K stops.
        /*
                There are n cities connected by some number of flights. You are given an array
                flights where flights[i]=[from, to, price] indicates that there is a flight.
                You are also given three src, dst, and k, return the cheapest price from src to dst
                with at most k stops. If there is no such route, return -1.
         */
//        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3 ,600}, {2, 3, 200}};
//        int src=0, dst=3, k=1;      // k is the no.of stops allowed form src to dst.
//        ArrayList<Edge>[] graph=new ArrayList[4];
//        create11(flights, graph);
//        System.out.println("The cheapest price from source to destination is: " + cheapestFlight(src, dst, k, graph));

//        Connecting cities with minimum cost.
        /*
                Find the minimum cost for connecting all the cities on the map.
                Prims's algorithm is used.
         */
//        int[][] cities={{0, 1, 2, 3, 4},
//                        {1, 0, 5, 0, 7},
//                        {2, 5, 0, 6, 0},
//                        {3, 0, 6, 0, 0},
//                        {4, 7, 0, 0, 0}};
//        System.out.println("The minimum cost to connect all the cities is: " + connectCitiesMinCost(cities));

//        Disjoint set data structure.
//        // Initializing the sets with their parents and their rank.
//        ds.initialize();
//        System.out.println("The parent of 3 is: " + ds.find(3));
//        ds.union(1, 3);
//        System.out.println("The parent of 3 is: " + ds.find(3));
//        ds.union(2, 4);
//        ds.union(3, 6);
//        ds.union(1, 4);
//        System.out.println("Parent of 3 is: " + ds.find(3));
//        System.out.println("Parent of 4 is: " + ds.find(4));
//        ds.union(1, 5);

//        Kruskal's Algorithm.
        // forming the graph without an array.
//        int V=4;
//        ArrayList<Edge3> edges=new ArrayList<>();
//        create12(edges);
//        ds.n=4;
//        kruskalsAlgo(edges, V);

//        Flood fill algorithm.
        /*
                Given a m x n integer grid image where image[i][j] represents the pixel
                value of the image. You are also given three sr, sc, and color. You should perform
                flood fill on the image starting from the pixel image[sr][sc].
                To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally
                to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned
                pixels with color.
         */


















    }
}
