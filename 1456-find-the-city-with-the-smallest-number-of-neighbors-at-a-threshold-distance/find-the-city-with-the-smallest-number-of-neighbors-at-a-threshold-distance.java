class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat = new int[n][n];
        int[] count = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = Integer.MAX_VALUE/2;
                mat[i][i] = 0;
            }
        }
        for(int[] edge: edges){
            int u = edge[0], v = edge[1], w = edge[2];
            mat[u][v] = w;
            mat[v][u] = w;
        }
        for(int via=0; via<n; via++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    mat[i][j] = Math.min(mat[i][j], mat[i][via]+mat[via][j]);
                }
            }
        }
        for(int i=0; i<n; i++){
            // int count = 0;
            for(int j=0; j<n; j++){
                if(mat[i][j]<=distanceThreshold && i!=j){
                    count[i]++;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        int res = -1;
        for(int i=0; i<n; i++){
            if(count[i]<=ans){
                ans = count[i];
                res = i;
            }
        }
        return res;
    }
}