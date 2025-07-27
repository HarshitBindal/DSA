class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxrow = 0, maxcol = 0;
        for(int i=0; i<n; i++){
            maxrow = Math.max(maxrow, stones[i][0]);
            maxcol = Math.max(maxcol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxrow + maxcol + 2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int noderow = stones[i][0];
            int nodecol = stones[i][1] + maxrow + 1;
            ds.unionBySize(noderow, nodecol);
            map.put(noderow, 1);
            map.put(nodecol, 1);
        }
        int cnt = 0;
        for(Map.Entry<Integer, Integer> curr: map.entrySet()){
            if(ds.findpar(curr.getKey())==curr.getKey()){
                cnt++;
            }
        }
        return n-cnt;
    }
}
class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0; i<n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findpar(int node){
        if(node == parent.get(node)){
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
            size.set(pu, size.get(pu)+size.get(pv));
            parent.set(pv, pu);
        } else {
            size.set(pv, size.get(pu)+size.get(pv));
            parent.set(pu, pv);
        }
    }
}