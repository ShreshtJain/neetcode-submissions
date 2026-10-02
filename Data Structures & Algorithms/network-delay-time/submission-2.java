class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Build the directed weighted graph.
        // Each edge is represented as:
        // u -> {v, weight}
        Graph g = new Graph(n);
        g.addEdges(times);

        // distance[i] = shortest known time required to reach node i from k.
        // We use n + 1 because the nodes are numbered from 1 to n.
        int[] distance = new int[n + 1];

        // Initially, we don't know the shortest distance to any node.
        // Integer.MAX_VALUE represents "unreachable / not discovered yet".
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Node 0 is not a real node in this problem.
        // Setting it to 0 prevents it from being treated as unreachable
        // when we later iterate over the entire distance array.
        distance[0] = 0;

        // The starting node k has distance 0 because it takes no time
        // to reach the starting node from itself.
        distance[k] = 0;

        // PriorityQueue always gives us the node with the smallest
        // currently known distance.
        //
        // This is the key property that allows Dijkstra's algorithm
        // to efficiently find shortest paths.
        //
        // arr[0] = node
        // arr[1] = distance from k to that node
        PriorityQueue<int[]> pq =
                new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);

        // Start Dijkstra's algorithm from node k.
        pq.offer(new int[]{k, 0});

        // We ultimately need the maximum shortest distance because
        // networkDelayTime asks:
        // "How long until ALL nodes receive the signal?"
        //
        // Therefore, after finding all shortest paths, the answer is
        // the longest among those shortest paths.
        int sum = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {

            // Get the node having the smallest currently known distance.
            int[] arr = pq.poll();

            int u = arr[0]; // Current node
            int w = arr[1]; // Distance from k to u

            /*
             * A node can be inserted into the PriorityQueue multiple times.
             *
             * Example:
             *     k -> u = 10
             * Later we discover:
             *     k -> v -> u = 5
             *
             * So the queue may contain:
             *     {u, 10}
             *     {u, 5}
             *
             * When {u, 10} is eventually removed, distance[u] is already 5.
             *
             * Therefore this is a stale/outdated entry and we don't need
             * to process u again using the longer distance.
             */
            if (w > distance[u])
                continue;

            // Explore all outgoing edges from the current node u.
            for (int[] arr2 : g.adj.get(u)) {

                int v = arr2[0]; // Neighbor node
                int d = arr2[1]; // Weight of edge u -> v

                // If we reach v through u, this would be the total
                // distance from k to u plus the edge weight u -> v.
                int newDistance = w + d;

                /*
                 * If this path is shorter than the best path we have
                 * previously found for v, update the shortest distance.
                 */
                if (distance[v] > newDistance) {

                    distance[v] = newDistance;

                    /*
                     * Add the updated distance to the PriorityQueue.
                     *
                     * We don't remove the old entry from the queue.
                     * Instead, we leave it there and ignore it later
                     * using the "stale entry" check above.
                     */
                    pq.offer(new int[]{v, newDistance});
                }
            }
        }

        /*
         * At this point, Dijkstra has calculated the shortest distance
         * from k to every reachable node.
         *
         * We need the maximum shortest distance because the signal
         * reaches the nodes at different times.
         *
         * Example:
         * distance = [0, 2, 5, 3]
         *
         * The last node receives the signal at time 5.
         */
        for (int i : distance) {

            // If any node still has Integer.MAX_VALUE,
            // that node was never reachable from k.
            //
            // Therefore the signal cannot reach every node.
            if (i == Integer.MAX_VALUE)
                return -1;

            // Find the longest shortest-path distance.
            if (i > sum)
                sum = i;
        }

        return sum;
    }
}


class Graph {

    int n;

    /*
     * Adjacency list representation of the graph.
     *
     * adj.get(u) contains all outgoing edges from node u.
     *
     * Each int[] contains:
     *     [0] = destination node
     *     [1] = edge weight
     */
    ArrayList<ArrayList<int[]>> adj;

    Graph(int n) {
        this.n = n;

        // Create the outer ArrayList.
        this.adj = new ArrayList<ArrayList<int[]>>();

        /*
         * Nodes are numbered 1 through n.
         *
         * We create n + 1 lists so that:
         *     adj.get(1) -> edges from node 1
         *     adj.get(2) -> edges from node 2
         *     ...
         *     adj.get(n) -> edges from node n
         *
         * Index 0 is unused.
         */
        for (int i = 0; i <= n; i++) {
            this.adj.add(new ArrayList<int[]>());
        }
    }

    void addEdges(int[][] times) {

        /*
         * Each entry in times is:
         *
         *     [source, destination, travelTime]
         *
         * For example:
         *     [2, 3, 4]
         *
         * means:
         *     2 -> 3 with weight 4
         */
        for (int[] time : times) {

            // Store:
            // arr[0] = destination
            // arr[1] = weight
            int[] arr = new int[2];

            arr[0] = time[1];
            arr[1] = time[2];

            // Add the edge to the adjacency list of the source node.
            adj.get(time[0]).add(arr);
        }
    }
}