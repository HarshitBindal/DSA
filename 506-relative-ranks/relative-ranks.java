class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0; i<score.length; i++){
            pq.add(new int[]{score[i], i});
        }
        String[] res = new String[score.length];
        int i=0;
        int baaki = 4;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(i==0) res[curr[1]] = "Gold Medal";
            else if(i==1) res[curr[1]] = "Silver Medal";
            else if(i==2) res[curr[1]] = "Bronze Medal";
            else{
                res[curr[1]] = Integer.toString(baaki);
                baaki++;
            } 
            i++;
        }
        return res;
    }
}