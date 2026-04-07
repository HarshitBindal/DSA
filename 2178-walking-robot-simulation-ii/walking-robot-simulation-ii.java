class Robot {
    int x;
    int y;
    int width, height;
    String dir;
    public Robot(int width, int height) {
        this.x = 0;
        this.y = 0;
        this.dir = "East";
        this.width = width;
        this.height = height;
    }
    
    public void step(int num) {
        int peri = 2*(height-1) + 2*(width-1);
        num = num%peri;
        if(num==0) num = peri;
        while(num>0){
            int nx=x;
            int ny=y;
            if(dir.equals("East")){
                int maxX = Math.min(x+num, width-1);
                int rem = num-(maxX-x);
                num = rem;
                if(rem==0) x = maxX;
                else{
                    x = maxX;
                    dir = "North";
                }
            }
            else if(dir.equals("North")){
                int maxY = Math.min(y+num, height-1);
                int rem = num-(maxY-y);
                num = rem;
                if(rem==0) y = maxY;
                else{
                    y = maxY;
                    dir = "West";
                }
            }
            else if(dir.equals("West")){
                int minX = Math.max(x-num, 0);
                int rem = num-(x-minX);
                num = rem;
                if(rem == 0) x = minX;
                else{
                    x = minX;
                    dir="South";
                }
            }
            else{
                int minY = Math.max(y-num, 0);
                int rem = num-(y-minY);
                num = rem;
                if(rem==0) y=minY;
                else{
                    y = minY;
                    dir = "East";
                }
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{x,y};
    }
    
    public String getDir() {
        return dir;
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */