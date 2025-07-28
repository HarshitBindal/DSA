class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        DisjointSet ds = new DisjointSet(n*n);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0) continue;
                for(int k=0; k<4; k++){
                    int nrow = drow[k] + i;
                    int ncol = dcol[k] + j;
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<n && grid[nrow][ncol]==1){
                        int node = i*n+j;
                        int adjNode = nrow*n + ncol;
                        ds.unionBySize(node, adjNode);
                    }
                }
            }
        }
        int maxi = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1) continue;
                HashSet<Integer> set = new HashSet<>();
                for(int k=0; k<4; k++){
                    int nrow = drow[k] + i;
                    int ncol = dcol[k] + j;
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<n && grid[nrow][ncol]==1){
                        set.add(ds.findpar(nrow*n + ncol));
                    }
                }
                int sizeTotal = 0;
                for(Integer parent: set){
                    sizeTotal += ds.size.get(parent);
                }
                maxi = Math.max(maxi, sizeTotal+1);
            }
        }
        for(int cell=0; cell<n*n; cell++){
            maxi = Math.max(maxi, ds.size.get(ds.findpar(cell)));
        }
        return maxi;
    }
}
class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0; i<n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findpar(int node){
        if(parent.get(node)==node){
            return node;
        }
        int ulp = findpar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionBySize(int u, int v){
        int pu = findpar(u);
        int pv = findpar(v);
        if(pu == pv) return;
        if(size.get(pu)>size.get(pv)){
            parent.set(pv, pu);
            size.set(pu, size.get(pu)+size.get(pv));
        } else {
            parent.set(pu, pv);
            size.set(pv, size.get(pu)+size.get(pv));
        }
    }
}