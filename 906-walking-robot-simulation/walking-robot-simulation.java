class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> set = new HashSet<>();
        for(int[] it: obstacles){
            set.add(it[0]+","+it[1]);
        }
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int x = 0;
        int y = 0;
        int dir=0;
        int maxDist = 0;
        for(int cmd: commands){
            if(cmd==-1){
                dir = (dir+1)%4;
            }
            else if(cmd==-2){
                dir = (dir+3)%4;
            }
            else{
                while(cmd-->0){
                    int nx = x+directions[dir][0];
                    int ny = y+directions[dir][1];
                    if(set.contains(nx+","+ny)){
                        break;
                    }
                    maxDist = Math.max(maxDist, nx*nx + ny*ny);
                    x = nx;
                    y = ny;
                }
            }
        }
        return maxDist;
    }
}