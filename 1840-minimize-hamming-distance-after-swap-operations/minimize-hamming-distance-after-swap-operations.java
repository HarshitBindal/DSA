class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DisjointSet dsu = new DisjointSet(n);
        for(int[] swap: allowedSwaps){
            dsu.unionSize(swap[0], swap[1]);
        }
        HashMap<Integer, List<Integer>> groups = new HashMap<>();
        for(int i=0; i<n; i++){
            int node = dsu.findpar(i);
            groups.computeIfAbsent(node, k-> new ArrayList<>()).add(i);
        }
        int res = 0;
        for(List<Integer> group: groups.values()){
            Map<Integer, Integer> map = new HashMap<>();
            for(int idx: group){
                map.put(source[idx], map.getOrDefault(source[idx],0)+1);
            }
            for(int idx: group){
                if(map.getOrDefault(target[idx],0)>0){
                    map.put(target[idx], map.get(target[idx])-1);
                } else {
                    res++;
                }
            }
        }
        return res;
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
        if(parent.get(node)==node) return node;
        int ulp = findpar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    public void unionSize(int u, int v){
        int pu = findpar(u);
        int pv = findpar(v);
        if(size.get(pu)>size.get(pv)){
            parent.set(pv, pu);
            size.set(pu, size.get(pu)+size.get(pv));
        }
        else{
            parent.set(pu, pv);
            size.set(pv, size.get(pu)+size.get(pv));
        }
    }
}