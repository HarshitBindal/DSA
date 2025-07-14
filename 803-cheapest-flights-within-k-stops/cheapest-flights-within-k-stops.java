class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] {0, src, 0});
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], city = curr[1], stops = curr[2];

            // we reached destination
            if(city == dst) return cost;
            // stops exceeding limit k
            if(stops>k || stops>=visited[city]) continue;
            visited[city] = stops;

            for(int[] neighbour: graph.get(city)){
                int nextcity = neighbour[0];
                int nextcost = neighbour[1];
                pq.add(new int[]{cost+nextcost, nextcity, stops+1});
            }
        }
        return -1;
    }
}