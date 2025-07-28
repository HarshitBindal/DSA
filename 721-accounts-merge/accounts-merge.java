class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            List<String> acc = accounts.get(i);
            for(int j=1; j<acc.size(); j++){
                String email = acc.get(j);
                if(!map.containsKey(email)){
                    map.put(email, i);
                } else {
                    ds.unionBySize(i, map.get(email));
                }
            }
        }
        ArrayList<ArrayList<String>> mergedmail = new ArrayList<>();
        for(int i=0; i<n; i++){
            mergedmail.add(new ArrayList<String>());
        }
        for(Map.Entry<String, Integer> curr: map.entrySet()){
            String mail = curr.getKey();
            int node = ds.findpar(curr.getValue());
            mergedmail.get(node).add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(mergedmail.get(i).size()==0) continue;
            Collections.sort(mergedmail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String str: mergedmail.get(i)){
                temp.add(str);
            }
            ans.add(temp);
        }
        return ans;
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
        if(parent.get(node)==node) return node;
        int ulp = findpar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionBySize(int u, int v){
        int pu = findpar(u);
        int pv = findpar(v);
        if(size.get(pu)>size.get(pv)){
            parent.set(pu, pv);
            size.set(pu, size.get(pu)+size.get(pv));
        }
        else {
            parent.set(pv, pu);
            size.set(pv, size.get(pu)+size.get(pv));
        }
    }
}