class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new HashMap<>();
        for(String word: words){
            freq.put(word, freq.getOrDefault(word, 0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(freq.get(a)!=freq.get(b)){
                return freq.get(b)-freq.get(a);
            }
            return a.compareTo(b);
        });
        pq.addAll(freq.keySet());
        List<String> list = new ArrayList<>();
        while(k-->0){
            list.add(pq.poll());
        }
        return list;
    }
}