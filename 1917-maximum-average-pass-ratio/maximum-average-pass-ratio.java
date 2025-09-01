class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<int[]> gains = new PriorityQueue<>((a,b)->{
            double gainA = gain(a[0], a[1]);
            double gainB = gain(b[0], b[1]);
            return Double.compare(gainB, gainA);
        });
        for(int[] pair: classes){
            gains.add(new int[]{pair[0], pair[1]});
        }
        while(extraStudents>0){
            int[] curr = gains.poll();
            curr[0]++;
            curr[1]++;
            gains.add(curr);
            extraStudents--;
        }
        double total = 0.0;
        while(!gains.isEmpty()){
            int[] curr = gains.poll();
            total += (double)curr[0]/curr[1];
        }
        return total/n;
    }
    private double gain(int a, int b){
        return (double)(a+1)/(b+1) - (double)a/b;
    }
}