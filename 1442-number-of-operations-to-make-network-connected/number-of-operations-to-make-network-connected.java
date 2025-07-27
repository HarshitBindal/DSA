class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        DisjointSet ds = new DisjointSet(n);
        int components = 0;
        int extra = 0;
        for(int[] conn: connections){
            int u = conn[0];
            int v = conn[1];
            if(ds.findpar(u)==ds.findpar(v)){
                extra++;
            } else ds.unionBySize(u, v);
        }
        for(int i=0; i<n; i++){
            if(ds.parent.get(i)==i) components++;
        }
        return extra>=components-1? components-1: -1;
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
            size.set(pv, size.get(pv)+size.get(pu));
            parent.set(pv, pu);
        } else {
            size.set(pu, size.get(pu)+size.get(pv));
            parent.set(pu, pv);
        }
    }
}